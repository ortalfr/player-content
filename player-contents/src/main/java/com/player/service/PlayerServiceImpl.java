package com.player.service;

import com.player.controller.response.LifeEventDate;
import com.player.controller.response.LifeEventLocation;
import com.player.controller.response.PlayerResponse;
import com.player.controller.exception.NotFoundException;
import com.player.dao.PlayerDao;
import com.player.dao.entity.Player;
import com.player.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerDao playerDao;

    @Override
    public PlayerResponse getPlayerById(String playerId) {
        final Player playerByPlayerId = findPlayerByPlayerId(playerId);
        return getBuild(playerByPlayerId);
    }

    @Override
    public List<PlayerResponse> getAllPlayer() {
        final List<Player> allPlayers = playerDao.findAllPlayers();
        List<PlayerResponse> playerRespons = new ArrayList<>();
        for (Player player : allPlayers) {
            playerRespons.add(getBuild(player));
        }
        return playerRespons;
    }

    private Player findPlayerByPlayerId(String playerId) {
        Player play = playerDao.getPlayByPlayerId(playerId);
        if (play == null) {
            throw new NotFoundException(String.format("Player player_id: '%s' was not found", playerId));
        }
        return play;
    }

    private static PlayerResponse getBuild(Player playerByPlayerId) {
        return PlayerResponse.builder().playerID(playerByPlayerId.getPlayerID())
                .birthDate(new LifeEventDate(playerByPlayerId.getBirthYear(), playerByPlayerId.getBirthMonth(), playerByPlayerId.getBirthDay()))
                .birthLocation(new LifeEventLocation(playerByPlayerId.getBirthCountry(), playerByPlayerId.getBirthState(), playerByPlayerId.getBirthCity()))
                .deathDate(new LifeEventDate(playerByPlayerId.getDeathYear(), playerByPlayerId.getDeathMonth(), playerByPlayerId.getDeathDay()))
                .deathLocation(new LifeEventLocation(playerByPlayerId.getDeathCountry(), playerByPlayerId.getDeathState(), playerByPlayerId.getDeathCity()))
                .nameFirst(playerByPlayerId.getNameFirst())
                .nameLast(playerByPlayerId.getNameLast())
                .nameGiven(playerByPlayerId.getNameGiven())
                .weight(playerByPlayerId.getWeight())
                .height(playerByPlayerId.getHeight())
                .bats(playerByPlayerId.getBats())
                .throwsPlayer(playerByPlayerId.getThrowsPlayer())
                .debut(DateUtil.convertToString(playerByPlayerId.getDebut()))
                .finalGame(DateUtil.convertToString(playerByPlayerId.getFinalGame()))
                .retroID(playerByPlayerId.getRetroID())
                .bbrefID(playerByPlayerId.getBbrefID())
                .build();
    }

}
