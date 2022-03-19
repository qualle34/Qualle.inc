package com.inc.qualle.model.exception;

public class CartNotFoundException extends RuntimeException {

    public CartNotFoundException() {
        super();
    }

    public CartNotFoundException(String message) {
        super(message);
    }
}
