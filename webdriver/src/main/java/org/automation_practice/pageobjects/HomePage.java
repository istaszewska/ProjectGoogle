package org.automation_practice.pageobjects;

import lombok.Getter;
import net.thucydides.core.annotations.Step;
import org.automation_practice.AbstractPage;
import org.automation_practice.components.Footer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='lJ9FBc']//input[@class='gNO89b']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@role = 'combobox']")
    private WebElement searchInputBox;

    @FindBy(css = "#L2AGLb div")
    private WebElement acceptAllButton;

    @FindBy(xpath = "//a[@class='gb_A']")
    private WebElement googleApplicationButton;

    @FindBy(css = "div.FPdoLc input.RNmpXc")
    private WebElement luckyStrikeButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Footer footer() {
        return new Footer(driver);
    }


    @Step("Accept cookies")
    public HomePage acceptCookies() {
        waitForButtonAndClick(acceptAllButton);
        return this;
    }

    @Step("Click search")
    public HomePage clickSearchButton() {
        waitForButtonAndClick(searchButton);
        return this;
    }

    @Step("Navigate to Lucky Strike")
    public HomePage navigateToLuckyStrike(){
        waitForButtonAndClick(luckyStrikeButton);
        return this;
    }


    @Step("Type into Search Field {inputPhrase}")
    public HomePage typeIntoUserNameField(String inputPhrase) {
        waitForElement(searchInputBox);
        searchInputBox.clear();
        searchInputBox.sendKeys(inputPhrase);
        log().info("Typed into User Name Field {}", inputPhrase);
        return this;
    }

    @Step("Get all search results from first page")
    public List<String> getSearchResults() {
        return driver.findElements(By.xpath("//h3[contains(@class,'LC20lb')]"))
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }


}
