package com.qualle.service.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FilesUtil {

    private static final String VOTES_FILE_NAME = "votes.txt";
    private static final File file = new File(VOTES_FILE_NAME);
    private static final Map<String, Integer> EMPTY_MAP = Map.of(
            "one_star", 0,
            "two_stars", 0,
            "three_stars", 0,
            "four_stars", 0,
            "five_stars", 0
    );

    static {

        try {
            if (file.createNewFile()) {
                create();
            }
        } catch (IOException ignore) {
        }
    }

    public static void write(String key) {
        Properties properties = new Properties();
        Map<String, Integer> votes = read();

        try (FileOutputStream stream = new FileOutputStream(file)) {
            votes.put(key, votes.get(key) + 1);

            for (Map.Entry<String, Integer> entry : votes.entrySet()) {
                properties.put(entry.getKey(), entry.getValue().toString());
            }

            properties.store(stream, null);

        } catch (IOException ignore) {
        }
    }

    public static Map<String, Integer> read() {
        Map<String, Integer> votes = new HashMap<>();
        Properties properties = new Properties();

        try (FileInputStream stream = new FileInputStream(file)) {
            properties.load(stream);

            for (String key : properties.stringPropertyNames()) {
                votes.put(key, Integer.valueOf(properties.get(key).toString()));
            }

        } catch (IOException ignore) {
        }
        return votes;
    }

    private static void create() throws IOException {
        Properties properties = new Properties();
        FileOutputStream stream = new FileOutputStream(file);

        for (Map.Entry<String, Integer> entry : EMPTY_MAP.entrySet()) {
            properties.put(entry.getKey(), entry.getValue().toString());
        }
        properties.store(stream, null);
    }
}