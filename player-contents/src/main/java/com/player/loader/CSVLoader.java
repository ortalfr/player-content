package com.player.loader;

import com.opencsv.CSVReader;
import com.player.dao.PlayerDao;
import com.player.dao.entity.Player;
import com.player.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CSVLoader {

    private final PlayerDao playerDao;

    public void loadCSVData(String csvFile) {
        try {
            // Load CSV file from resources directory
            try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
                log.info("Reading CSV file");
                List<String[]> rows = reader.readAll();
                for (int i = 1; i < rows.size(); i++) {
                    Player player = getPlayer(rows, i);
                    playerDao.save(player);
                }
                log.info("CSV file loaded successfully");
            }
        } catch (Exception e) {
            log.error("Error while loading CSV file", e);
        }
    }

    public Player getPlayer(List<String[]> rows, int i) {
        String[] row = rows.get(i);
        Player player = new Player();
        player.setPlayerID(row[0]);
        if (!row[1].isEmpty()) {
            player.setBirthYear(getInteger(row[1]));
        }
        if (!row[2].isEmpty()) {
            player.setBirthMonth(getInteger(row[2]));
        }
        if (!row[3].isEmpty()) {
            player.setBirthDay(getInteger(row[3]));
        }
        if (!row[4].isEmpty()) {
            player.setBirthCountry(row[4]);
        }
        if (!row[5].isEmpty()) {
            player.setBirthState(row[5]);
        }
        if (!row[6].isEmpty()) {
            player.setBirthCity(row[6]);
        }
        if (!row[7].isEmpty()) {
            player.setDeathYear(getInteger(row[7]));
        }
        if (!row[8].isEmpty()) {
            player.setDeathMonth(getInteger(row[8]));
        }
        if (!row[9].isEmpty()) {
            player.setDeathDay(getInteger(row[9]));
        }
        if (!row[10].isEmpty()) {
            player.setDeathCountry(row[10]);
        }
        if (!row[11].isEmpty()) {
            player.setDeathState(row[11]);
        }
        if (!row[12].isEmpty()) {
            player.setDeathCity(row[12]);
        }
        if (!row[13].isEmpty()) {
            player.setNameFirst(row[13]);
        }
        if (!row[14].isEmpty()) {
            player.setNameLast(row[14]);
        }
        if (!row[15].isEmpty()) {
            player.setNameGiven(row[15]);
        }
        if (!row[16].isEmpty()) {
            player.setWeight(getInteger(row[16]));
        }
        if (!row[17].isEmpty()) {
            player.setHeight(getInteger(row[17]));
        }
        if (!row[1].isEmpty()) {
            player.setBats(row[18]);
        }
        if (!row[19].isEmpty()) {
            player.setThrowsPlayer(row[19]);
        }
        if (!row[20].isEmpty()) {
            player.setDebut(DateUtil.convertToTimestamp(row[20]));
        }
        if (!row[21].isEmpty()) {
            player.setFinalGame(DateUtil.convertToTimestamp(row[21]));
        }
        if (!row[22].isEmpty()) {
            player.setRetroID(row[22]);
        }
        if (!row[23].isEmpty()) {
            player.setBbrefID(row[23]);
        }
        return player;
    }

    public Integer getInteger(String value) {
        return value.isEmpty() ? null : Integer.parseInt(value);
    }
}
