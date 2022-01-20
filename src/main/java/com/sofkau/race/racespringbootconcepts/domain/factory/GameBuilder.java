package com.sofkau.race.racespringbootconcepts.domain.factory;

import com.sofkau.race.racespringbootconcepts.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBuilder {
    private String title;
    private Map<String, User> users;
    private Integer numberOfThrows;
    //String represents UserID
    private List<String> positions;
    private boolean state;
    private Integer numberOfPlayers;

    public GameBuilder(){
        this.users = new HashMap<>();
        this.positions = new ArrayList<>();
        this.state = false;
    }

    public GameBuilder withTitle(String title){
        this.title = title;
        return this;
    }

    public GameBuilder withTrackDistance(Integer trackDistance){
        this.numberOfThrows = trackDistance;
        return this;
    }

    public GameBuilder withPodium(List<String> podium){
        this.positions = podium;
        return this;
    }

    public GameBuilder withState(boolean state){
        this.state = state;
        return this;
    }

    public GameBuilder withNumberOfPlayers(Integer numberOfPlayers){
        this.numberOfPlayers = numberOfPlayers;
        return this;
    }

    public GameBuilder withUser(User user){
        users.put(user.id(), user);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Integer getNumberOfThrows() {
        return numberOfThrows;
    }

    public List<String> getPositions() {
        return positions;
    }

    public boolean isState() {
        return state;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }
}
