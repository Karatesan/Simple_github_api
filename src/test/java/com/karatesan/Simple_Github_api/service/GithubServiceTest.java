package com.karatesan.Simple_Github_api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
class GithubServiceTest {

    @Autowired
    RestClient.Builder builder;
    @Autowired
    MockRestServiceServer mockServer;
    @Autowired
    GithubService githubService;

    @BeforeEach
    void setUp(){

        mockServer = MockRestServiceServer.cre
    }


    @Test
    public void test(){
        mockServer = MockRestServiceServer.bindTo(builder).build();
    }


}