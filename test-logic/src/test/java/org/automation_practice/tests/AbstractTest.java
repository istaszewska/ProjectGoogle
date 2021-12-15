package org.automation_practice.tests;

import org.automation_practice.configuration.TestData;
import org.automation_practice.factory.WebDriverFactory;
import org.automation_practice.model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class AbstractTest {

    protected final WebDriver driver = WebDriverFactory.getWebDriver();
    protected final TestData testData = new TestData();

    @BeforeEach
    void setUp() {
        driver.get("http://automationpractice.com");
    }

    @AfterAll
    static void tearDown() {
        WebDriverFactory.quitWebDriver();
    }

    protected void addSessionCookieToBrowserOf(User user) {
        driver.manage().deleteAllCookies();
        driver.manage().addCookie(user.getSessionCookie());
        driver.navigate().refresh();
    }

    public boolean compareFloatNum(double a, double b) {
        if (Math.abs(a - b) < 1e-9) {
            return true;
        }
        return false;
    }

}
