package com.automation.framework.tests;

import com.automation.framework.base.BaseTest;
import com.automation.framework.pages.BingHomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * BingSearchTest - Test class for Bing search functionality
 */
public class BingSearchTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(BingSearchTest.class);

    /**
     * Test to verify Bing homepage is loaded
     */
    @Test(description = "Verify Bing homepage is loaded successfully")
    public void testBingHomePageLoaded() {
        logger.info("========== Test: Bing Homepage Loaded ==========");

        // Navigate to Bing
        driver.navigate().to("https://www.bing.com");

        BingHomePage bingHomePage = new BingHomePage(driver);

        // Verify search box is available on the page
        boolean searchBoxPresent = bingHomePage.isElementDisplayed(By.id("sb_form_q"));
        assertTrue(searchBoxPresent, "Bing search box should be visible");
        logger.info("Test passed: Bing homepage is loaded and search box is visible");
    }

    /**
     * Test to verify Bing page title
     */
    @Test(description = "Verify Bing page title")
    public void testBingPageTitle() {
        logger.info("========== Test: Bing Page Title ==========");

        // Navigate to Bing
        driver.navigate().to("https://www.bing.com");

        BingHomePage bingHomePage = new BingHomePage(driver);
        String pageTitle = bingHomePage.getPageTitle();

        assertTrue(pageTitle.contains("Bing"), "Page title should contain 'Bing'");
        logger.info("Test passed: Page title is correct - " + pageTitle);
    }

    /**
     * Test to search for "breaking news" on Bing
     */
    @Test(description = "Verify Bing search for breaking news")
    public void testBingSearchBreakingNews() {
        logger.info("========== Test: Bing Search for Breaking News ==========");

        // Navigate to Bing
        driver.navigate().to("https://www.bing.com");

        BingHomePage bingHomePage = new BingHomePage(driver);

        // Verify search box is available
        boolean searchBoxPresent = bingHomePage.isElementDisplayed(By.id("sb_form_q"));
        assertTrue(searchBoxPresent, "Bing search box should be visible");
        logger.info("Bing homepage loaded successfully");

        // Search for breaking news
        bingHomePage.searchFor("breaking news");
        logger.info("Searched for 'breaking news' on Bing");

        // Verify search results are displayed
        String currentURL = bingHomePage.getCurrentURL();
        assertTrue(currentURL.contains("q=breaking+news") || currentURL.contains("q=breaking%20news"),
                   "URL should contain search query parameter");

        String pageTitle = bingHomePage.getPageTitle();
        assertTrue(pageTitle.toLowerCase().contains("breaking news"),
                   "Page title should contain 'breaking news'");

        logger.info("Test passed: Successfully searched for breaking news on Bing");
        logger.info("Search results URL: " + currentURL);
    }
}
