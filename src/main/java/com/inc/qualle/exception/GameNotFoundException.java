package com.inc.qualle.exception;

public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException() {
        super("Игра не найдена!");
    }

    public GameNotFoundException(String message) {
        super(message);
    }

    public GameNotFoundException(Long gameId) {
        super("Игра c id = " + gameId + " не найдена!");
    }
}
