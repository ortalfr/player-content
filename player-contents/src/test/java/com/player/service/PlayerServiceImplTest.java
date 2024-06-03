package com.player.service;

import com.player.controller.response.PlayerResponse;
import com.player.controller.exception.NotFoundException;
import com.player.dao.PlayerDao;
import com.player.dao.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PlayerServiceImplTest {

    @Mock
    private PlayerDao playerDao;

    @InjectMocks
    private PlayerServiceImpl playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getPlayerById_ExistingPlayer_ReturnsPlayerResponse() {
        // Given
        String playerId = "aardsda01";
        Player player = createPlayer();
        when(playerDao.getPlayByPlayerId(playerId)).thenReturn(player);

        // When
        PlayerResponse response = playerService.getPlayerById(playerId);

        // Then
        assertNotNull(response);
        assertEquals(player.getPlayerID(), response.getPlayerID());
    }

    @Test
    void getPlayerById_NonExistingPlayer_ThrowsNotFoundException() {
        // Given
        String playerId = "non_existing_player";
        when(playerDao.getPlayByPlayerId(playerId)).thenReturn(null);

        assertThrows(NotFoundException.class, () -> playerService.getPlayerById(playerId));
    }

    @Test
    void getAllPlayer_ReturnsListOfPlayerResponses() {
        // Given
        List<Player> players = Arrays.asList(createPlayer(), createPlayer());
        when(playerDao.findAllPlayers()).thenReturn(players);

        // When
        List<PlayerResponse> responses = playerService.getAllPlayer();

        // Then
        assertNotNull(responses);
        assertEquals(players.size(), responses.size());
    }

    private Player createPlayer() {
        Player player = new Player();
        player.setPlayerID("aardsda01");
        player.setBirthYear(1981);
        player.setBirthMonth(12);
        player.setBirthDay(27);
        return player;
    }
}
