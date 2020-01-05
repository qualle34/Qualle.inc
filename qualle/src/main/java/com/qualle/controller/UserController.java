package com.qualle.controller;

import com.qualle.model.dto.UserRegistrationDto;
import com.qualle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/profile")
    public String getProfilePage() {
        return "profile";
    }

    @GetMapping(value = "/cart")
    public String getCartPage() {
        return "cart";
    }

    @PostMapping(value = "/registration")
    public void doRegistration(UserRegistrationDto dto){
        userService.add(dto);
    }
}
