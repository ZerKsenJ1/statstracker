package com.bogdan.statstracker.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OsuUserResponse {
    @JsonProperty("statistics")
    private OsuStatistics statistics;

    public OsuStatistics getStatistics() {return statistics;}
}
