package com.qualle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value = "/profile")
    public String getProfilePage() {
        return "profile";
    }

    @GetMapping(value = "/cart")
    public String getCartPage() {
        return "cart";
    }
}
