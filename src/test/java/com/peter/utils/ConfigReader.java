package com.peter.utils;

import com.peter.constants.FrameworkConstants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    static {

        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream(FrameworkConstants.CONFIG_FILE)) {

            if (input == null) {
                throw new RuntimeException("config.properties was not found");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Error reading config.properties", e);
        }

    }

    private ConfigReader() {
    }

    /*
     * This get should help to get the value of the key from -Dheadless=true when
     * tests are executed in a CI environment
     */
    public static String get(String key) {

        String systemValue = System.getProperty(key);

        if (systemValue != null) {
            return systemValue;
        }

        return properties.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

}