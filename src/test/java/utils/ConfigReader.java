package com.aditya.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    /**
     * Loads configuration from the config.properties file if not already loaded.
     */
    public static void loadConfig() {
        if (prop == null) {
            prop = new Properties();
            try (FileInputStream fis = new FileInputStream("config.properties")) {
                prop.load(fis);
                System.out.println("✅ Config file loaded successfully.");
            } catch (FileNotFoundException e) {
                System.err.println("❌ config.properties file not found. Please place it in the project root.");
            } catch (IOException e) {
                System.err.println("❌ Failed to load config.properties: " + e.getMessage());
            }
        }
    }

    /**
     * Retrieves a config property by key.
     * If the key doesn't exist, logs a warning.
     */
    public static String getProperty(String key) {
        if (prop == null) {
            loadConfig();
        }

        String value = prop.getProperty(key);
        if (value == null) {
            System.err.println("⚠️ Warning: Key '" + key + "' not found in config.properties.");
        }
        return value;
    }
}
