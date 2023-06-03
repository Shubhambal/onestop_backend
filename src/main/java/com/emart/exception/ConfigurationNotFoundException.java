package com.emart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class for indicating that a configuration resource is not found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConfigurationNotFoundException extends RuntimeException {

    /**
     * Constructs an instance of ConfigurationNotFoundException with the specified error message.
     *
     * @param message The error message.
     */
    public ConfigurationNotFoundException(String message) {
        super(message);
    }
}
