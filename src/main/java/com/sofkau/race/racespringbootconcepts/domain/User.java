package com.sofkau.race.racespringbootconcepts.domain;

public class User {
    private String id;
    private String avatar;
    private String userName;
    private Integer totalScore;
    private Integer NumberOfWins;

    public User(String id, String userName, Integer numberOfWins, int totalScore, String avatar) {
        this.id = id;
        this.userName = userName;
        this.totalScore = totalScore;
        this.NumberOfWins = numberOfWins;
        this.avatar = avatar;
    }

    public static User from(String id, String userName, Integer numberOfWins, Integer progress, String avatar){
        return new User(id, userName, numberOfWins, progress, avatar);
    }

    public void updateProgress(int newProgress){
        this.totalScore = this.totalScore + newProgress;
    }

    public String id() {
        return id;
    }

    public String userName() {
        return userName;
    }

    public Integer progress() {
        return totalScore;
    }

    public Integer numberOfWins() {
        return NumberOfWins;
    }

    public String avatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", avatar='" + avatar + '\'' +
                ", userName='" + userName + '\'' +
                ", totalScore=" + totalScore +
                ", NumberOfWins=" + NumberOfWins +
                '}';
    }
}
