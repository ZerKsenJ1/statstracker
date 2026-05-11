package com.bogdan.statstracker.controller;

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

    public PlayerController(PlayerService playerService, PlayerStatsService playerStatsService) {
        this.playerService = playerService;
        this.playerStatsService = playerStatsService;
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
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
}
