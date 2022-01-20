package com.sofkau.race.racespringbootconcepts.infra.documents;

import com.sofkau.race.racespringbootconcepts.domain.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Document
public class GameDocument {

    @Id
    private String id;
    private String title;
    private Map<String, UserDocument> users;
    private Integer numberOfThrows;
    //String represents UserID
    private List<String> positions;
    private boolean state;
    private Integer numberOfPlayers;

    public GameDocument() {
        this.users = new HashMap<>();
        this.positions = new ArrayList<>();
        this.state = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void withUser(User user){
        users.put(user.id(), new UserDocument(user.id(),
                user.userName(),
                user.progress(),
                user.numberOfWins(),
                user.avatar()));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, UserDocument> getUsers() {
        return users;
    }

    public void setUsers(Map<String, UserDocument> users) {
        this.users = users;
    }

    public Integer getNumberOfThrows() {
        return numberOfThrows;
    }

    public void setNumberOfThrows(Integer numberOfThrows) {
        this.numberOfThrows = numberOfThrows;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
