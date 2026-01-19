package com.automation.framework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage class provides common actions and utilities for all Page Objects.
 */
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(BasePage.class);
    private static final int WAIT_TIMEOUT = 10;

    /**
     * Constructor to initialize WebDriver and PageFactory
     *
     * @param driver WebDriver instance
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    /**
     * Find element by locator
     *
     * @param locator By locator
     * @return WebElement
     */
    protected WebElement findElement(By locator) {
        logger.info("Finding element: " + locator);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Click on element
     *
     * @param locator By locator
     */
    public void click(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            logger.info("Clicked on element: " + locator);
        } catch (Exception e) {
            logger.error("Failed to click on element: " + locator);
            throw e;
        }
    }

    /**
     * Enter text in input field
     *
     * @param locator By locator
     * @param text    Text to enter
     */
    public void sendKeys(By locator, String text) {
        try {
            WebElement element = findElement(locator);
            element.clear();
            element.sendKeys(text);
            logger.info("Entered text: " + text + " in element: " + locator);
        } catch (Exception e) {
            logger.error("Failed to enter text in element: " + locator);
            throw e;
        }
    }

    /**
     * Get text from element
     *
     * @param locator By locator
     * @return Text content
     */
    public String getText(By locator) {
        try {
            WebElement element = findElement(locator);
            String text = element.getText();
            logger.info("Retrieved text: " + text + " from element: " + locator);
            return text;
        } catch (Exception e) {
            logger.error("Failed to get text from element: " + locator);
            throw e;
        }
    }

    /**
     * Check if element is displayed
     *
     * @param locator By locator
     * @return true if element is displayed, false otherwise
     */
    public boolean isElementDisplayed(By locator) {
        try {
            WebElement element = findElement(locator);
            boolean isDisplayed = element.isDisplayed();
            logger.info("Element " + locator + " is displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            logger.warn("Element not displayed: " + locator);
            return false;
        }
    }

    /**
     * Select option from dropdown by value
     *
     * @param locator By locator
     * @param value   Value to select
     */
    public void selectDropdownByValue(By locator, String value) {
        try {
            WebElement element = findElement(locator);
            Select select = new Select(element);
            select.selectByValue(value);
            logger.info("Selected value: " + value + " from dropdown: " + locator);
        } catch (Exception e) {
            logger.error("Failed to select dropdown value: " + locator);
            throw e;
        }
    }

    /**
     * Select option from dropdown by visible text
     *
     * @param locator By locator
     * @param text    Visible text to select
     */
    public void selectDropdownByText(By locator, String text) {
        try {
            WebElement element = findElement(locator);
            Select select = new Select(element);
            select.selectByVisibleText(text);
            logger.info("Selected text: " + text + " from dropdown: " + locator);
        } catch (Exception e) {
            logger.error("Failed to select dropdown text: " + locator);
            throw e;
        }
    }

    /**
     * Scroll to element
     *
     * @param locator By locator
     */
    public void scrollToElement(By locator) {
        try {
            WebElement element = findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            logger.info("Scrolled to element: " + locator);
        } catch (Exception e) {
            logger.error("Failed to scroll to element: " + locator);
            throw e;
        }
    }

    /**
     * Wait for element to be visible
     *
     * @param locator By locator
     */
    public void waitForElementVisibility(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("Element is visible: " + locator);
        } catch (Exception e) {
            logger.error("Element not visible: " + locator);
            throw e;
        }
    }

    /**
     * Wait for element to disappear
     *
     * @param locator By locator
     */
    public void waitForElementToDisappear(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            logger.info("Element disappeared: " + locator);
        } catch (Exception e) {
            logger.error("Element still visible: " + locator);
            throw e;
        }
    }

    /**
     * Get page title
     *
     * @return Page title
     */
    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Page title: " + title);
        return title;
    }

    /**
     * Get current URL
     *
     * @return Current URL
     */
    public String getCurrentURL() {
        String url = driver.getCurrentUrl();
        logger.info("Current URL: " + url);
        return url;
    }
}
