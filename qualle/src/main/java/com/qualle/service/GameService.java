package com.qualle.service;

import com.qualle.model.dto.GameDto;
import com.qualle.model.entity.Game;

import java.util.List;

public interface GameService {

    Game getById(long id);

    GameDto getDtoById(long id);

    List<Game> getByName(String name);

    List<GameDto> getDtoByName(String name);
}
