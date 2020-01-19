package com.qualle.service.impl;

import com.qualle.exception.GameNotFoundException;
import com.qualle.model.dto.GameDto;
import com.qualle.model.dto.GameSimpleDto;
import com.qualle.model.entity.Game;
import com.qualle.repository.GameRepository;
import com.qualle.service.GameService;
import com.qualle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    UserService userService;

    @Override
    public Game getById(long id) {
        return toGame(gameRepository.findById(id));
    }

    @Override
    public GameDto getDtoById(long id) {
        return toDto(getById(id));
    }

    @Override
    public List<Game> getByUser(long id) {
        return gameRepository.findByUserId(id);
    }

    @Override
    public List<GameDto> getDtoByUser(long id) {
        List<GameDto> dto = new ArrayList<>();
        for (Game game : getByUser(id)) {
            dto.add(toDto(game));
        }
        return dto;
    }

    @Override
    public List<GameDto> getDtoByUser(String login) {
        return getDtoByUser(userService.getIdByLogin(login));
    }

    @Override
    public List<Game> getByCart(long cartId) {
        return gameRepository.findByCartId(cartId);
    }

    @Override
    public List<GameSimpleDto> getDtoByCart(long cartId) {
        List<GameSimpleDto> dto = new ArrayList<>();
        for (Game game : getByCart(cartId)) {
            dto.add(toSimpleDto(game));
        }
        return dto;
    }

    @Override
    public List<Game> getByName(String name) {
        return gameRepository.findByName(name);
    }

    @Override
    public List<GameDto> getDtoByName(String name) {
        List<GameDto> dto = new ArrayList<>();
        for (Game game : getByName(name)) {
            dto.add(toDto(game));
        }
        return dto;
    }

    private Game toGame(Optional<Game> optional) {
        return optional.orElseThrow(GameNotFoundException::new);
    }

    private GameDto toDto(Game game) {
        return new GameDto(game.getName(), game.getDescription(), game.getPrice(), game.getDeveloper().getTitle(), game.getCategory().getTitle());
    }

    private GameSimpleDto toSimpleDto(Game game) {
        return new GameSimpleDto(game.getName(), game.getPrice());
    }
}
