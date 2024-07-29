package com.karatesan.Simple_Github_api.service;

import com.karatesan.Simple_Github_api.dto.GithubBranchData;
import com.karatesan.Simple_Github_api.dto.GithubRepositoryData;
import com.karatesan.Simple_Github_api.dto.UserRepositoriesResponse;
import com.karatesan.Simple_Github_api.ecxeption.ClientErrorException;
import com.karatesan.Simple_Github_api.ecxeption.TooManyRequestsException;
import com.karatesan.Simple_Github_api.ecxeption.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * {@code GithubService} manages connecting to the external GitHub API. It allows fetching repository data from a provided user.
 */

@Service
public class GithubService {

    private RestClient restClient;

    public GithubService(RestClient restClient) {
        this.restClient = restClient;
    }

    /**
     * Fetches all repositories for a specified user via {@code RestClient}. Only non-fork repositories are included.
     * This method maps the response using {@link #mapToUserRepositoriesResponse(GithubRepositoryData)}.
     *
     * @param username the login of the GitHub user
     * @return a list of {@code UserRepositoriesResponse} containing data about the user's repositories and branches
     * @throws UserNotFoundException if the user with the specified username doesn't exist
     * @throws TooManyRequestsException if the API rate limit is exceeded
     */

    public List<UserRepositoriesResponse> fetchRepos(String username) {
        GithubRepositoryData[] repositories = restClient.get()
                .uri("https://api.github.com/users/{username}/repos", username)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(GithubRepositoryData[].class);

        List<UserRepositoriesResponse> list = Stream.of(repositories)
                .filter(repo -> !repo.isFork())
                .map(this::mapToUserRepositoriesResponse)
                .toList();
        return list;
    }

    /**
     * Fetches all branches for the specified repository from the GitHub API.
     *
     * @param repoName the name of the repository
     * @param username the login of the GitHub user
     * @return a list of {@code GithubBranchData} containing data about the branches of the repository
     * @throws UserNotFoundException if the user or repository with the specified name doesn't exist
     * @throws TooManyRequestsException if the API rate limit is exceeded
     */

    public List<GithubBranchData> fetchAllBranchesFromRepo(String repoName, String username) {
        GithubBranchData[] githubBranchData = restClient.get()
                .uri("https://api.github.com/repos/{username}/{repoName}/branches", username, repoName)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(GithubBranchData[].class);

        return Arrays.asList(githubBranchData);
    }

    /**
     * Maps {@code GithubRepositoryData} to {@code UserRepositoriesResponse}. It also calls {@link #fetchAllBranchesFromRepo(String, String)}
     * to get all branches of the repository.
     *
     * @param repo the {@code GithubRepositoryData} object containing information about the repository
     * @return a {@code UserRepositoriesResponse} containing formatted data from the repository
     */

    public UserRepositoriesResponse mapToUserRepositoriesResponse(GithubRepositoryData repo){
        UserRepositoriesResponse response = new UserRepositoriesResponse();
        response.setRepositoryName(repo.getName());
        response.setOwner(repo.getOwner().getLogin());
        response.setBranches(fetchAllBranchesFromRepo(repo.getName(), repo.getOwner().getLogin()));
        return response;
    }

}
