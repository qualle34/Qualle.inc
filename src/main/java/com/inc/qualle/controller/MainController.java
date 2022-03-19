package com.inc.qualle.controller;

import com.inc.qualle.service.security.SessionUtil;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/about")
    public String getAboutPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        return "about";
    }

    @GetMapping(value = "/service")
    public String getServicePage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        return "service";
    }

    @GetMapping(value = "/error")
    public String getErrorPage() {
        return "error";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(Authentication authentication) {
        if (SessionUtil.isAuthenticated(authentication)) {
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping(value = "/registration")
    public String getRegistrationPage(Authentication authentication) {
        if (SessionUtil.isAuthenticated(authentication)) {
            return "redirect:/home";
        }
        return "registration";
    }
}
