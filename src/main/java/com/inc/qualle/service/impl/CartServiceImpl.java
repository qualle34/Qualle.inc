package com.inc.qualle.service.impl;

import com.inc.qualle.exception.CartNotFoundException;
import com.inc.qualle.exception.GameNotFoundException;
import com.inc.qualle.repository.ProductRepository;
import com.inc.qualle.model.entity.User;
import com.inc.qualle.service.CartService;
import com.inc.qualle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    @Override
    public Cart getById(Long id) {
        return toCart(cartRepository.findById(id));
    }

    @Override
    public void addGame(long id, long gameId) {
        Cart cart = toCart(cartRepository.findById(id));
        cart.addGame(productRepository.findById(gameId).orElseThrow(GameNotFoundException::new));
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

    @Override
    public void deleteGames(long id) {
        Cart cart = getById(id);
        cart.setGames(null);
        cartRepository.save(cart);
    }

    @Override
    public void deleteGame(long id, long gameId) {
        Cart cart = getById(id);
        cart.getGames().removeIf(game -> game.getId() == gameId);
        cartRepository.save(cart);
    }

    private Cart toCart(Optional<Cart> optional) {
        return optional.orElseThrow(CartNotFoundException::new);
    }
}
