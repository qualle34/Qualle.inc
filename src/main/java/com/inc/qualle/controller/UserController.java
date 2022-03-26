package com.inc.qualle.controller;

import com.inc.qualle.model.dto.RegistrationDto;
import com.inc.qualle.service.security.SessionUtil;
import com.inc.qualle.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/profile")
    public String getProfilePage(Model model, Authentication authentication) {
        String login = SessionUtil.getUserLogin(authentication);
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("profile", userService.getProfileByLogin(login));
        return "profile";
    }

    @PostMapping(value = "/registration")
    public void doRegistration(RegistrationDto dto) {
        userService.register(dto);
    }
}
