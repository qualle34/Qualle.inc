package com.qualle.controller.handler;

import com.qualle.exception.CartNotFoundException;
import com.qualle.exception.GameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(value = GameNotFoundException.class)
    public String GameNotFoundPage(GameNotFoundException e, Model model) {
        model.addAttribute("cause", "game");
        return "redirect:/error";
    }

    @ExceptionHandler(value = CartNotFoundException.class)
    public String CartNotFoundPage(CartNotFoundException e, Model model) {
        model.addAttribute("cause", "cart");
        return "redirect:/error";
    }

    @ExceptionHandler(value = Exception.class)
    public String exception(Exception e) {
        return "redirect:error";
    }
}
