package com.qualle.controller;

import com.qualle.model.dto.UserRegistrationDto;
import com.qualle.security.SessionUtil;
import com.qualle.service.GameService;
import com.qualle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/profile")
    public String getProfilePage(Model model, Authentication authentication) {
        String login = SessionUtil.getUserLogin(authentication);
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("games", gameService.getDtoByUser(login));
        model.addAttribute("user", userService.getDtoByLogin(login));
        return "profile";
    }

    @PostMapping(value = "/registration")
    public void doRegistration(UserRegistrationDto dto) {
        userService.add(dto);
    }
}
