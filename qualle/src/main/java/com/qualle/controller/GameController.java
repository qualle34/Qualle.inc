package com.qualle.controller;

import com.qualle.model.dto.GameSimpleDto;
import com.qualle.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping(value = "/games")
    public String getGamesPage(Model model) {
        Map<String, List<GameSimpleDto>> dto = gameService.getForGamesPage();
        model.addAttribute("main", dto.get("main"));
        model.addAttribute("popular", dto.get("popular"));
        model.addAttribute("sport", dto.get("sport"));
        model.addAttribute("mobile", dto.get("mobile"));
        model.addAttribute("other", dto.get("other"));
        return "games";
    }

    @GetMapping(value = "/game/{id}")
    public String getGamePage(@PathVariable Long id, Model model) {
        model.addAttribute("game", gameService.getDtoById(id));
        return "game";
    }

    @GetMapping(value = "/games/")
    public String getGamePage(@Param(value = "search") String search, Model model) {
        model.addAttribute("games", gameService.getDtoByName(search));
        return "game";
    }
}
