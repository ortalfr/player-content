package com.player.loader;

import com.player.dao.PlayerDao;
import com.player.dao.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CSVLoaderTest {
    @Mock
    PlayerDao playerDao;

    @InjectMocks
    CSVLoader csvLoader;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPlayer() {
        // Given
        List<String[]> rows = new ArrayList<>();
        String[] row = {"playerId", "1980", "1", "1", "USA", "NY", "New York", "", "", "", "", "", "", "John", "Doe", "John Doe", "200", "72", "L", "R", "2000-01-01", "2022-12-31", "retroId", "bbrefId"};
        rows.add(row);


        // When
        Player result = csvLoader.getPlayer(rows, 0);

        // Then
        assertEquals("playerId", result.getPlayerID());
        assertEquals(Integer.valueOf(1980), result.getBirthYear());
        assertEquals(Integer.valueOf(1), result.getBirthMonth());
        assertEquals(Integer.valueOf(1), result.getBirthDay());
        assertEquals("USA", result.getBirthCountry());
        assertEquals("NY", result.getBirthState());
        assertEquals("New York", result.getBirthCity());
        assertNull(result.getDeathYear());
        assertNull(result.getDeathMonth());
        assertNull(result.getDeathDay());
        assertNull(result.getDeathCountry());
        assertNull(result.getDeathState());
        assertNull(result.getDeathCity());
        assertEquals("John", result.getNameFirst());
        assertEquals("Doe", result.getNameLast());
        assertEquals("John Doe", result.getNameGiven());
        assertEquals(200, result.getWeight());
        assertEquals(72, result.getHeight());
        assertEquals("L", result.getBats());
        assertEquals("R", result.getThrowsPlayer());
        assertEquals("2000-01-01 00:00:00.0", result.getDebut().toString());
        assertEquals("2022-12-31 00:00:00.0", result.getFinalGame().toString());
        assertEquals("retroId", result.getRetroID());
        assertEquals("bbrefId", result.getBbrefID());
    }
}
