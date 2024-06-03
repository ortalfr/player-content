package com.player.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.player.controller.response.PlayerResponse;
import com.player.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PlayerContentsController.class)
@AutoConfigureMockMvc(addFilters = false)
class PlayerContentsControllerTest {

    private final static String PLAYERS = "/api/players";


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PlayerService playerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenValidUrlAndMethodAndContentTypeAndValidInput_getPlayerById_thenReturns200()
            throws Exception {
        String id = "sds";
        PlayerResponse playerResponse = PlayerResponse.builder().playerID(id).build();
        when(playerService.getPlayerById(id)).thenReturn(playerResponse);

        mockMvc.perform(get(PLAYERS + "/" + id)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(playerResponse)))
                .andExpect(status().isOk());

    }

    @Test
    void whenValidUrlAndMethodAndContentTypeAndValidInput_getAllPlayer_thenReturns200()
            throws Exception {
        PlayerResponse playerResponse = PlayerResponse.builder().playerID("id").build();
        when(playerService.getAllPlayer()).thenReturn(List.of(playerResponse));

        mockMvc.perform(get(PLAYERS)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(playerResponse)))
                .andExpect(status().isOk());

    }

}
