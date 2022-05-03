package com.inc.qualle.controller;

import com.inc.qualle.service.VacancyService;
import com.inc.qualle.service.security.SessionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;

    @GetMapping(value = "/vacancies")
    public String getProductPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("vacancies", vacancyService.getAll());
        return "vacancies";
    }
}
