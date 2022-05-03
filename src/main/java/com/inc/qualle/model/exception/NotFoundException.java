package com.inc.qualle.model.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Сущность не найдена!");
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Long productId) {
        super("Сущность c id = " + productId + " не найдена!");
    }
}
