# Selenium TestNG Automation Framework

A robust and scalable Selenium test automation framework built with Java, TestNG, and following the Page Object Model (POM) design pattern.

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/automation/framework/
│   │       ├── base/
│   │       │   ├── BaseTest.java          # Base test class with setup/teardown
│   │       │   └── BasePage.java          # Base page class with common actions
│   │       └── pages/
│   │           └── GoogleHomePage.java    # Sample page object
│   └── resources/
│       └── log4j2.xml                     # Log4j2 configuration
├── test/
│   ├── java/
│   │   └── com/automation/framework/
│   │       └── tests/
│   │           └── GoogleSearchTest.java  # Sample test class
│   └── resources/
│       └── testng.xml                     # TestNG configuration
└── pom.xml                                 # Maven configuration
```

## Features

✅ **Page Object Model (POM)** - Organized, maintainable test structure
✅ **Selenium 4.15.0** - Latest WebDriver implementation
✅ **TestNG Framework** - Powerful test framework with annotations
✅ **WebDriverManager** - Automatic browser driver management
✅ **Log4j2 Logging** - Comprehensive logging capabilities
✅ **Maven Build** - Easy dependency management and test execution
✅ **Multiple Browser Support** - Chrome, Firefox, Edge
✅ **Explicit Waits** - Smart element waiting with WebDriverWait
✅ **AssertJ** - Fluent assertions for better test readability

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Git (optional)

## Installation

1. **Clone or Download the Framework**
   ```bash
   git clone <repository-url>
   cd selenium-testng-framework
   ```

2. **Install Dependencies**
   ```bash
   mvn clean install
   ```

## Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test Class
```bash
mvn clean test -Dtest=GoogleSearchTest
```

### Run Specific Test Method
```bash
mvn clean test -Dtest=GoogleSearchTest#testGoogleHomePageLoaded
```

### Run with Different Browser
```bash
mvn clean test -Dbrowser=firefox
mvn clean test -Dbrowser=edge
mvn clean test -Dbrowser=chrome
```

### Run with Custom Base URL
```bash
mvn clean test -DbaseURL=https://www.example.com
```

## Configuration

### Changing Default Settings

Edit **pom.xml** to modify:
- Selenium version
- TestNG version
- Log4j version
- Java compiler target version

### Log4j2 Configuration

Edit **src/main/resources/log4j2.xml** to:
- Change log levels
- Modify log file location
- Adjust rolling file policies

### TestNG Configuration

Edit **src/test/resources/testng.xml** to:
- Add/remove test classes
- Configure test suites
- Set parallel execution
- Define test groups

## Creating New Tests

### Step 1: Create a Page Object Class

```java
package com.automation.framework.pages;

import com.automation.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourPageName extends BasePage {
    
    private final By element = By.id("elementId");
    
    public YourPageName(WebDriver driver) {
        super(driver);
    }
    
    public void yourMethod() {
        click(element);
    }
}
```

### Step 2: Create a Test Class

```java
package com.automation.framework.tests;

import com.automation.framework.base.BaseTest;
import com.automation.framework.pages.YourPageName;
import org.testng.annotations.Test;

public class YourTestClass extends BaseTest {
    
    @Test(description = "Your test description")
    public void testYourScenario() {
        YourPageName page = new YourPageName(driver);
        page.yourMethod();
    }
}
```

### Step 3: Add Test to TestNG Suite

Update **src/test/resources/testng.xml** to include your new test class.

## Available BasePage Methods

### Element Interaction
- `click(By locator)` - Click on element
- `sendKeys(By locator, String text)` - Enter text
- `getText(By locator)` - Get element text
- `isElementDisplayed(By locator)` - Check visibility

### Dropdown Operations
- `selectDropdownByValue(By locator, String value)` - Select by value
- `selectDropdownByText(By locator, String text)` - Select by visible text

### Wait Operations
- `waitForElementVisibility(By locator)` - Wait for element to appear
- `waitForElementToDisappear(By locator)` - Wait for element to disappear

### Navigation
- `scrollToElement(By locator)` - Scroll to element
- `getPageTitle()` - Get page title
- `getCurrentURL()` - Get current URL

## Logging

Logs are automatically generated in the **logs/** directory:
- **automation.log** - Main log file
- **automation-YYYY-MM-DD-n.log** - Rolled over log files

View logs to debug test execution and failures.

## Best Practices

1. **Use Explicit Waits** - Always use WebDriverWait instead of Thread.sleep()
2. **Keep Page Objects Focused** - One page object per page/component
3. **Avoid Hardcoding** - Use variables and configuration files
4. **Follow Naming Conventions** - Use meaningful test and method names
5. **Add Assertions** - Use meaningful assertions with clear messages
6. **Log Important Steps** - Add logging for debugging purposes
7. **Handle Exceptions** - Implement proper error handling

## Troubleshooting

### WebDriver Not Found
- Ensure WebDriverManager dependency is installed
- Check internet connection (WebDriverManager downloads drivers)

### Test Execution Failed
- Check logs in **logs/** directory
- Verify element locators are correct
- Ensure application under test is accessible

### Compilation Issues
- Verify Java version (11 or higher)
- Run `mvn clean install` to refresh dependencies

## Contributing

To add new features:
1. Create a new branch
2. Make your changes
3. Run tests to ensure nothing breaks
4. Submit a pull request

## License

This project is licensed under the MIT License - see LICENSE file for details.

## Support

For issues or questions, please open an issue in the project repository.

---

Happy Testing! 🚀
