package com.bogdan.statstracker.repository;

import com.bogdan.statstracker.entity.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Long> {
}
