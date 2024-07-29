package com.karatesan.Simple_Github_api.ecxeption;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

}
