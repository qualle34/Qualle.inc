package com.qualle.controller;

import com.qualle.model.dto.UserRegistrationDto;
import com.qualle.security.SessionUtil;
import com.qualle.service.CartService;
import com.qualle.service.GameService;
import com.qualle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/profile")
    public String getProfilePage(Model model) {
        String login = SessionUtil.getUserLogin();
        model.addAttribute("games", gameService.getDtoByUser(login));
        model.addAttribute("user", userService.getDtoByLogin(login));
        return "profile";
    }

    @GetMapping(value = "/cart")
    public String getCartPage(Model model) {
        Long id = userService.getIdByLogin(SessionUtil.getUserLogin());
        model.addAttribute("cart", cartService.getByUserId(id));
        return "cart";
    }

    @PostMapping(value = "/cart/add/{gameId}")
    public void addGameToCart(@PathVariable long gameId) {
        long id = userService.getIdByLogin(SessionUtil.getUserLogin());
        cartService.addGame(id, gameId);
    }

    @PostMapping(value = "/registration")
    public void doRegistration(UserRegistrationDto dto) {
        userService.add(dto);
    }
}
