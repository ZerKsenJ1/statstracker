package com.bogdan.statstracker.dto;

import java.time.LocalDate;

public class PlayerStatsDTO {

    private LocalDate date;
    private int worldRank;
    private int countryRank;
    private int playCount;
    private double pp;
    private double accuracy;

    public PlayerStatsDTO(LocalDate date, int worldRank, int countryRank, double pp, double accuracy, int playCount) {
        this.date = date;
        this.worldRank = worldRank;
        this.countryRank = countryRank;
        this.accuracy = accuracy;
        this.pp = pp;
        this.playCount = playCount;
    }

    public double getAccuracy() {return accuracy;}
    public int getWorldRank() {return worldRank;}
    public int getCountryRank() {return countryRank;}
    public double getPp() {return pp;}
    public LocalDate getDate() {return date;}
    public int getPlayCount() {return playCount;}
}
