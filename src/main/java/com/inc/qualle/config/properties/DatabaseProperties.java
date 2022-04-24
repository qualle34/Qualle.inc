package com.inc.qualle.config.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatabaseProperties {

    private String file;
    private String container;
    private String restoreCommand;
    private String backupCommand;
}