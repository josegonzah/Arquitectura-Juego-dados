package com.sofkau.race.racespringbootconcepts.infra.handlers;


import com.sofkau.race.racespringbootconcepts.domain.commands.CreateGameCommand;
import com.sofkau.race.racespringbootconcepts.domain.usecase.CreateGameUseCase;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CreateGameUseCaseHandle {

    private CreateGameUseCase createGameUseCase;

    public CreateGameUseCaseHandle(CreateGameUseCase createGameUseCase) {
        this.createGameUseCase = createGameUseCase;
    }

    @EventListener
    public void handle(CreateGameCommand createGameCommand){
        var game = createGameUseCase.apply(createGameCommand);
        System.out.println(game.id());
    }
}
