package com.automation.framework.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * BaseTest class provides common setup and teardown for all test classes.
 */
public class BaseTest {

    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    private String browser;
    private String baseURL;

    /**
     * Initialize WebDriver before each test
     */
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        browser = System.getProperty("browser", "chrome");
        baseURL = System.getProperty("baseURL", "https://www.google.com");

        driver = initializeBrowser(browser);
        logger.info("Browser: " + browser + " started successfully");
        driver.manage().window().maximize();
        driver.get(baseURL);
        logger.info("Navigated to: " + baseURL);
    }

    /**
     * Close WebDriver after each test
     */
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed successfully");
        }
    }

    /**
     * Initialize the browser based on the type provided
     *
     * @param browserName Browser type (chrome, firefox, edge)
     * @return WebDriver instance
     */
    private WebDriver initializeBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions);

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                return new EdgeDriver(edgeOptions);

            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                return new ChromeDriver(chromeOptions);
        }
    }

    /**
     * Get WebDriver instance
     *
     * @return WebDriver instance
     */
    public WebDriver getDriver() {
        return driver;
    }
}
