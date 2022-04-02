package com.inc.qualle.controller;

import com.inc.qualle.model.dto.*;
import com.inc.qualle.service.*;
import com.inc.qualle.service.security.SessionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final GenreService genreService;
    private final DeveloperService developerService;
    private final FeedbackService feedbackService;
    private final VacancyService vacancyService;
    private final ImageService imageService;
    private final UserService userService;
    private final AdminService adminService;

    @GetMapping(value = "/admin")
    public String getAdminPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("products", productService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("developers", developerService.getAll());
        model.addAttribute("feedbacks", feedbackService.getAll());
        model.addAttribute("vacancies", vacancyService.getAll());
        model.addAttribute("images", imageService.getAll());
        model.addAttribute("users", userService.getAll());

        return "admin";
    }

    @GetMapping(value = "/admin/product")
    @ResponseBody
    public ResponseEntity<Collection<SimpleProductDto>> getProducts() {
        Collection<SimpleProductDto> result = productService.getAllSimple();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/category")
    @ResponseBody
    public ResponseEntity<Collection<CategoryDto>> getCategories() {
        Collection<CategoryDto> result = categoryService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/genre")
    @ResponseBody
    public ResponseEntity<Collection<GenreDto>> getGenres() {
        Collection<GenreDto> result = genreService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/developer")
    @ResponseBody
    public ResponseEntity<Collection<DeveloperDto>> getDevelopers() {
        Collection<DeveloperDto> result = developerService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/feedback")
    @ResponseBody
    public ResponseEntity<Collection<FeedbackDto>> getFeedbacks() {
        Collection<FeedbackDto> result = feedbackService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/vacancy")
    @ResponseBody
    public ResponseEntity<Object> getVacancies() {
        Collection<VacancyDto> result = vacancyService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/image")
    @ResponseBody
    public ResponseEntity<Collection<ImageDto>> getImages() {
        Collection<ImageDto> result = imageService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/user")
    @ResponseBody
    public ResponseEntity<Collection<UserDto>> getUsers() {
        Collection<UserDto> result = userService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/sql")
    public String getSqlPage() {
        return "admin_sql";
    }

    @GetMapping(value = "/admin/product/{id}")
    public String getProduct(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("product", productService.getById(id));
        model.addAttribute("type", "product");
        return "admin";
    }

    @GetMapping(value = "/admin/category/{id}")
    public String getCategory(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("category", categoryService.getById(id));
        model.addAttribute("type", "category");
        return "admin";
    }

    @GetMapping(value = "/admin/genre/{id}")
    public String getGenre(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("genre", genreService.getById(id));
        model.addAttribute("type", "genre");
        return "admin";
    }

    @GetMapping(value = "/admin/developer/{id}")
    public String getDeveloper(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("developer", developerService.getById(id));
        model.addAttribute("type", "developer");
        return "admin";
    }

    @GetMapping(value = "/admin/feedback/{id}")
    public String getFeedback(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("feedback", feedbackService.getById(id));
        model.addAttribute("type", "feedback");
        return "admin";
    }

    @GetMapping(value = "/admin/vacancy/{id}")
    public String getVacancy(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("vacancy", vacancyService.getById(id));
        model.addAttribute("type", "vacancy");
        return "admin";
    }

    @GetMapping(value = "/admin/image/{id}")
    public String getImage(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("image", imageService.getById(id));
        model.addAttribute("type", "image");
        return "admin";
    }

    @GetMapping(value = "/admin/user/{id}")
    public String getUser(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("type", "user");
        return "admin";
    }

    @GetMapping(value = "/admin/product/add")
    public String addProductPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("developers", developerService.getAll());
        model.addAttribute("genres", genreService.getAll());
        return "edit_product";
    }

    @GetMapping(value = "/admin/category/add")
    public String addCategoryPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        return "edit_category";
    }

    @GetMapping(value = "/admin/genre/add")
    public String addGenrePage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        return "edit_genre";
    }

    @GetMapping(value = "/admin/developer/add")
    public String addDeveloperPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        return "edit_developer";
    }

    @GetMapping(value = "/admin/vacancy/add")
    public String addVacancyPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        return "edit_vacancy";
    }

    @GetMapping(value = "/admin/image/add")
    public String addImagePage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        return "edit_image";
    }

    @PostMapping(value = "/admin/product/add")
    public String addProduct(SaveProductDto dto) {
        productService.save(dto);
        return "admin";
    }

    @PostMapping(value = "/admin/category/add")
    public String addCategory(CategoryDto dto) {
        categoryService.save(dto);
        return "admin";
    }

    @PostMapping(value = "/admin/genre/add")
    public String addGenre(GenreDto dto) {
        genreService.save(dto);
        return "admin";
    }

    @PostMapping(value = "/admin/developer/add")
    public String addDeveloper(DeveloperDto dto) {
        developerService.save(dto);
        return "admin";
    }

    @PostMapping(value = "/admin/vacancy/add")
    public String addVacancy(VacancyDto dto) {
        vacancyService.save(dto);
        return "admin";
    }

    @PostMapping(value = "/admin/image/add")
    public String addImage(ImageDto dto) {
        imageService.save(dto);
        return "admin";
    }

    @PostMapping(value = "/admin/product/update")
    public String updateProduct(SaveProductDto dto) {
        productService.save(dto);
        return "admin";
    }

    @PostMapping(value = "/admin/sql")
    public String getSqlPage(Model model, Authentication authentication, String query) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        return "redirect:/admin/sql?response=" + adminService.executeQuery(query);
    }

    @GetMapping(value = "/admin/product/{id}/update")
    public String updateProductPage(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("developers", developerService.getAll());
        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("product", productService.getById(id));
        return "edit_product";
    }

    @PostMapping(value = "/admin/product/delete")
    public String addDeveloper(Long productId) {
        productService.delete(productId);
        return "admin";
    }
}