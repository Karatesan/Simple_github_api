package com.karatesan.Simple_Github_api.dto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public record GithubRepositoryData(String name, String login, boolean fork, @JsonProperty("branches_url") String branchesUrl) {

    @JsonCreator
    public GithubRepositoryData(
            @JsonProperty("name") String name,
            @JsonProperty("owner") Owner owner,
            @JsonProperty("fork") boolean fork,
            @JsonProperty("branches_url") String branchesUrl) {
        this(name, owner.login(), fork, branchesUrl);
    }

    public record Owner(String login) {
    }

}
