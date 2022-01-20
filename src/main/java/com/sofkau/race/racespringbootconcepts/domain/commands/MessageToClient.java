package com.sofkau.race.racespringbootconcepts.domain.commands;

import co.com.sofka.infraestructure.handle.CommandWrapper;

public class MessageToClient extends CommandWrapper {
    private String aggregateId;
    private String commandType;
    private Object payLoad;


    public MessageToClient(String aggregateId, String commandType, Object payLoad) {
        super(aggregateId, commandType, payLoad);
    }
}
