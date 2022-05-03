package com.inc.qualle.controller;

import com.inc.qualle.model.dto.FeedbackDto;
import com.inc.qualle.model.dto.UserDto;
import com.inc.qualle.service.FeedbackService;
import com.inc.qualle.service.security.SessionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ExtraController {

    private final FeedbackService feedbackService;

    @GetMapping(value = "/feedback")
    public String getContactsPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        return "feedback";
    }

    @PostMapping(value = "/feedback/send")
    public String saveContacts(Authentication authentication, FeedbackDto dto) {
        dto.setUser(UserDto.builder().login(SessionUtil.getUserLogin(authentication)).build());
        feedbackService.save(dto);
        return "redirect:/home";
    }
}
