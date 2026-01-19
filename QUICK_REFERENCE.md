# Quick Reference Guide - Selenium TestNG Framework

## 🚀 Quick Commands

```bash
# Navigate to project
cd C:\Users\vikra\OneDrive\Desktop\Vikram\TestCopilotAgentByVik

# Install dependencies (first time)
mvn clean install

# Run all tests
mvn clean test

# Run tests with specific browser
mvn clean test -Dbrowser=firefox

# Run specific test class
mvn clean test -Dtest=GoogleSearchTest

# Run specific test method
mvn clean test -Dtest=GoogleSearchTest#testGoogleHomePageLoaded
```

---

## 📁 Important Files to Modify

### 1. Change Base URL
**File**: `src/test/resources/config.properties`
```properties
baseURL=https://www.yourapp.com
```

### 2. Add Test Class
**Path**: `src/test/java/com/automation/framework/tests/`
**Template**: 
```java
package com.automation.framework.tests;
import com.automation.framework.base.BaseTest;
import org.testng.annotations.Test;

public class YourTestClass extends BaseTest {
    @Test
    public void testMethod() {
        // Your test code here
    }
}
```

### 3. Add Page Object
**Path**: `src/main/java/com/automation/framework/pages/`
**Template**:
```java
package com.automation.framework.pages;
import com.automation.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourPageObject extends BasePage {
    private final By element = By.id("elementId");
    
    public YourPageObject(WebDriver driver) {
        super(driver);
    }
    
    public void yourMethod() {
        click(element);
    }
}
```

---

## 🛠️ Common Methods Reference

### From BasePage

```java
// Click
click(By locator);

// Type
sendKeys(By locator, String text);

// Get Text
String text = getText(By locator);

// Check Visibility
boolean visible = isElementDisplayed(By locator);

// Select Dropdown
selectDropdownByValue(By locator, String value);
selectDropdownByText(By locator, String text);

// Scroll
scrollToElement(By locator);

// Wait
waitForElementVisibility(By locator);
waitForElementToDisappear(By locator);

// Navigation
String title = getPageTitle();
String url = getCurrentURL();
```

### From ScreenshotUtil

```java
// Take screenshot
ScreenshotUtil.takeScreenshot(driver, "testName");

// Take with default name
ScreenshotUtil.takeScreenshot(driver);
```

### From ConfigReader

```java
// Get properties
String browser = ConfigReader.getBrowser();
String baseURL = ConfigReader.getBaseURL();
long timeout = ConfigReader.getExplicitWait();
```

---

## 🧪 Sample Test Pattern

```java
@Test(description = "Test description")
public void testSomething() {
    // Create page object
    YourPageName page = new YourPageName(driver);
    
    // Perform actions
    page.actionOne();
    page.actionTwo();
    
    // Verify results
    assertTrue(page.verifyResult(), "Assertion message");
}
```

---

## 📊 Log Locations

| Log Type | Location |
|----------|----------|
| Main Log | `logs/automation.log` |
| Rolled Logs | `logs/automation-YYYY-MM-DD-n.log` |
| Screenshots | `target/screenshots/` |
| Test Reports | `target/surefire-reports/` |

---

## 🌐 Browser Options

```bash
# Chrome (default)
mvn clean test -Dbrowser=chrome

# Firefox
mvn clean test -Dbrowser=firefox

# Edge
mvn clean test -Dbrowser=edge
```

---

## ⚙️ Configuration Properties

```properties
# Browser (chrome, firefox, edge)
browser=chrome

# Base URL
baseURL=https://www.google.com

# Wait timeouts (seconds)
implicitWait=10
explicitWait=10
pageLoadTimeout=30

# Screenshot settings
takeScreenshotOnFailure=true
screenshotDirectory=./target/screenshots

# Logging
logLevel=INFO
```

---

## 📝 Naming Conventions

```
PageObject:     YourPageName.java           (extends BasePage)
TestClass:      YourFeatureTest.java        (extends BaseTest)
Test Method:    testSomethingSpecific()     (@Test annotation)
Locator:        private final By element    (camelCase)
Configuration:  propertyName                (camelCase)
```

---

## 🔍 Locator Examples

```java
// ID
By.id("elementId")

// XPath
By.xpath("//button[@class='submit']")

// CSS Selector
By.cssSelector(".class-name")

// Name
By.name("elementName")

// LinkText
By.linkText("Click Here")

// PartialLinkText
By.partialLinkText("Click")

// ClassName
By.className("button")

// TagName
By.tagName("button")
```

---

## 🎯 Best Practices Checklist

- ✅ Use explicit waits, not Thread.sleep()
- ✅ One locator = one action
- ✅ Page objects for reusability
- ✅ Meaningful test and method names
- ✅ Add logging for debugging
- ✅ Use assertions for verification
- ✅ Keep tests independent
- ✅ Use data-driven tests when applicable
- ✅ Take screenshots on failure
- ✅ Keep configuration externalized

---

## 🚨 Troubleshooting

| Issue | Solution |
|-------|----------|
| WebDriver not found | Check internet (WebDriverManager downloads drivers) |
| Element not found | Verify locator, check page load, add waits |
| Test timeout | Increase timeout in config.properties |
| Build failed | Run `mvn clean install` to refresh dependencies |
| Tests not running | Check testng.xml configuration |

---

## 📚 Documentation Files

- `README.md` - Full documentation
- `SETUP_SUMMARY.md` - Setup guide
- `FILE_MANIFEST.md` - File listing
- `QUICK_REFERENCE.md` - This file

---

## 💡 Tips & Tricks

1. **Use WebDriverWait** for reliable waits
2. **Keep locators in page objects** for maintainability
3. **Use meaningful names** for clarity
4. **Add logging** before assertions
5. **Take screenshots** on critical steps
6. **Group tests** logically in testng.xml
7. **Use @BeforeClass/@AfterClass** for setup/teardown
8. **Parameterize tests** with @DataProvider

---

## 🔗 Useful Links

- Selenium: https://www.selenium.dev/
- TestNG: https://testng.org/
- Maven: https://maven.apache.org/
- Log4j2: https://logging.apache.org/log4j/2.x/

---

**Framework Version**: 1.0.0
**Last Updated**: January 18, 2026

Happy Testing! 🎉
