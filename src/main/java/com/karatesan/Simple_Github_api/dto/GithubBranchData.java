package com.karatesan.Simple_Github_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.karatesan.Simple_Github_api.Json.GithubBranchDataSerializer;

/**
 * Represents branch data retrieved from the GitHub API.
 * This class includes a custom JSON serializer defined by {@link GithubBranchDataSerializer}.
 * It is used to serialize and deserialize branch data from the GitHub API response.
 *
 * @see GithubBranchDataSerializer
 */
@JsonSerialize(using = GithubBranchDataSerializer.class)
public class GithubBranchData {

    private String name;

    @JsonProperty("commit")
    private Commit commit;


    public GithubBranchData() {
    }


    public GithubBranchData(String name, Commit commit) {
        this.name = name;
        this.commit = commit;
    }

    /**
     * Gets the name of the branch.
     *
     * @return the name of the branch
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the branch.
     *
     * @param name the name of the branch
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the commit associated with the branch.
     *
     * @return the commit associated with the branch
     */
    public Commit getCommit() {
        return commit;
    }

    /**
     * Sets the commit associated with the branch.
     *
     * @param commit the commit associated with the branch
     */
    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    /**
     * Represents a commit associated with a branch.
     */
    public static class Commit {
        private String sha;

        public Commit() {
        }

        public Commit(String sha) {
            this.sha = sha;
        }

        /**
         * Gets the SHA hash of the commit.
         *
         * @return the SHA hash of the commit
         */
        public String getSha() {
            return sha;
        }

        /**
         * Sets the SHA hash of the commit.
         *
         * @param sha the SHA hash of the commit
         */
        public void setSha(String sha) {
            this.sha = sha;
        }
    }
}
