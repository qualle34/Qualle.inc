package com.inc.qualle.service.dao;

import com.inc.qualle.model.dto.GameDto;
import com.inc.qualle.model.dto.GameSimpleDto;
import com.inc.qualle.model.entity.Product;

import java.util.List;
import java.util.Map;

public interface GameService {

    Product getById(long id);

    GameDto getDtoById(long id);

    List<Product> getAll();

    List<GameDto> getAllDto();

    List<Product> getAllWithCategory();

    Map<String, List<GameSimpleDto>> getForGamesPage();

    List<Product> getByUser(long id);

    List<GameDto> getDtoByUser(long id);

    List<GameDto> getDtoByUser(String login);

    List<Product> getByCart(long cartId);

    List<GameSimpleDto> getDtoByCart(long cartId);

    List<Product> getByName(String name);

    List<GameSimpleDto> getDtoByName(String name);

    void add(GameDto dto);

    void update(GameDto dto);

    void delete(long id);
}
