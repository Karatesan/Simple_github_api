package com.karatesan.Simple_Github_api.ecxeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for the application, utilizing Spring's {@link RestControllerAdvice}
 * to catch and process exceptions thrown by controllers.
 *
 * <p>This class provides custom responses for specific exceptions to ensure consistent error handling.</p>
 *
 * @see UserNotFoundException
 * @see ClientErrorException
 * @see TooManyRequestsException
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles {@link UserNotFoundException} and returns a custom error response with HTTP status 404 Not Found.
     *
     * @param ex the exception instance
     * @return an {@link ErrorResponse} with a 404 status and the exception message
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.toString());
        response.setMessage(ex.getMessage());
        return response;
    }

    /**
     * Handles {@link ClientErrorException} and returns a custom error response with HTTP status 500 Internal Server Error.
     *
     * @param ex the exception instance
     * @return an {@link ErrorResponse} with a 500 status and the exception message
     */
    @ExceptionHandler(ClientErrorException.class)
    public ErrorResponse handleClientErrorException(ClientErrorException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        response.setMessage(ex.getMessage());
        return response;
    }

    /**
     * Handles {@link TooManyRequestsException} and returns a custom error response with HTTP status 429 Too Many Requests.
     *
     * @param ex the exception instance
     * @return an {@link ErrorResponse} with a 429 status and the exception message
     */
    @ExceptionHandler(TooManyRequestsException.class)
    public ErrorResponse handleTooManyRequestsException(TooManyRequestsException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HttpStatus.TOO_MANY_REQUESTS.toString());
        response.setMessage(ex.getMessage());
        return response;
    }
}
