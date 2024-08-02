package com.karatesan.Simple_Github_api.dto;

import java.util.List;

public record Response(String repositoryName, String owner, List<GithubBranchData> branches) {
}
