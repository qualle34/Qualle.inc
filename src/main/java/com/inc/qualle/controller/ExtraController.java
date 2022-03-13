package com.inc.qualle.controller;

import com.inc.qualle.model.dto.SummaryDto;
import com.inc.qualle.security.SessionUtil;
import com.inc.qualle.service.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ExtraController {

    @Autowired
    private ExtraService extraService;

    @GetMapping(value = "/contacts")
    public String getContactsPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        return "contacts";
    }

    @PostMapping(value = "/contacts/send")
    public String saveContacts(SummaryDto dto) {
        extraService.add(dto);
        return "redirect:/home";
    }
}
