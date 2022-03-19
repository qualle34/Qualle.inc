package com.inc.qualle.controller;

import com.inc.qualle.service.security.SessionUtil;
import com.inc.qualle.service.dao.CartService;
import com.inc.qualle.service.dao.GameService;
import com.inc.qualle.service.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/cart")
    public String getCartPage(Model model, Authentication authentication) {
        long id = userService.getIdByLogin(SessionUtil.getUserLogin(authentication));
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("games", gameService.getDtoByCart(id));
        model.addAttribute("user", userService.getDtoById(id));
        return "cart";
    }

    @PostMapping(value = "/cart/add")
    public String addGameToCart(Long gameId, Authentication authentication) {
        long id = userService.getIdByLogin(SessionUtil.getUserLogin(authentication));
        cartService.addGame(id, gameId);
        return "redirect:/cart";
    }

    @PostMapping(value = "/cart/buy")
    public String buyGames(Authentication authentication) {
        long id = userService.getIdByLogin(SessionUtil.getUserLogin(authentication));
        cartService.buyGames(id);
        return "redirect:/profile";
    }

    @PostMapping(value = "/cart/delete")
    public String deleteGameFromCart(Long gameId, Authentication authentication) {
        long id = userService.getIdByLogin(SessionUtil.getUserLogin(authentication));
        if (gameId != null) {
            cartService.deleteGame(id, gameId);
        } else {
            cartService.deleteGames(id);
        }
        return "redirect:/cart";
    }
}
