package com.sofkau.race.racespringbootconcepts.infra.handlers;


import com.sofkau.race.racespringbootconcepts.domain.commands.AddUsersCommand;
import com.sofkau.race.racespringbootconcepts.domain.usecase.AddUsersUseCase;
import com.sofkau.race.racespringbootconcepts.domain.usecase.GameRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class AddUserUseCaseHandle {

    private final AddUsersUseCase addUsersUseCase;
    private final GameRepository repository;

    public AddUserUseCaseHandle(AddUsersUseCase addUsersUseCase, GameRepository repository) {
        this.addUsersUseCase = addUsersUseCase;
        this.repository = repository;
    }

    @EventListener
    public void handle(AddUsersCommand addUsersCommand){
        var race = this.addUsersUseCase.apply(addUsersCommand);
        this.repository.save(race);
    }
}
