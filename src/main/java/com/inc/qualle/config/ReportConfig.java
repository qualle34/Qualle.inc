package com.inc.qualle.config;

import com.inc.qualle.Application;
import com.inc.qualle.config.properties.ApplicationProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.URLDecoder;

@Slf4j
@Getter
@Component
@RequiredArgsConstructor
public class ReportConfig {

    private final ApplicationProperties properties;

    private String outputPath;

    @PostConstruct
    public void init() {
        outputPath = getBasePath() + properties.getReport().getOutputPath();

        log.info("outputPath: {}", outputPath);
    }

    private String getBasePath() {
        String path = null;

        try {
            path = Application.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            path = URLDecoder.decode(path, "utf-8");
            return path.substring(1, path.indexOf(properties.getFolderName()) + properties.getFolderName().length()) + "/";

        } catch (Exception e) {
            log.warn("Unable to get path ({}): {}", path, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
