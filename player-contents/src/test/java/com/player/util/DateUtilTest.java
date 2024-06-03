package com.player.util;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DateUtilTest {

    @Mock
    private Logger logger = Mockito.mock(Logger.class);

    @Test
    void convertToString_NullTimestamp_ReturnsEmptyString() {
        // Given
        Timestamp timestamp = null;

        // When
        String result = DateUtil.convertToString(timestamp);

        // Then
        assertEquals("", result);
    }

    @Test
    void convertToString_ValidTimestamp_ReturnsFormattedString() {
        // Given
        Timestamp timestamp = Timestamp.valueOf("2022-01-01 00:00:00");

        // When
        String result = DateUtil.convertToString(timestamp);

        // Then
        assertEquals("2022-01-01", result);
    }

    @Test
    void convertToTimestamp_ValidDateString_ReturnsTimestamp() {
        // Given
        String dateString = "2022-01-01";

        // When
        Timestamp result = DateUtil.convertToTimestamp(dateString);

        // Then
        assertEquals(Timestamp.valueOf("2022-01-01 00:00:00"), result);
    }

    @Test
    void convertToTimestamp_InvalidDateString_ThrowsParseException() {
        // Given
        String dateString = "invalid-date-string";
        // When
        Timestamp timestamp = DateUtil.convertToTimestamp(dateString);
        // Then
        assertNull(timestamp);
    }
}

