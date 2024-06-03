package com.player.controller.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerResponseTest {
    @Test
    void testGetBirthYear_WhenBirthDateIsNull_ReturnsZero() {
        PlayerResponse playerResponse = PlayerResponse.builder()
                .birthDate(null)
                .build();

        int birthYear = playerResponse.getBirthYear();

        assertEquals(0, birthYear);
    }

    @Test
    void testGetBirthYear_WhenBirthDateIsNotNull_ReturnsYear() {
        LifeEventDate birthDate = new LifeEventDate(1990, 5, 15);
        PlayerResponse playerResponse = PlayerResponse.builder()
                .birthDate(birthDate)
                .build();

        int birthYear = playerResponse.getBirthYear();

        assertEquals(1990, birthYear);
    }

    @Test
    void testGetDeathCountry_WhenDeathCountryIsNotNull_ReturnsCountry() {
        LifeEventLocation deathLocation = new LifeEventLocation("USA","CO" , "Denver");
        PlayerResponse playerResponse = PlayerResponse.builder()
                .deathLocation(deathLocation)
                .build();

        final String deathCountry = playerResponse.getDeathCountry();

        assertEquals("USA", deathCountry);
    }

    @Test
    void testGetDeathCountry_WhenDeathCountryItNull_ReturnsEmptyString() {
        LifeEventLocation deathLocation = new LifeEventLocation(null,null , null);
        PlayerResponse playerResponse = PlayerResponse.builder()
                .deathLocation(deathLocation)
                .build();

        final String deathCountry = playerResponse.getDeathCountry();

        assertEquals("", deathCountry);
    }
}
