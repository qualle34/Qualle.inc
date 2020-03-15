package com.qualle.controller;

import com.qualle.model.dto.CategoryDto;
import com.qualle.model.dto.GameDto;
import com.qualle.security.SessionUtil;
import com.qualle.service.ExtraService;
import com.qualle.service.GameService;
import com.qualle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

    @Autowired
    private ExtraService extraService;

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/admin")
    public String getAdminPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("games", gameService.getAllDto());
        model.addAttribute("categories", extraService.getAllCategoriesDto());
        model.addAttribute("users", userService.getAllDto());
        model.addAttribute("summaries", extraService.getAllSummariesDto());
        return "admin";
    }

    @GetMapping(value = "/admin/games")
    @ResponseBody
    public ResponseEntity<Object> getGames() {
        Object result = gameService.getAllDto();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/categories")
    @ResponseBody
    public ResponseEntity<Object> getCategories() {
        Object result = extraService.getAllCategoriesDto();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/developers")
    @ResponseBody
    public ResponseEntity<Object> getDevelopers() {
        Object result = extraService.getAllDeveloperDto();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/users")
    @ResponseBody
    public ResponseEntity<Object> getUsers() {
        Object result = userService.getAllDto();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/summaries")
    @ResponseBody
    public ResponseEntity<Object> getSummaries() {
        Object result = extraService.getAllSummariesDto();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/game/{id}")
    public String getGame(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("game", gameService.getDtoById(id));
        model.addAttribute("type", "game");
        return "admin";
    }

    @GetMapping(value = "/admin/category/{id}")
    public String getCategory(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("category", extraService.getCategoryDtoById(id));
        model.addAttribute("type", "category");
        return "admin";
    }

    @GetMapping(value = "/admin/developer/{id}")
    public String getDeveloper(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("developer", extraService.getDeveloperDtoById(id));
        model.addAttribute("type", "developer");
        return "admin";
    }

    @GetMapping(value = "/admin/user/{id}")
    public String getUser(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("type", "user");
        return "admin";
    }

    @GetMapping(value = "/admin/summary/{id}")
    public String getSummary(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("summary", extraService.getSummaryDtoById(id));
        model.addAttribute("type", "summary");
        return "admin";
    }

    @GetMapping(value = "/admin/add/game")
    public String addGamePage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("categories", extraService.getAllCategoriesDto());
        model.addAttribute("developers", extraService.getAllDeveloperDto());
        return "add_game";
    }

    @GetMapping(value = "/admin/add/category")
    public String addCategoryPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        return "add_category";
    }

    @GetMapping(value = "/admin/add/developer")
    public String addDeveloperPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        return "add_developer";
    }

    @PostMapping(value = "/admin/add/game")
    public void addGame(GameDto dto) {
    }

    @PostMapping(value = "/admin/add/category")
    public void addCategory(CategoryDto dto) {
    }

    @PostMapping(value = "/admin/add/developer")
    public void addDeveloper(CategoryDto dto) {
    }
}