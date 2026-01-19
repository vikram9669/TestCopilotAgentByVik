package com.automation.framework.utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ScreenshotUtil utility class for taking screenshots
 */
public class ScreenshotUtil {

    private static final Logger logger = LogManager.getLogger(ScreenshotUtil.class);

    /**
     * Take screenshot and save to file
     *
     * @param driver   WebDriver instance
     * @param fileName Name of the screenshot file
     * @return File path of the screenshot
     */
    public static String takeScreenshot(WebDriver driver, String fileName) {
        try {
            // Create screenshots directory if not exists
            String screenshotDir = ConfigReader.getScreenshotDirectory();
            File directory = new File(screenshotDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Generate timestamp for unique filename
            String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
            String screenshotPath = screenshotDir + File.separator + fileName + "_" + timestamp + ".png";

            // Take screenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotPath);

            // Copy screenshot to destination
            FileUtils.copyFile(srcFile, destFile);

            logger.info("Screenshot saved: " + screenshotPath);
            return screenshotPath;

        } catch (IOException e) {
            logger.error("Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }

    /**
     * Take screenshot with default naming
     *
     * @param driver WebDriver instance
     * @return File path of the screenshot
     */
    public static String takeScreenshot(WebDriver driver) {
        return takeScreenshot(driver, "screenshot");
    }
}
