package com.karatesan.Simple_Github_api.configuration;

import com.karatesan.Simple_Github_api.ecxeption.TooManyRequestsException;
import com.karatesan.Simple_Github_api.ecxeption.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;


/**
 * {@code RestClientConfig} configures a {@link RestClient} bean for use with the GitHub API.
 * The {@code RestClient} is preconfigured to include an authorization header with a GitHub token.
 *
 * <p>To use this configuration, provide the GitHub token in the {@code application.properties} file
 * using the {@code github.token} property. If not provided, the GitHub API request limit is restricted
 * to 60 requests per hour without authorization.
 */
@Configuration
public class RestClientConfig {

    /**
     * The GitHub token used for authorization. This value is injected from the {@code application.properties} file.
     */
    @Value("${github.token}")
    private String authorization;

    /**
     * Creates a {@link RestClient} bean with the authorization header and simple status handler configured.
     *
     * <p>If the {@code github.token} is provided in the {@code application.properties} file, it will
     * be used to set the {@code Authorization} header as {@code "Bearer " + authorization}.
     *
     * @return a {@link RestClient} instance with the preconfigured {@code Authorization} header
     */
    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + authorization)
                .defaultStatusHandler(HttpStatusCode::is4xxClientError, (request, response) -> {
                    if(response.getStatusCode().equals(HttpStatus.NOT_FOUND))
                        throw new UserNotFoundException("User not found.");
                    if(response.getStatusCode().equals(HttpStatus.TOO_MANY_REQUESTS) || response.getStatusCode().equals(HttpStatus.UNAUTHORIZED))
                        throw new TooManyRequestsException("Github API rate limit exceeded");
                })
                .build();
    }
    @Bean
    public RestClient.Builder restClientBuilder(){
        return RestClient.builder();
    }
}
