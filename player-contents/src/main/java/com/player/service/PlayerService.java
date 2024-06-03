package com.player.service;

import com.player.controller.response.PlayerResponse;

import java.util.List;

public interface PlayerService {
    PlayerResponse getPlayerById(String playerId);

    List<PlayerResponse> getAllPlayer();
}
