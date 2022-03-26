package com.inc.qualle.model.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Игра не найдена!");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(Long productId) {
        super("Игра c id = " + productId + " не найдена!");
    }
}
