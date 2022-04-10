package com.inc.qualle.controller;

import com.inc.qualle.model.dto.SimpleProductDto;
import com.inc.qualle.model.entity.ProductType;
import com.inc.qualle.service.CategoryService;
import com.inc.qualle.service.GenreService;
import com.inc.qualle.service.ProductService;
import com.inc.qualle.service.security.SessionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final GenreService genreService;

    @GetMapping(value = "/products")
    public String getProductPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        Collection<SimpleProductDto> products = productService.getAllWithCategory();

        Map<String, Collection<SimpleProductDto>> dto = new HashMap<>();
        dto.put("main", new ArrayList<>());
        dto.put("popular", new ArrayList<>());
        dto.put("sport", new ArrayList<>());
        dto.put("mobile", new ArrayList<>());
        dto.put("other", new ArrayList<>());

        for (SimpleProductDto product : products) {

            switch (product.getCategory().getValue().trim().toLowerCase()) {

                case "main":
                    if (dto.get("main").size() < 4) {
                        dto.get("main").add(product);
                    }
                    break;

                case "popular":
                    if (dto.get("popular").size() < 6) {
                        dto.get("popular").add(product);
                    }
                    break;

                case "sport":
                    if (dto.get("sport").size() < 6) {
                        dto.get("sport").add(product);
                    }
                    break;

                case "mobile":
                    if (dto.get("mobile").size() < 6) {
                        dto.get("mobile").add(product);
                    }
                    break;

                case "other":
                    if (dto.get("other").size() < 10) {
                        dto.get("other").add(product);
                    }
                    break;
            }
        }

        model.addAttribute("main", dto.get("main"));
        model.addAttribute("popular", dto.get("popular"));
        model.addAttribute("sport", dto.get("sport"));
        model.addAttribute("mobile", dto.get("mobile"));
        model.addAttribute("other", dto.get("other"));
        model.addAttribute("merch", products.stream()
                .filter(p -> ProductType.MERCH.equals(p.getType()))
                .collect(Collectors.toList()));
        return "products";
    }

    @GetMapping(value = "/product/{id}")
    public String getProductPage(@PathVariable Long id, Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("product", productService.getById(id));
        return "product";
    }

    @GetMapping(value = "/product/search")
    @ResponseBody
    public ResponseEntity<Collection<SimpleProductDto>> search(@RequestParam(required = false) String title,
                                                               @RequestParam(required = false) String[] categories,
                                                               @RequestParam(required = false) String[] genres) {
        Collection<Long> c = Collections.emptyList();
        Collection<Long> g = Collections.emptyList();

        if (categories != null && categories.length != 0) {
           c = Arrays.stream(categories).map(Long::parseLong).collect(Collectors.toList());
        }

        if (genres != null && genres.length != 0) {
            g = Arrays.stream(genres).map(Long::parseLong).collect(Collectors.toList());
        }

        Collection<SimpleProductDto> result = productService.getByTitleAndCategoryAndGenre(title, c, g);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public String getSearchPage(Model model, Authentication authentication) {
        model.addAttribute("authority", SessionUtil.getAuthority(authentication));
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("genres", genreService.getAll());
        return "search";
    }
}
