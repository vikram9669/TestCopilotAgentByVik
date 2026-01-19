package com.automation.framework.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader utility class for reading configuration properties
 */
public class ConfigReader {

    private static final Logger logger = LogManager.getLogger(ConfigReader.class);
    private static Properties properties;
    private static final String PROPERTIES_FILE_PATH = "src/test/resources/config.properties";

    static {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE_PATH);
            properties.load(fileInputStream);
            fileInputStream.close();
            logger.info("Configuration loaded successfully");
        } catch (IOException e) {
            logger.error("Failed to load configuration file: " + PROPERTIES_FILE_PATH);
            throw new RuntimeException("Failed to load properties file");
        }
    }

    /**
     * Get property value by key
     *
     * @param key Property key
     * @return Property value
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.warn("Property not found: " + key);
        }
        return value;
    }

    /**
     * Get browser name
     *
     * @return Browser name
     */
    public static String getBrowser() {
        return getProperty("browser");
    }

    /**
     * Get base URL
     *
     * @return Base URL
     */
    public static String getBaseURL() {
        return getProperty("baseURL");
    }

    /**
     * Get implicit wait timeout
     *
     * @return Timeout in seconds
     */
    public static long getImplicitWait() {
        return Long.parseLong(getProperty("implicitWait"));
    }

    /**
     * Get explicit wait timeout
     *
     * @return Timeout in seconds
     */
    public static long getExplicitWait() {
        return Long.parseLong(getProperty("explicitWait"));
    }

    /**
     * Get page load timeout
     *
     * @return Timeout in seconds
     */
    public static long getPageLoadTimeout() {
        return Long.parseLong(getProperty("pageLoadTimeout"));
    }

    /**
     * Should take screenshot on failure
     *
     * @return true if should take screenshot, false otherwise
     */
    public static boolean shouldTakeScreenshotOnFailure() {
        return Boolean.parseBoolean(getProperty("takeScreenshotOnFailure"));
    }

    /**
     * Get screenshot directory
     *
     * @return Screenshot directory path
     */
    public static String getScreenshotDirectory() {
        return getProperty("screenshotDirectory");
    }
}
