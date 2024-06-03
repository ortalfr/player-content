package com.player.licener;

import com.player.loader.CSVLoader;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ApplicationStartedEvent> {

    private final CSVLoader csvLoader;

    public StartupListener(CSVLoader csvLoader) {
        this.csvLoader = csvLoader;
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        String csvFile = "src/main/java/com/player/loader/player.csv";
        csvLoader.loadCSVData(csvFile);
    }
}
