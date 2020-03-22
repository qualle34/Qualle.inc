package com.qualle.service;

import com.qualle.model.dto.GameDto;
import com.qualle.model.dto.GameSimpleDto;
import com.qualle.model.entity.Game;

import java.util.List;
import java.util.Map;

public interface GameService {

    Game getById(long id);

    GameDto getDtoById(long id);

    List<Game> getAll();

    List<GameDto> getAllDto();

    List<Game> getAllWithCategory();

    Map<String, List<GameSimpleDto>> getForGamesPage();

    List<Game> getByUser(long id);

    List<GameDto> getDtoByUser(long id);

    List<GameDto> getDtoByUser(String login);

    List<Game> getByCart(long cartId);

    List<GameSimpleDto> getDtoByCart(long cartId);

    List<Game> getByName(String name);

    List<GameSimpleDto> getDtoByName(String name);

    void add(GameDto dto);

    void update(GameDto dto);

    void delete(long id);
}
