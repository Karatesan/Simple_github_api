package com.karatesan.Simple_Github_api.Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karatesan.Simple_Github_api.dto.GithubRepositoryData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
@JsonTest
public class GithubRepositoryDataJsonTest {

    @Autowired
    private JacksonTester<GithubRepositoryData>json;

    private GithubRepositoryData githubRepositoryData;

    @BeforeEach
    void setUp(){
        githubRepositoryData = new GithubRepositoryData("BlogApp_v2", "Karatesan", false, "https://api.github.com/repos/Karatesan/BlogApp_v2/branches");
    }


    @Test
    public void githubRepositoryDataDeserializationTest() throws IOException {

        String expected = """
                {
                    "name": "BlogApp_v2",
                    "owner": {
                      "login": "Karatesan"
                    },
                    "fork": false,
                    "branches_url": "https://api.github.com/repos/Karatesan/BlogApp_v2/branches"
                }
                """;

        assertThat(json.parse(expected)).isEqualTo(githubRepositoryData);
        assertThat(json.parseObject(expected).name()).isEqualTo("BlogApp_v2");

    }


}
