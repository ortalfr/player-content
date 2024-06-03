package com.player.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Slf4j
public class  DateUtil {
    public static String convertToString(Timestamp source) {
        if (source == null) {
            return "";
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(source);
        } catch (Exception e) {
            log.error("Error while converting date to string", e);
            return "";
        }
    }

    public static Timestamp convertToTimestamp(String source)  {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date;
        Timestamp timestamp;
        try {
            // Parse the string to a Date object
            date = formatter.parse(source);
            timestamp = new Timestamp(date.getTime());
        } catch (ParseException e) {
            log.warn("Failed to parse {}", source);
            return null;
        }
        return timestamp;
    }
}
