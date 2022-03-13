package com.inc.qualle.service;

public interface CartService {

    Cart getById(Long id);

    void addGame(long id, long gameId);

    void buyGames(long id);

    void deleteGames(long id);

    void deleteGame(long id, long gameId);
}
