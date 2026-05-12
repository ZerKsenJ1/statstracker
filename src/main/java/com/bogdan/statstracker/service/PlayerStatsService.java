package com.bogdan.statstracker.service;

import com.bogdan.statstracker.client.OsuClient;
import com.bogdan.statstracker.client.OsuStatistics;
import com.bogdan.statstracker.client.OsuUserResponse;
import com.bogdan.statstracker.entity.Player;
import com.bogdan.statstracker.entity.PlayerStats;
import com.bogdan.statstracker.repository.PlayerStatsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PlayerStatsService {
    private final PlayerService playerService;
    private final PlayerStatsRepository playerStatsRepository;
    private final OsuClient osuClient;

    public PlayerStatsService(PlayerStatsRepository playerStatsRepository, PlayerService playerService, OsuClient osuClient) {
        this.playerStatsRepository = playerStatsRepository;
        this.playerService = playerService;
        this.osuClient = osuClient;
    }

    public void saveStats(Long playerId, PlayerStats stats) {
        Player player = playerService.getPlayerById(playerId).orElseThrow();
        stats.setPlayer(player);
        playerStatsRepository.save(stats);
    }

    public List<PlayerStats> getStatsByPlayerId(Long playerId) {
        return playerStatsRepository.findByPlayerId(playerId);
    }

    public void fetchAndSaveStats(String username) {
        OsuUserResponse osuData = osuClient.getUserStats(username);
        Player player = playerService.getPlayerByName(username).orElseGet(() -> {
            Player newPlayer = new Player(username);
            playerService.savePlayer(newPlayer);
            return newPlayer;
        });
        PlayerStats stats = new PlayerStats();
        stats.setPlayer(player);
        stats.setWorldRank(osuData.getStatistics().getGlobalRank());
        stats.setCountryRank(osuData.getStatistics().getCountryRank());
        stats.setPlaycount(osuData.getStatistics().getPlayCount());
        stats.setAccuracy(osuData.getStatistics().getAccuracy());
        stats.setMaxPP(osuData.getStatistics().getPp());
        stats.setDate(LocalDate.now());
        playerStatsRepository.save(stats);
    }
}
