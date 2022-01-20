package com.sofkau.race.racespringbootconcepts.domain.usecase;

import com.sofkau.race.racespringbootconcepts.domain.Game;
import com.sofkau.race.racespringbootconcepts.domain.commands.CreateGameCommand;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class CreateGameUseCase implements Function<CreateGameCommand, Game> {

    private final GameRepository repository;

    public CreateGameUseCase(GameRepository repository){
        this.repository = repository;
    }

    @Override
    public Game apply(CreateGameCommand command) {
        var game = new Game(UUID.randomUUID().toString(),
                command.getTitle(),
                command.getNumberOfThrows(),
                command.getNumberOfPlayers());
        return repository.save(game);
    }
}
