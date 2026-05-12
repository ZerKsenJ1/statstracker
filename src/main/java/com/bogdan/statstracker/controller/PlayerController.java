package com.bogdan.statstracker.controller;

import com.bogdan.statstracker.client.OsuClient;
import com.bogdan.statstracker.client.OsuUserResponse;
import com.bogdan.statstracker.dto.PlayerStatsDTO;
import com.bogdan.statstracker.entity.Player;
import com.bogdan.statstracker.entity.PlayerStats;
import com.bogdan.statstracker.service.PlayerService;
import com.bogdan.statstracker.service.PlayerStatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerStatsService playerStatsService;
    private final OsuClient osuClient;

    public PlayerController(PlayerService playerService, PlayerStatsService playerStatsService, OsuClient osuClient) {
        this.playerService = playerService;
        this.playerStatsService = playerStatsService;
        this.osuClient = osuClient;
    }

    @GetMapping("/players/{id}/stats/history")
    public List<PlayerStatsDTO> getPlayerHistory(@PathVariable Long id) { return playerStatsService.getStatsDTOByPlayerId(id); }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{id}/stats")
    public List<PlayerStats> getPlayerStatsById(@PathVariable Long id) {
        return playerStatsService.getStatsByPlayerId(id);
    }

    @GetMapping("/test-token")
    public String testResponse() {
        return osuClient.getAccessToken();
    }

    @GetMapping("/osu/users/{username}")
    public OsuUserResponse getOsuUser(@PathVariable String username) {
        return osuClient.getUserStats(username);
    }

    @PostMapping("/players")
    public ResponseEntity<String> createUser(@RequestBody Player player) {
        String message = "Player " + player.getName() + " created!";
        playerService.savePlayer(player);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/players/{id}/stats")
    public void getPlayerById(@PathVariable Long id, @RequestBody PlayerStats stats) {
        playerStatsService.saveStats(id, stats);
    }

    @PostMapping("/osu/users/{username}/fetch")
    public void getFetch(@PathVariable String username) {
        playerStatsService.fetchAndSaveStats(username);
    }
}
