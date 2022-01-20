package com.sofkau.race.racespringbootconcepts.domain.commands;

import java.io.Serializable;

public class StartGameCommand implements Serializable {
    private String gameId;

    public StartGameCommand() {
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
