package com.qualle.controller;

import com.qualle.model.dto.ContactDto;
import com.qualle.security.SessionUtil;
import com.qualle.service.ExtraService;
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
        model.addAttribute("isAuthenticated", SessionUtil.isAuthenticated(authentication));
        return "contacts";
    }

    @PostMapping(value = "/contacts/send")
    public String saveContacts(ContactDto dto) {
        extraService.add(dto);
        return "redirect:/home";
    }

    @GetMapping(value = "/voting")
    public String getVotingPage(Model model, Authentication authentication) {
        model.addAttribute("isAuthenticated", SessionUtil.isAuthenticated(authentication));
        model.addAttribute("isResult", false);
        return "voting";
    }

    @GetMapping(value = "/voting/result")
        public String getVotingResultPage(Model model) {
        Map<String, Integer> result = extraService.getVotes();

        model.addAttribute("isResult", true);

        model.addAttribute("one_star", result.get("one_star"));
        model.addAttribute("two_stars", result.get("two_stars"));
        model.addAttribute("three_stars", result.get("three_stars"));
        model.addAttribute("four_stars", result.get("four_stars"));
        model.addAttribute("five_stars", result.get("five_stars"));
        return "voting";
    }


    @PostMapping(value = "/voting/vote")
    public String saveVote(HttpServletRequest request) {
        extraService.add(request.getParameterNames().nextElement());
        return "redirect:/voting/result";
    }
}
