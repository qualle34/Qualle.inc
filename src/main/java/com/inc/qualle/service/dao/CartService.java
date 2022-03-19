package com.inc.qualle.service.dao;

public interface CartService {

    void getById(Long id);

    void addGame(long id, long gameId);

    void buyGames(long id);

    void deleteGames(long id);

    void deleteGame(long id, long gameId);
}
