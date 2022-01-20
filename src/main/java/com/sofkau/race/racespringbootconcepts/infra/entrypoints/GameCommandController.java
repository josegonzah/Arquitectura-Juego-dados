package com.sofkau.race.racespringbootconcepts.infra.entrypoints;


import com.sofkau.race.racespringbootconcepts.domain.commands.AddUsersCommand;
import com.sofkau.race.racespringbootconcepts.domain.commands.CreateGameCommand;
import com.sofkau.race.racespringbootconcepts.domain.commands.StartGameCommand;
import com.sofkau.race.racespringbootconcepts.domain.dto.CreateGameWithUsersDto;
import com.sofkau.race.racespringbootconcepts.domain.usecase.CreateGameUseCase;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class GameCommandController {

    private final ApplicationEventPublisher eventPublisher;
    private final CreateGameUseCase createGameUseCase;

    public GameCommandController(ApplicationEventPublisher publisher, CreateGameUseCase createGameUseCase){
        this.eventPublisher = publisher;
        this.createGameUseCase = createGameUseCase;
    }

    //No tiene respuesta del back para que el front tenga el id del agregado
    //tiene que hacerse por medio de un socket
    @PostMapping("/createGame")
    public void create(@RequestBody CreateGameCommand command){
        this.eventPublisher.publishEvent(command);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody AddUsersCommand command){
        this.eventPublisher.publishEvent(command);
    }

    @PostMapping("/createGameWithUsers")
    public String createRaceWIthUsers(@RequestBody CreateGameWithUsersDto createRaceWithUsersDto){
        CreateGameCommand createGameCommand = new CreateGameCommand();
        AddUsersCommand addUsersCommand = new AddUsersCommand();
        createGameCommand.setTitle(createRaceWithUsersDto.getTitle());
        createGameCommand.setNumberOfThrows(Integer.parseInt(createRaceWithUsersDto.getNumberOfThrows()));
        createGameCommand.setNumberOfPlayers(createRaceWithUsersDto.getUsers().size());
        var race = createGameUseCase.apply(createGameCommand);
        createRaceWithUsersDto.getUsers().forEach(user ->{
            addUsersCommand.setGameId(race.id());
            addUsersCommand.setUserName(user.getUserName());
            addUsersCommand.setNumberOfWins(1);
            addUsersCommand.setAvatar(user.getAvatar());
            this.eventPublisher.publishEvent(addUsersCommand);
        });
        return race.id();
    }

    @PostMapping("/startGame")
    public void startGame(@RequestBody StartGameCommand command){
        this.eventPublisher.publishEvent(command);
    }
}
