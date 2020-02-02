package com.qualle.service;

import com.qualle.model.entity.Cart;

public interface CartService {

    Cart getById(Long id);

    void addGame(long id, long gameId);

    void buyGames(long id);
}
