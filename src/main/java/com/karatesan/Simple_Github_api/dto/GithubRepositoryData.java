package com.karatesan.Simple_Github_api.dto;

/**
 * Represents repository data retrieved from the GitHub API.
 * This class holds information about a GitHub repository including its name,
 * owner, whether it is a fork, and the URL to fetch branch data.
 */
public class GithubRepositoryData {

    private String name;
    private Owner owner;
    private boolean fork;
    private String branchesUrl;

    /**
     * Gets the name of the repository.
     *
     * @return the name of the repository
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the repository.
     *
     * @param name the name of the repository
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the owner of the repository.
     *
     * @return the owner of the repository
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the repository.
     *
     * @param owner the owner of the repository
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * Checks if the repository is a fork.
     *
     * @return {@code true} if the repository is a fork, {@code false} otherwise
     */
    public boolean isFork() {
        return fork;
    }

    /**
     * Sets whether the repository is a fork.
     *
     * @param fork {@code true} if the repository is a fork, {@code false} otherwise
     */
    public void setFork(boolean fork) {
        this.fork = fork;
    }

    /**
     * Gets the URL to fetch branch data for the repository.
     *
     * @return the URL to fetch branch data
     */
    public String getBranchesUrl() {
        return branchesUrl;
    }

    /**
     * Sets the URL to fetch branch data for the repository.
     *
     * @param branchesUrl the URL to fetch branch data
     */
    public void setBranchesUrl(String branchesUrl) {
        this.branchesUrl = branchesUrl;
    }

    /**
     * Represents the owner of a repository.
     */
    public static class Owner {
        private String login;

        /**
         * Gets the login name of the repository owner.
         *
         * @return the login name of the repository owner
         */
        public String getLogin() {
            return login;
        }

        /**
         * Sets the login name of the repository owner.
         *
         * @param login the login name of the repository owner
         */
        public void setLogin(String login) {
            this.login = login;
        }
    }
}
