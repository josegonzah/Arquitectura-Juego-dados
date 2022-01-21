package com.sofkau.race.racespringbootconcepts.domain.usecase;

import com.sofkau.race.racespringbootconcepts.domain.Game;
import com.sofkau.race.racespringbootconcepts.domain.commands.StartGameCommand;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StartGameUseCase implements Function<StartGameCommand, Game> {

    private GameRepository repository;

    public StartGameUseCase(GameRepository repository){
        this.repository = repository;
    }

    @Override
    public Game apply(StartGameCommand command) {
        var game = repository.findById(command.getGameId());
        if(game.users().size() < 3){
            System.out.println("Insufficient amount of players");
            return game;
        }
        if(game.positions().size() >= 3){
            System.out.println("Podium already full");
            return game;
        }
        if(game.state() == false){
            game.startGame();
        }
        game.setCurrentThrow(game.currentThrow()+1);
        game.throwAllUsers();

        return repository.save(game);
    }
}
