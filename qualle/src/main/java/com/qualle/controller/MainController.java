package com.qualle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/news")
    public String getNewsPage() {
        return "news";
    }

    @GetMapping(value = "/about")
    public String getAboutPage() {
        return "about";
    }

    @GetMapping(value = "/career")
    public String getCareerPage() {
        return "career";
    }

    @GetMapping(value = "/contacts")
    public String getContactsPage() {
        return "contacts";
    }

    @GetMapping(value = "/service")
    public String getServicePage() {
        return "service";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(value = "/registration")
    public String getRegistrationPage() {
        return "registration";
    }
}
