package com.bogdan.statstracker.scheduler;

import com.bogdan.statstracker.entity.Player;
import com.bogdan.statstracker.service.PlayerService;
import com.bogdan.statstracker.service.PlayerStatsService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StatsScheduler {

    private final PlayerService playerService;
    private final PlayerStatsService playerStatsService;

    public StatsScheduler(PlayerStatsService playerStatsService, PlayerService playerService) {
        this.playerService = playerService;
        this.playerStatsService = playerStatsService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void updateAllStats() {
        for (Player player : playerService.getAllPlayers()) {
            playerStatsService.fetchAndSaveStats(player.getName());
        }

    }
}
