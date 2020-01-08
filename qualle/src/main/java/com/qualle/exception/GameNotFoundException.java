package com.qualle.exception;

public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException() {
        super();
    }

    public GameNotFoundException(String message) {
        super(message);
    }
}
