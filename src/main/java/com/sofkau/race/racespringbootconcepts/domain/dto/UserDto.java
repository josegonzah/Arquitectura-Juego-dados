package com.sofkau.race.racespringbootconcepts.domain.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
    private String userName;
    private String avatar;
    private String totalScore;

    public UserDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }
}
