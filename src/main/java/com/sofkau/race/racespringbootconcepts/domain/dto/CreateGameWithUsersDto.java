package com.sofkau.race.racespringbootconcepts.domain.dto;

import java.io.Serializable;
import java.util.List;

public class CreateGameWithUsersDto implements Serializable {
    private String title;
    private String numberOfThrows;
    private List<UserDto> users;

    public CreateGameWithUsersDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumberOfThrows() {
        return numberOfThrows;
    }

    public void setNumberOfThrows(String numberOfThrows) {
        this.numberOfThrows = numberOfThrows;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
