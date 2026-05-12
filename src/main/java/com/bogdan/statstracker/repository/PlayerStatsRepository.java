package com.bogdan.statstracker.repository;

import com.bogdan.statstracker.entity.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Long> {
    List<PlayerStats> findByPlayerId(Long playerId);
}
