package com.bogdan.statstracker.service;

import com.bogdan.statstracker.entity.Player;
import com.bogdan.statstracker.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerByName(String username) {
        return playerRepository.findByName(username);
    }

    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }
}
