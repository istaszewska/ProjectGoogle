package com.google.homepage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Wait<WebDriver> fluentWait;
    protected Actions action;
    private Logger logger = LogManager.getLogger(this.getClass().getName());

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitFluentlyForWebElement(WebElement element) {
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForButtonAndClick(WebElement button) {
        waitForElement(button);
        button.click();
    }

    public void getElementAndPressKey(WebElement element, Keys key){
        waitForElement(element);
        element.sendKeys(key);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected Logger log() {
        return logger;
    }

    public void hooverOverWebElement(WebElement webElement) {
        action.moveToElement(webElement).perform();
    }

}
