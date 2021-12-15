package org.automation_practice.pageobjects;

import org.automation_practice.AbstractPage;
import org.automation_practice.components.ItemsInCartPopup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TShirtsPage extends AbstractPage {

    @FindBy(xpath = "//a[@title='Add to cart' and @data-id-product='1']")
    private WebElement addButtonFirstTShirtOnList;
    @FindBy(xpath = "//a[@data-id-product='1']/../../div/span")
    private WebElement tShirtPrice;
    @FindBy(className = "icon-th-list")
    private WebElement listViewButton;
    @FindBy(xpath = "//div/div/h5/a[@class='product-name']")
    private WebElement tShirtName;

    public TShirtsPage(WebDriver driver) {
        super(driver);
    }

    public double getTShirtPrice(){
        wait.until(ExpectedConditions.visibilityOf(tShirtPrice));
        String price = tShirtPrice.getAttribute("outerText").replace("$","").trim();
        return Double.parseDouble(price);
    }

    public ItemsInCartPopup addTShirtToBasket(){
        wait.until(ExpectedConditions.visibilityOf(listViewButton));
        listViewButton.click();
        addButtonFirstTShirtOnList.click();
        return new ItemsInCartPopup(driver);
    }

    public String getTShirtName(){
        wait.until(ExpectedConditions.visibilityOf(tShirtName));
        return tShirtName.getAttribute("outerText").trim();
    }

}
