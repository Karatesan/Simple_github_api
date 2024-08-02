package com.karatesan.Simple_Github_api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public record GithubBranchData(String name, String sha) {

    @JsonCreator
    public GithubBranchData(
            String name,
            Commit commit
    ) {
        this(name, commit.sha());
    }

    public record Commit(String sha) {
    }
}
