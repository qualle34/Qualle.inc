package com.inc.qualle.controller.handler;

import com.inc.qualle.controller.AdminController;
import com.inc.qualle.model.exception.CartNotFoundException;
import com.inc.qualle.model.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice(assignableTypes = AdminController.class)
public class GlobalHandler {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public String ProductNotFoundPage(ProductNotFoundException e, Model model) {
        model.addAttribute("cause", "product");
        log.warn("ProductNotFoundException: ", e);
        return "redirect:/error";
    }

    @ExceptionHandler(value = CartNotFoundException.class)
    public String CartNotFoundPage(CartNotFoundException e, Model model) {
        model.addAttribute("cause", "cart");
        log.warn("CartNotFoundException: ", e);
        return "redirect:/error";
    }

    @ExceptionHandler(value = Exception.class)
    public String exception(Exception e, Model model) {
        model.addAttribute("cause", e.getMessage());
        log.warn("Unexpected exception: ", e);
        return "redirect:/error";
    }
}
