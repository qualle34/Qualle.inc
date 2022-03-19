package com.inc.qualle.controller.handler;

import com.inc.qualle.model.exception.CartNotFoundException;
import com.inc.qualle.model.exception.GameNotFoundException;
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
    public String exception(Exception e, Model model) {
        model.addAttribute("cause", e.getMessage());
        return "redirect:error";
    }
}
