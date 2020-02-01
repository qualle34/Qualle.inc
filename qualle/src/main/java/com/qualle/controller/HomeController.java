package com.qualle.controller;

import com.qualle.security.SessionUtil;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public String getPage(Model model, Authentication authentication) {
        model.addAttribute("isAuthenticated", SessionUtil.isAuthenticated(authentication));
        return "home";
    }
}
