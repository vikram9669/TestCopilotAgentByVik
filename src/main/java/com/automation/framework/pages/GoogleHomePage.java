package com.automation.framework.pages;

import com.automation.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * GoogleHomePage - Page Object for Google homepage
 */
public class GoogleHomePage extends BasePage {

    // Locators
    private final By searchBox = By.name("q");
    private final By searchButton = By.name("btnK");
    private final By feelingLuckyButton = By.name("btnI");
    private final By googleLogo = By.xpath("//img[@alt='Google']");

    /**
     * Constructor
     *
     * @param driver WebDriver instance
     */
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verify Google homepage is loaded
     *
     * @return true if homepage is loaded, false otherwise
     */
    public boolean isHomePageLoaded() {
        return isElementDisplayed(googleLogo);
    }

    /**
     * Perform search
     *
     * @param searchQuery Search query text
     */
    public void searchFor(String searchQuery) {
        sendKeys(searchBox, searchQuery);
        click(searchButton);
    }

    /**
     * Get search box element
     *
     * @return Search box element
     */
    public String getSearchBoxPlaceholder() {
        return getText(searchBox);
    }
}
