package com.karatesan.Simple_Github_api.dto;

import java.util.List;

/**
 * Represents the response sent to the client containing repository details.
 * This class includes information about the repository's name, owner, and its branches.
 *
 * <p>It is used by the {@link com.karatesan.Simple_Github_api.controller.GitHubController}
 * to structure the data returned from the GitHub API endpoint.</p>
 */
public class UserRepositoriesResponse {

    private String repositoryName;
    private String owner;
    private List<GithubBranchData> branches;

    /**
     * Gets the name of the repository.
     *
     * @return the name of the repository
     */
    public String getRepositoryName() {
        return repositoryName;
    }

    /**
     * Sets the name of the repository.
     *
     * @param repositoryName the name of the repository
     */
    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    /**
     * Gets the owner of the repository.
     *
     * @return the owner of the repository
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the repository.
     *
     * @param owner the owner of the repository
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Gets the list of branches associated with the repository.
     *
     * @return a list of {@link GithubBranchData} representing the branches of the repository
     */
    public List<GithubBranchData> getBranches() {
        return branches;
    }

    /**
     * Sets the list of branches associated with the repository.
     *
     * @param branches a list of {@link GithubBranchData} representing the branches of the repository
     */
    public void setBranches(List<GithubBranchData> branches) {
        this.branches = branches;
    }
}
