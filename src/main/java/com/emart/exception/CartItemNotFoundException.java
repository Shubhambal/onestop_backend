package com.emart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to be thrown when a CartItem is not found.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartItemNotFoundException extends RuntimeException {

    /**
     * Constructs a new CartItemNotFoundException with the specified error message.
     *
     * @param message the error message
     */
    public CartItemNotFoundException(String message) {
        super(message);
    }
}
