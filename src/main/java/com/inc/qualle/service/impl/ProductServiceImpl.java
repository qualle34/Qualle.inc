package com.inc.qualle.service.impl;

import com.inc.qualle.model.dto.*;
import com.inc.qualle.model.entity.Product;
import com.inc.qualle.model.exception.NotFoundException;
import com.inc.qualle.repository.*;
import com.inc.qualle.service.ImageService;
import com.inc.qualle.service.ProductService;
import com.inc.qualle.service.UserService;
import com.inc.qualle.service.mapper.BaseMapper;
import com.inc.qualle.service.mapper.ProductMapper;
import com.inc.qualle.service.mapper.SimpleProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends AbstractService<Product, ProductDto, Long> implements ProductService {

    private final ProductRepository repository;
    private final ImageService imageService;
    private final ImageRepository imageRepository;
    private final CategoryRepository categoryRepository;
    private final GenreRepository genreRepository;
    private final DeveloperRepository developerRepository;
    private final UserService userService;

    private final ProductMapper mapper;
    private final SimpleProductMapper simpleMapper;

    @Override
    protected CrudRepository<Product, Long> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<Product, ProductDto> getMapper() {
        return mapper;
    }

    @Override
    public Collection<SimpleProductDto> getAllSimple() {
        return simpleMapper.toDto(repository.findAllSimple());
    }

    @Override
    public Collection<SimpleProductDto> getAllWithCategory() {
        return simpleMapper.toDto(repository.findAllWithCategory());
    }

    @Override
    public Collection<ProductDto> getByUser(long id) {
        return mapper.toDto(repository.findByUserId(id));
    }

    @Override
    public Collection<ProductDto> getByUser(String login) {
        return getByUser(userService.getIdByLogin(login));
    }

    @Override
    public Collection<ProductDto> getByCart(long cartId) {
        return mapper.toDto(repository.findByCartId(cartId));
    }

    @Override
    public Collection<SimpleProductDto> getByTitle(String title) {
        return simpleMapper.toDto(repository.findByTitleContaining(title));
    }

    @Override
    public Collection<SimpleProductDto> getByTitleAndCategoryAndGenre(String title, Collection<Long> categories, Collection<Long> genres) {
        if (categories.isEmpty() && genres.isEmpty()) {
            return getByTitle(title);
        }

        if (genres.isEmpty()) {
            return simpleMapper.toDto(repository.findByTitleContainingAndCategoryIn(title, categories));
        }

        if (categories.isEmpty()) {
            return simpleMapper.toDto(repository.findByTitleContainingAndGenreIn(title, genres));
        }

        return simpleMapper.toDto(repository.findByTitleContainingAndCategoryInAndGenreIn(title, categories, genres));
    }

    @Override
    public void save(SaveProductDto dto) {

        if (dto.getId() == 0) {

            ImageDto imageDto = imageService.save(ImageDto.builder().name("Image for " + dto.getTitle()).link(dto.getImage()).build());

            ProductDto product = ProductDto.builder()
                    .title(dto.getTitle())
                    .description(dto.getDescription())
                    .price(dto.getPrice())
                    .category(new CategoryDto(dto.getCategoryId()))
                    .genre(new GenreDto(dto.getGenreId()))
                    .developer(new DeveloperDto(dto.getDeveloperId()))
                    .image(imageDto)
                    .build();

            saveImpl(product);
            return;
        }

        ProductDto product = getById(dto.getId());

        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setCategory(new CategoryDto(dto.getCategoryId()));
        product.setGenre(new GenreDto(dto.getGenreId()));
        product.setDeveloper(new DeveloperDto(dto.getDeveloperId()));
        saveImpl(product);
    }

    private void saveImpl(ProductDto dto) {
        Product product = mapper.toEntity(dto);
        product.setImage(imageRepository.findById(dto.getImage().getId()).orElseThrow(NotFoundException::new));
        product.setCategory(categoryRepository.findById(dto.getCategory().getId()).orElseThrow(NotFoundException::new));
        product.setGenre(genreRepository.findById(dto.getGenre().getId()).orElseThrow(NotFoundException::new));
        product.setDeveloper(developerRepository.findById(dto.getDeveloper().getId()).orElseThrow(NotFoundException::new));
        repository.save(product);
    }
}
