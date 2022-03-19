package com.inc.qualle.controller;

import com.inc.qualle.model.dto.GameSimpleDto;
import com.inc.qualle.service.security.SessionUtil;
import com.inc.qualle.service.dao.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/games")
    public String getGamePage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        Map<String, List<GameSimpleDto>> dto = gameService.getForGamesPage();
        model.addAttribute("main", dto.get("main"));
        model.addAttribute("popular", dto.get("popular"));
        model.addAttribute("sport", dto.get("sport"));
        model.addAttribute("mobile", dto.get("mobile"));
        model.addAttribute("other", dto.get("other"));
        return "games";
    }

    @GetMapping(value = "/game/{id}")
    public String getGamePage(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("game", gameService.getDtoById(id));
        return "game";
    }

    @GetMapping(value = "/games/search")
    @ResponseBody
    public ResponseEntity<Object> search(@RequestParam(value = "search", required = false) String search) {
        Object result = gameService.getDtoByName(search);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
