package com.player.dao;

import com.player.dao.entity.Player;

import java.sql.SQLException;
import java.util.List;

public interface PlayerDao {
    Player getPlayByPlayerId(String id);

    List<Player> findAllPlayers();

    void save(Player player) throws SQLException;
}
