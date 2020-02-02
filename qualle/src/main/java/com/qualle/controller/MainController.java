package com.qualle.controller;

import com.qualle.security.SessionUtil;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/about")
    public String getAboutPage(Model model, Authentication authentication) {
        model.addAttribute("isAuthenticated", SessionUtil.isAuthenticated(authentication));
        return "about";
    }

    @GetMapping(value = "/contacts")
    public String getContactsPage(Model model, Authentication authentication) {
        model.addAttribute("isAuthenticated", SessionUtil.isAuthenticated(authentication));
        return "contacts";
    }

    @GetMapping(value = "/service")
    public String getServicePage(Model model, Authentication authentication) {
        model.addAttribute("isAuthenticated", SessionUtil.isAuthenticated(authentication));
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
