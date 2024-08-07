package com.karatesan.Simple_Github_api.Json;


import com.karatesan.Simple_Github_api.dto.GithubBranchData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class GithubBranchDataJsonTest {

    @Autowired
    private JacksonTester<GithubBranchData> json;

    private GithubBranchData githubBranchData;


    @BeforeEach
    void setUp(){
        githubBranchData = new GithubBranchData("Name", "Sha");
    }


    @Test
    void githubBranchDataDeserializationTest() throws IOException {

        String expected = """
                {
                    "name": "Name",
                    "commit":{
                        "sha":"Sha"
                    }
                }
                """;

        assertThat(json.parse(expected)).isEqualTo(githubBranchData);
    }

}

