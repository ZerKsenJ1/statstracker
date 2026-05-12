package com.bogdan.statstracker.client;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class OsuClient {
    private final WebClient webClient;

    @Value("${osu.client-id}")
    private int osuClientId;

    @Value("${osu.client-secret}")
    private String osuClientSecret;

    public OsuClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://osu.ppy.sh")
                .build();
    }

    public String getAccessToken() {
        OsuTokenResponse response = webClient.post()
                .uri("/oauth/token")
                .bodyValue(Map.of(
                        "client_id", osuClientId,
                        "client_secret", osuClientSecret,
                        "grant_type", "client_credentials",
                        "scope", "public"
                ))
                .retrieve()
                .bodyToMono(OsuTokenResponse.class)
                .block();
        return response.getAccessToken();
    }
}
