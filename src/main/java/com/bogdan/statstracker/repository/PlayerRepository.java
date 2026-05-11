package com.bogdan.statstracker.repository;

import com.bogdan.statstracker.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
