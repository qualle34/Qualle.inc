package com.qualle.service.impl;

import com.qualle.exception.CartNotFoundException;
import com.qualle.exception.GameNotFoundException;
import com.qualle.model.entity.Cart;
import com.qualle.repository.CartRepository;
import com.qualle.repository.GameRepository;
import com.qualle.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private GameRepository gameRepository;

    @Override
    public Cart getByUserId(Long userId) {
        return toCart(cartRepository.findById(userId));
    }

    @Override
    public void addGame(long id, long gameId) {
        Cart cart = toCart(cartRepository.findById(id));
        cart.addGame(gameRepository.findById(gameId).orElseThrow(GameNotFoundException::new));
        cartRepository.save(cart);
    }

    private Cart toCart(Optional<Cart> optional) {
        return optional.orElseThrow(CartNotFoundException::new);
    }
}
