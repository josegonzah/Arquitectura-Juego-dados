package com.sofkau.race.racespringbootconcepts.domain.commands;

import java.io.Serializable;

public class CreateGameCommand implements Serializable {
    private String title;
    private Integer numberOfThrows;
    private Integer numberOfPlayers;

    public CreateGameCommand() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberOfThrows() {
        return numberOfThrows;
    }

    public void setNumberOfThrows(Integer numberOfThrows) {
        this.numberOfThrows = numberOfThrows;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
