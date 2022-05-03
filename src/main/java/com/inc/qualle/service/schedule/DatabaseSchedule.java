package com.inc.qualle.service.schedule;

import com.inc.qualle.service.DatabaseBackupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DatabaseSchedule {

    private final DatabaseBackupService backupService;

    @Scheduled(fixedDelay = 60000)
    public void databaseBackup() {
        backupService.backup();
    }
}
