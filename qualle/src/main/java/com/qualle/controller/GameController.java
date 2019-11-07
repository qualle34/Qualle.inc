package com.qualle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @GetMapping(value = "/games")
    public String getGamesPage() {
        return "games";
    }

    @GetMapping(value = "/game")
    public String getGamePage() {
        return "game";
    }
}
