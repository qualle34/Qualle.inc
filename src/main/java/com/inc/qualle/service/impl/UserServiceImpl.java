package com.inc.qualle.service.impl;

import com.inc.qualle.model.dto.ProfileDto;
import com.inc.qualle.model.dto.RegistrationDto;
import com.inc.qualle.model.dto.UserDto;
import com.inc.qualle.model.entity.User;
import com.inc.qualle.model.exception.ProductNotFoundException;
import com.inc.qualle.model.exception.UserNotFoundException;
import com.inc.qualle.repository.ProductRepository;
import com.inc.qualle.repository.UserRepository;
import com.inc.qualle.service.UserService;
import com.inc.qualle.service.mapper.BaseMapper;
import com.inc.qualle.service.mapper.CardMapper;
import com.inc.qualle.service.mapper.SimpleProductMapper;
import com.inc.qualle.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractService<User, UserDto, Long> implements UserService {

    private final UserRepository repository;
    private final ProductRepository productRepository;
    private final UserMapper mapper;
    private final CardMapper cardMapper;
    private final SimpleProductMapper productMapper;
    private final PasswordEncoder encoder;

    @Override
    protected CrudRepository<User, Long> getRepository() {
        return repository;
    }

    @Override
    protected BaseMapper<User, UserDto> getMapper() {
        return mapper;
    }

    @Override
    @Transactional
    public long getIdByLogin(String login) {
        return repository.findIdByLogin(login)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    @Transactional
    public UserDto getWithCredentialsByLogin(String login) {
        return mapper.toDto(repository.findWithCredentialsByLogin(login)
                .orElseThrow(UserNotFoundException::new));
    }

    @Override
    @Transactional
    public ProfileDto getProfileByLogin(String login) {
        User user = repository.findWithAllByLogin(login)
                .orElseThrow(UserNotFoundException::new);

        return ProfileDto.builder()
                .user(mapper.toDto(user))
                .purchases(productMapper.toDto(user.getPurchases()))
                .cart(productMapper.toDto(user.getCart()))
                .cards(cardMapper.toDto(user.getCards()))
                .build();
    }

    @Override
    @Transactional
    public void addProductToCart(String login, long productId) {
        User user = repository.findWithAllByLogin(login)
                .orElseThrow(UserNotFoundException::new);

        user.getCart().add(productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new));

        repository.save(user);
    }

    @Override
    @Transactional
    public void addProductsToPurchases(String login) {
        User user = repository.findWithAllByLogin(login)
                .orElseThrow(UserNotFoundException::new);

        if (user.getPurchases() != null) {
            user.getPurchases().addAll(user.getCart());
        } else {
            user.setPurchases(user.getCart());
        }
        user.setCart(Collections.emptySet());

        repository.save(user);
    }

    @Override
    @Transactional
    public void clearCart(String login) {
        User user = repository.findWithAllByLogin(login)
                .orElseThrow(UserNotFoundException::new);

        user.setCart(Collections.emptySet());

        repository.save(user);
    }

    @Override
    @Transactional
    public void removeProductFromCart(String login, long productId) {
        User user = repository.findWithAllByLogin(login)
                .orElseThrow(UserNotFoundException::new);

        user.getCart().removeIf(p -> p.getId() == productId);

        repository.save(user);
    }

    @Override
    public void register(RegistrationDto dto) {
        User user = mapper.toEntity(dto);
        user.getCredentials().setPassword(encoder.encode(dto.getPassword()));

        repository.save(user);
    }
}
