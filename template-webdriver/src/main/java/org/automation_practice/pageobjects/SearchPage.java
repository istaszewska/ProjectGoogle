package org.automation_practice.pageobjects;

import org.automation_practice.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends AbstractPage {

    @FindBy(className = "alert")
    private WebElement searchAlert;

    @FindBy(className = "heading-counter")
    private WebElement searchCounter;

    private final String SEARCH_PRODUCTS_XPATH = "//div[@id='center_column']//a[@class='product-name']";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchErrorText() {
        wait.until(ExpectedConditions.visibilityOf(searchAlert));
        return searchAlert.getText();
    }

    public List<String> getListOfSearchProductsNames(String product) {
        return driver.findElements(By.xpath(SEARCH_PRODUCTS_XPATH))
                .stream().map(el -> el.getAttribute("innerText"))
                .collect(Collectors.toList());
    }

    public SearchPage waitForSearchCounter(){
        wait.until(ExpectedConditions.visibilityOf(searchCounter));
        return this;
    }
}
