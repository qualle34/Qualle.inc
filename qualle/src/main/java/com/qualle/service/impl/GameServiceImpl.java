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

import java.util.*;

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
    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    @Override
    public List<GameDto> getAllDto() {
        List<GameDto> dto = new ArrayList<>();
        for (Game game : getAll()) {
            dto.add(toDto(game));
        }
        return dto;
    }

    @Override
    public List<Game> getAllWithCategory() {
        return gameRepository.findAllWithCategory();
    }

    @Override
    public Map<String, List<GameSimpleDto>> getForGamesPage() {
        List<Game> games = getAllWithCategory();
        Map<String, List<GameSimpleDto>> dto = new HashMap<>();
        dto.put("main", new ArrayList<>());
        dto.put("popular", new ArrayList<>());
        dto.put("sport", new ArrayList<>());
        dto.put("mobile", new ArrayList<>());
        dto.put("other", new ArrayList<>());

        for (Game game : games) {

            switch (game.getCategory().getTitle().trim().toLowerCase()) {

                case "main":
                    if (dto.get("main").size() < 4) {
                        dto.get("main").add(toSimpleDto(game));
                    }
                    break;

                case "popular":
                    if (dto.get("popular").size() < 6) {
                        dto.get("popular").add(toSimpleDto(game));
                    }
                    break;

                case "sport":
                    if (dto.get("sport").size() < 6) {
                        dto.get("sport").add(toSimpleDto(game));
                    }
                    break;

                case "mobile":
                    if (dto.get("mobile").size() < 6) {
                        dto.get("mobile").add(toSimpleDto(game));
                    }
                    break;

                case "other":
                    if (dto.get("other").size() < 15) {
                        dto.get("other").add(toSimpleDto(game));
                    }
                    break;
            }
        }
        return dto;
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
        GameDto dto = new GameDto(game.getName(), game.getDescription(), game.getPrice(), game.getDeveloper().getTitle(), game.getCategory().getTitle());
        dto.setId(game.getId());
        return dto;
    }

    private GameSimpleDto toSimpleDto(Game game) {
        GameSimpleDto dto = new GameSimpleDto(game.getName(), game.getPrice(), game.getImg());
        dto.setId(game.getId());
        return dto;
    }
}
