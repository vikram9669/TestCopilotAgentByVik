package com.automation.framework.pages;

import com.automation.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * BingHomePage - Page Object for Bing homepage
 */
public class BingHomePage extends BasePage {

    // Locators
    private final By searchBox = By.id("sb_form_q");
    private final By searchButton = By.id("sb_form_go");
    private final By bingLogo = By.xpath("//div[@id='sbLogo']");

    /**
     * Constructor
     *
     * @param driver WebDriver instance
     */
    public BingHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verify Bing homepage is loaded
     *
     * @return true if homepage is loaded, false otherwise
     */
    public boolean isHomePageLoaded() {
        return isElementDisplayed(bingLogo);
    }

    /**
     * Perform search on Bing
     *
     * @param searchQuery Search query text
     */
    public void searchFor(String searchQuery) {
        sendKeys(searchBox, searchQuery);
        // Press Enter to search instead of clicking button
        findElement(searchBox).submit();
    }

    /**
     * Get page title
     *
     * @return Page title
     */
    public String getPageTitle() {
        return super.getPageTitle();
    }

    /**
     * Get current URL
     *
     * @return Current URL
     */
    public String getCurrentURL() {
        return super.getCurrentURL();
    }

    /**
     * Check if element is displayed
     *
     * @param locator By locator
     * @return true if element is displayed, false otherwise
     */
    public boolean isElementDisplayed(By locator) {
        return super.isElementDisplayed(locator);
    }
}
