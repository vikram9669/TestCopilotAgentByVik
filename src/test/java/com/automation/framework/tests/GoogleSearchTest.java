package com.automation.framework.tests;

import com.automation.framework.base.BaseTest;
import com.automation.framework.pages.GoogleHomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * GoogleSearchTest - Test class for Google search functionality
 */
public class GoogleSearchTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(GoogleSearchTest.class);

    /**
     * Test to verify Google homepage is loaded
     */
    @Test(description = "Verify Google homepage is loaded successfully")
    public void testGoogleHomePageLoaded() {
        logger.info("========== Test: Google Homepage Loaded ==========");

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        boolean isLoaded = googleHomePage.isHomePageLoaded();

        assertTrue(isLoaded, "Google homepage should be loaded");
        logger.info("Test passed: Google homepage is loaded");
    }

    /**
     * Test to verify page title
     */
    @Test(description = "Verify Google page title")
    public void testGooglePageTitle() {
        logger.info("========== Test: Google Page Title ==========");

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        String pageTitle = googleHomePage.getPageTitle();

        assertTrue(pageTitle.contains("Google"), "Page title should contain 'Google'");
        logger.info("Test passed: Page title is correct - " + pageTitle);
    }

    /**
     * Test to verify search functionality
     */
    @Test(description = "Verify Google search functionality")
    public void testGoogleSearchFunctionality() {
        logger.info("========== Test: Google Search Functionality ==========");

        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        googleHomePage.searchFor("Selenium WebDriver");

        String currentURL = googleHomePage.getCurrentURL();
        assertTrue(currentURL.contains("search"), "URL should contain 'search' parameter");
        logger.info("Test passed: Search functionality works correctly");
    }
}
