package com.bogdan.statstracker.service;

import com.bogdan.statstracker.entity.Player;
import com.bogdan.statstracker.entity.PlayerStats;
import com.bogdan.statstracker.repository.PlayerStatsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerStatsService {
    private final PlayerService playerService;
    private final PlayerStatsRepository playerStatsRepository;

    public PlayerStatsService(PlayerStatsRepository playerStatsRepository, PlayerService playerService) {
        this.playerStatsRepository = playerStatsRepository;
        this.playerService = playerService;
    }

    public void saveStats(Long playerId, PlayerStats stats) {
        Player player = playerService.getPlayerById(playerId).orElseThrow();
        stats.setPlayer(player);
        playerStatsRepository.save(stats);
    }

    public List<PlayerStats> getStatsByPlayerId(Long playerId) {
        return playerStatsRepository.findByPlayerId(playerId);
    }
}
