package com.sofkau.race.racespringbootconcepts.domain;

import com.sofkau.race.racespringbootconcepts.domain.factory.GameBuilder;
import com.sofkau.race.racespringbootconcepts.domain.usecase.GameRepository;
import com.sofkau.race.racespringbootconcepts.infra.repository.MongoGameRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    private String id;
    private String title;
    private Map<String, User> users;
    private Integer numberOfThrows;
    //String represents UserID
    private List<String> positions;
    private boolean state;
    private Integer numberOfPlayers;
    private Integer currentThrow = 0;
    private GameRepository repository = new MongoGameRepository();

    public Game(String id, String title, Integer numberOfThrows, Integer numberOfPlayers) {
        this.id = id;
        this.title = title;
        this.users = new HashMap<>();
        this.numberOfThrows = numberOfThrows;
        this.positions = new ArrayList<>();
        this.state = false;
        this.numberOfPlayers = numberOfPlayers;
    }

    private Game(String id){
        this.id = id;
        this.users = new HashMap<>();
        this.positions = new ArrayList<>();
        this.state = false;
    }

    public static Game from(String id, GameBuilder gameBuilder){
        var race = new Game(id);
        race.title = gameBuilder.getTitle();
        race.users = gameBuilder.getUsers();
        race.numberOfThrows = gameBuilder.getNumberOfThrows();
        race.positions = gameBuilder.getPositions();
        race.state = gameBuilder.isState();
        race.numberOfPlayers = gameBuilder.getNumberOfPlayers();
        return race;
    }

    public void addUser(String id, String userName, Integer numberOfWins, int totalScore, String avatar){
        var user = new User(id, userName, numberOfWins, totalScore, avatar);
        this.users.put(id, user);
    }

    public void throwAllUsers(){
    }

    public void startGame(){
        this.state = true;
    }

    public void stopGame(){
        this.state = false;
    }

    public void addWinner(String userId){
        this.positions.add(userId);
    }

    public String id() {
        return id;
    }

    public String title() {
        return title;
    }

    public Map<String, User> users() {
        return users;
    }

    public Integer trackDistance() {
        return numberOfThrows;
    }

    public List<String> podium() {
        return positions;
    }

    public boolean state() {
        return state;
    }

    public Integer numberOfPlayers() {
        return numberOfPlayers;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", users=" + users +
                ", numberOfThrows=" + numberOfThrows +
                ", positions=" + positions +
                ", state=" + state +
                ", numberOfPlayers=" + numberOfPlayers +
                '}';
    }
}
