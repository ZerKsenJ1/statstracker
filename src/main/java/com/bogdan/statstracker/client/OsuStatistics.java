package com.bogdan.statstracker.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OsuStatistics {
    @JsonProperty("global_rank")
    private int globalRank;
    @JsonProperty("country_rank")
    private int countryRank;
    private double pp;
    @JsonProperty("play_count")
    private int playCount;
    @JsonProperty("hit_accuracy")
    private double accuracy;

    public int getGlobalRank() {return globalRank;}
    public int getCountryRank() {return countryRank;}
    public double getPp() {return pp;}
    public int getPlayCount() {return playCount;}
    public double getAccuracy() {return accuracy;}
}
