package com.qualle.controller;

import com.qualle.service.UserService;
import com.qualle.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/games")
    public String getGamesPage() {
        return "games";
    }

    @GetMapping(value = "/game")
    public String getGamePage(Model model) {
        User user = userService.getById(1L).get();
        model.addAttribute("user", user);
        return "game";
    }
}