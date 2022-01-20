package com.sofkau.race.racespringbootconcepts.domain.usecase;

import com.sofkau.race.racespringbootconcepts.domain.Game;
import com.sofkau.race.racespringbootconcepts.domain.commands.AddUsersCommand;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class AddUsersUseCase implements Function<AddUsersCommand, Game> {

    private GameRepository repository;

    public AddUsersUseCase(GameRepository repository){
        this.repository = repository;
    }

    @Override
    public Game apply(AddUsersCommand command) {
        var game = repository.findById(command.getGameId());
        game.addUser(UUID.randomUUID().toString(),
                command.getUserName(),
                command.getNumberOfWins(),
                0,
                command.getAvatar());
        return game;
    }
}
