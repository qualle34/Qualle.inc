package com.inc.qualle.controller;

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
public class CartController {

    private final UserService userService;

    @GetMapping(value = "/cart")
    public String getCartPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("profile", userService.getProfileByLogin(SessionUtil.getUserLogin(authentication)));
        return "cart";
    }

    @PostMapping(value = "/cart/add")
    public String addProductToCart(Long productId, Authentication authentication) {
        userService.addProductToCart(SessionUtil.getUserLogin(authentication), productId);
        return "redirect:/cart";
    }

    @PostMapping(value = "/cart/buy")
    public String buyProducts(Authentication authentication) {
        userService.addProductsToPurchases(SessionUtil.getUserLogin(authentication));
        return "redirect:/profile";
    }

    @PostMapping(value = "/cart/delete")
    public String deleteProductFromCart(Long productId, Authentication authentication) {
        String login = SessionUtil.getUserLogin(authentication);
        if (productId != null) {
            userService.removeProductFromCart(login, productId);
        } else {
            userService.clearCart(login);
        }
        return "redirect:/cart";
    }
}
