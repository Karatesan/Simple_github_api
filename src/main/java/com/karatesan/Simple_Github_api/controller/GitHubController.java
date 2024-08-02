package com.karatesan.Simple_Github_api.controller;

import com.karatesan.Simple_Github_api.dto.Response;
import com.karatesan.Simple_Github_api.service.GithubService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@code GitHubController} provides REST endpoints for interacting with the GitHub API.
 * This controller allows fetching repositories for a specific GitHub user.
 */
@RestController
public class GitHubController {

    private final GithubService githubService;

    /**
     * Constructs a {@code GitHubController} with the specified {@code GithubService}.
     *
     * @param githubService the {@code GithubService} used to fetch repository data
     */
    public GitHubController(GithubService githubService) {
        this.githubService = githubService;
    }

    /**
     * Retrieves all non-fork repositories for a specific GitHub user.
     * This endpoint responds only if the {@code Accept} header is set to {@code application/json}.
     *
     * @param username the login of the GitHub user whose repositories are to be fetched
     * @param header the {@code Accept} header value to validate the request
     * @return a list of {@code UserRepositoriesResponse} containing details of the user's repositories, or an empty list if the header is not {@code application/json}
     */
    @GetMapping("/user/repos/{username}")
    public List<Response> getAllReposFromUser(
            @PathVariable String username,
            @RequestHeader(value = HttpHeaders.ACCEPT, defaultValue = "application/json") String header) {

        if (header.equalsIgnoreCase("application/json")) {
            return githubService.fetchRepos(username);
        }
        return List.of();
    }
}
