package com.qualle.controller;

import com.qualle.security.SessionUtil;
import com.qualle.service.ExtraService;
import com.qualle.service.GameService;
import com.qualle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

    @Autowired
    private ExtraService extraService;

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/admin")
    public String getAdminPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("games", gameService.getAllDto());
        model.addAttribute("categories", extraService.getAllCategoriesDto());
        model.addAttribute("users", userService.getAllDto());
        model.addAttribute("summaries", extraService.getAllSummariesDto());
        return "admin";
    }

    @GetMapping(value = "/admin/games")
    @ResponseBody
    public ResponseEntity<Object> getGames() {
        Object result = gameService.getAllDto();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/categories")
    @ResponseBody
    public ResponseEntity<Object> getCategories() {
        Object result = extraService.getAllCategoriesDto();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/users")
    @ResponseBody
    public ResponseEntity<Object> getUsers() {
        Object result = userService.getAllDto();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/summaries")
    @ResponseBody
    public ResponseEntity<Object> getSummaries() {
        Object result = extraService.getAllSummariesDto();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
