package com.qualle.controller;

import com.qualle.service.GameService;
import com.qualle.service.UserService;
import com.qualle.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping(value = "/games")
    public String getGamesPage() {
        return "games";
    }

    @GetMapping(value = "/game/{id}")
    public String getGamePage(@PathVariable Long id, Model model) {
        model.addAttribute("game", gameService.getById(id));
        return "game";
    }
}