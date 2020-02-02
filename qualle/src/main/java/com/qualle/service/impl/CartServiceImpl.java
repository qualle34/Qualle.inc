package com.qualle.service.impl;

import com.qualle.exception.CartNotFoundException;
import com.qualle.exception.GameNotFoundException;
import com.qualle.model.entity.Cart;
import com.qualle.model.entity.User;
import com.qualle.repository.CartRepository;
import com.qualle.repository.GameRepository;
import com.qualle.service.CartService;
import com.qualle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserService userService;

    @Override
    public Cart getById(Long id) {
        return toCart(cartRepository.findById(id));
    }

    @Override
    public void addGame(long id, long gameId) {
        Cart cart = toCart(cartRepository.findById(id));
        cart.addGame(gameRepository.findById(gameId).orElseThrow(GameNotFoundException::new));
        cartRepository.save(cart);
    }

    @Override
    @Transactional
    public void buyGames(long id) {
        User user = userService.getById(id);
        Cart cart = getById(id);
        if (user.getGames() != null) {
            user.getGames().addAll(cart.getGames());
        } else {
            user.setGames(cart.getGames());
        }
        cart.setGames(null);
        userService.update(user);
        cartRepository.save(cart);
    }

    private Cart toCart(Optional<Cart> optional) {
        return optional.orElseThrow(CartNotFoundException::new);
    }
}
