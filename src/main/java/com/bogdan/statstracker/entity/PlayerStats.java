package com.bogdan.statstracker.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class PlayerStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private int worldRank;
    private int countryRank;
    private double pp;
    private double bestScorePP;
    private int playcount;
    private double accuracy;
    private LocalDate date;

    public void setDate(LocalDate date) {this.date = date;}
    public void setPlayer(Player player) {this.player = player;}
    public void setAccuracy(double accuracy) {this.accuracy = accuracy;}
    public void setCountryRank(int countryRank) {this.countryRank = countryRank;}
    public void setPlaycount(int playcount) {this.playcount = playcount;}
    public void setWorldRank(int worldRank) {this.worldRank = worldRank;}
    public void setMaxPP(double maxPP) {this.pp = maxPP;}

    public int getWorldRank() {return worldRank;}
    public int getCountryRank() {return countryRank;}
    public double getMaxPP() {return pp;}
    public double getBestScorePP() {return bestScorePP;}
    public int getPlaycount() {return playcount;}
    public double getAccuracy() {return accuracy;}
    public LocalDate getDate() {return date;}
}
