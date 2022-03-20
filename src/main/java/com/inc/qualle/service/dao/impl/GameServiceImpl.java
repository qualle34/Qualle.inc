package com.inc.qualle.service.dao.impl;

import com.inc.qualle.model.exception.GameNotFoundException;
import com.inc.qualle.model.dto.GameDto;
import com.inc.qualle.model.dto.GameSimpleDto;
import com.inc.qualle.model.entity.Image;
import com.inc.qualle.model.entity.Product;
import com.inc.qualle.repository.CategoryRepository;
import com.inc.qualle.repository.DeveloperRepository;
import com.inc.qualle.repository.ProductRepository;
import com.inc.qualle.service.dao.GameService;
import com.inc.qualle.service.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserService userService;

    @Override
    public Product getById(long id) {
        return toGame(productRepository.findById(id));
    }

    @Override
    public GameDto getDtoById(long id) {
        return toDto(getById(id));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<GameDto> getAllDto() {
        List<GameDto> dto = new ArrayList<>();
        for (Product product : getAll()) {
            dto.add(toDto(product));
        }
        return dto;
    }

    @Override
    public List<Product> getAllWithCategory() {
        return productRepository.findAllWithCategory();
    }

    @Override
    public Map<String, List<GameSimpleDto>> getForGamesPage() {
        List<Product> products = getAllWithCategory();
        Map<String, List<GameSimpleDto>> dto = new HashMap<>();
        dto.put("main", new ArrayList<>());
        dto.put("popular", new ArrayList<>());
        dto.put("sport", new ArrayList<>());
        dto.put("mobile", new ArrayList<>());
        dto.put("other", new ArrayList<>());

        for (Product product : products) {

            switch (product.getCategory().getValue().trim().toLowerCase()) {

                case "main":
                    if (dto.get("main").size() < 4) {
                        dto.get("main").add(toSimpleDto(product));
                    }
                    break;

                case "popular":
                    if (dto.get("popular").size() < 6) {
                        dto.get("popular").add(toSimpleDto(product));
                    }
                    break;

                case "sport":
                    if (dto.get("sport").size() < 6) {
                        dto.get("sport").add(toSimpleDto(product));
                    }
                    break;

                case "mobile":
                    if (dto.get("mobile").size() < 6) {
                        dto.get("mobile").add(toSimpleDto(product));
                    }
                    break;

                case "other":
                    if (dto.get("other").size() < 15) {
                        dto.get("other").add(toSimpleDto(product));
                    }
                    break;
            }
        }
        return dto;
    }

    @Override
    public List<Product> getByUser(long id) {
        return productRepository.findByUserId(id);
    }

    @Override
    public List<GameDto> getDtoByUser(long id) {
        List<GameDto> dto = new ArrayList<>();
        for (Product product : getByUser(id)) {
            dto.add(toDto(product));
        }
        return dto;
    }

    @Override
    public List<GameDto> getDtoByUser(String login) {
        return getDtoByUser(userService.getIdByLogin(login));
    }

    @Override
    public List<Product> getByCart(long cartId) {
        return productRepository.findByCartId(cartId);
    }

    @Override
    public List<GameSimpleDto> getDtoByCart(long cartId) {
        List<GameSimpleDto> dto = new ArrayList<>();
        for (Product product : getByCart(cartId)) {
            dto.add(toSimpleDto(product));
        }
        return dto;
    }

    @Override
    public List<Product> getByName(String name) {
        return productRepository.findByName("%" + name + "%");
    }

    @Override
    public List<GameSimpleDto> getDtoByName(String name) {
        List<GameSimpleDto> dto = new ArrayList<>();
        for (Product product : getByName(name)) {
            dto.add(toSimpleDto(product));
        }
        return dto;
    }

    @Override
    public void add(GameDto dto) {
        productRepository.save(fromDto(dto));
    }

    @Override
    public void update(GameDto dto) {
        productRepository.save(fromDto(dto));
    }

    @Override
    public void delete(long id) {
        productRepository.delete(getById(id));
    }

    private Product toGame(Optional<Product> optional) {
        return optional.orElseThrow(GameNotFoundException::new);
    }

    private GameDto toDto(Product product) {
        GameDto dto = new GameDto(product.getTitle(), product.getDescription(), product.getPrice(), product.getDeveloper().getTitle(), product.getCategory().getValue(), product.getImage().getLink());
        dto.setId(product.getId());
        dto.setCategoryId(product.getCategory().getId());
        dto.setDeveloperId(product.getDeveloper().getId());
        return dto;
    }

    private GameSimpleDto toSimpleDto(Product product) {
        GameSimpleDto dto = new GameSimpleDto(product.getTitle(), product.getPrice(), product.getImage().getLink());
        dto.setId(product.getId());
        return dto;
    }

    private Product fromDto(GameDto dto) {
        Product product =  Product.builder()
                .title(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
        product.setId(dto.getId());
        product.setImage(Image.builder().link(dto.getImg()).build());
        product.setCategory(categoryRepository.findById(dto.getCategoryId()).get());
        product.setDeveloper(developerRepository.findById(dto.getDeveloperId()).get());
        return product;
    }
}
