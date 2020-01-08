package com.qualle.service;

import com.qualle.model.entity.Cart;

public interface CartService {

    Cart getByUserId(Long userId);

    void addGame(long id, long gameId);
}
