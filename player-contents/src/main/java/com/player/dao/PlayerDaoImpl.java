package com.player.dao;

import com.player.dao.entity.Player;
import com.player.dao.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PlayerDaoImpl implements PlayerDao {
    private final PlayerRepository playerRepository;

    @Override
    public Player getPlayByPlayerId(String playerId) {
        return playerRepository.findByPlayerID(playerId);
    }

    @Override
    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Player player) {
        playerRepository.save(player);
    }
}