package com.player.controller;

import com.player.controller.response.PlayerResponse;
import com.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@Slf4j
@RequiredArgsConstructor
public class PlayerContentsController {

    private final PlayerService playerService;

    @GetMapping("{playerId}")
    public PlayerResponse getPlayerByPlayerId(@PathVariable String playerId) {
        log.info("getPlayerByPlayerId: Player ID: {}", playerId);
        return playerService.getPlayerById(playerId);
    }

    @GetMapping()
    public List<PlayerResponse> getAllPlayers() {
        log.info("getAllPlayers");
        return playerService.getAllPlayer();
    }
}
