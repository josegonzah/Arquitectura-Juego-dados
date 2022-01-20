package com.sofkau.race.racespringbootconcepts.infra.documents;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserDocument {

    @Id
    private String id;
    private String avatar;
    private String userName;
    private Integer scoreTotal;
    private Integer NumberOfWins;

    public UserDocument() {
    }

    public UserDocument(String id, String userName, Integer scoreTotal, Integer numberOfWins, String avatar) {
        this.id = id;
        this.avatar = avatar;
        this.userName = userName;
        this.scoreTotal = scoreTotal;
        NumberOfWins = numberOfWins;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(Integer scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public Integer getNumberOfWins() {
        return NumberOfWins;
    }

    public void setNumberOfWins(Integer numberOfWins) {
        NumberOfWins = numberOfWins;
    }

}
