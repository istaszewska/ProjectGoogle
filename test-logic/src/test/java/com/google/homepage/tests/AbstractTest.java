package com.google.homepage.tests;

import com.github.javafaker.Faker;
import com.google.homepage.pageobjects.HomePage;
import com.google.homepage.webdriver.WebDriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class AbstractTest {

    protected final WebDriver driver = WebDriverFactory.getWebDriver();
    Faker f = new Faker();
    HomePage homePage = new HomePage(driver);

    @BeforeEach
    void setUp() {
        driver.get("https://www.google.com");
    }

    @AfterAll
    static void tearDown() {
        WebDriverFactory.quitWebDriver();
    }


}
