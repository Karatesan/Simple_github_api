package com.karatesan.Simple_Github_api.ecxeption;

public class ClientErrorException extends RuntimeException {
    public ClientErrorException(String message) {
        super(message);
    }
}
