package com.qualle.service;

import com.qualle.model.dto.GameDto;
import com.qualle.model.entity.Game;

public interface GameService {

    Game getById(long id);

    GameDto getDtoById(long id);
}
