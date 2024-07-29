package com.karatesan.Simple_Github_api.ecxeption;

public class TooManyRequestsException extends RuntimeException {

    public TooManyRequestsException(String message) {
        super(message);
    }
}
