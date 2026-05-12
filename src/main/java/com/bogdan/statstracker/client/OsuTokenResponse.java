package com.bogdan.statstracker.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OsuTokenResponse {
    @JsonProperty("access_token")
    private String accessToken;

    public String getAccessToken() {return accessToken;}

}
