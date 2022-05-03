package com.inc.qualle.service.impl;

import com.inc.qualle.config.properties.ApplicationProperties;
import com.inc.qualle.service.DatabaseBackupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class DatabaseBackupServiceImpl implements DatabaseBackupService {

    private final ApplicationProperties properties;

    @Override
    public void backup() {
        try {
            Process child = Runtime.getRuntime().exec(properties.getDatabase().getBackupCommand());
            BufferedReader reader = new BufferedReader(new InputStreamReader(child.getInputStream(), "utf8"));
            StringBuilder builder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\r\n");
            }

            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(properties.getDatabase().getFile()), "utf8");
            writer.write(builder.toString());
            writer.flush();

            reader.close();
            writer.close();

            log.info("Database backup completed successfully");

        } catch (Exception e) {
            throw new RuntimeException("Unable to process database backup: ", e);
        }
    }

    @Override
    public void load() {
        try {
            Runtime.getRuntime().exec((properties.getDatabase().getRestoreCommand()));

        } catch (Exception e) {
            throw new RuntimeException("Unable to process database restore: ", e);
        }
    }
}
