package com.bogdan.statstracker.repository;

import com.bogdan.statstracker.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    public Optional<Player> findByName(String username);


}
