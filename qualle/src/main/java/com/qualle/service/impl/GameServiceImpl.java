package com.qualle.service.impl;

import com.qualle.model.dto.GameDto;
import com.qualle.model.entity.Game;
import com.qualle.repository.GameRepository;
import com.qualle.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    @Override
    public Game getById(long id) {
        return toGame(gameRepository.findById(id));
    }

    @Override
    public GameDto getDtoById(long id) {
        return toDto(getById(id));
    }

    private Game toGame(Optional<Game> optional) {
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NullPointerException();
    }

    private GameDto toDto(Game game) {
        return new GameDto(game.getTitle(), game.getDescription(), game.getPrice(), game.getDeveloper().getTitle(), game.getCategory().getTitle());
    }
}
