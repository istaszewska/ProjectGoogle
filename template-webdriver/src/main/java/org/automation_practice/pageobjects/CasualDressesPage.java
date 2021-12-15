package org.automation_practice.pageobjects;

import org.automation_practice.AbstractPage;
import org.automation_practice.components.ItemsInCartPopup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CasualDressesPage extends AbstractPage {

    @FindBy(xpath = "//a[@title='Add to cart' and @data-id-product='3']")
    private WebElement addBtnFirstDressOnList;
    @FindBy(xpath = "//a[@data-id-product='3']/../../div/span")
    private WebElement dressPrice;
    @FindBy(xpath = "//div[contains(@class,'center-block')]//h5/a")
    private WebElement dressName;
    @FindBy(className = "icon-th-list")
    private WebElement listViewButton;

    public CasualDressesPage(WebDriver driver) {
        super(driver);
    }


    public String getDressName(){
        listViewButton.click();
        wait.until(ExpectedConditions.visibilityOf(dressName));
        return dressName.getAttribute("outerText").trim();
    }

    public double getDressPrice(){
        wait.until(ExpectedConditions.visibilityOf(dressPrice));
        String price = dressPrice.getAttribute("outerText").replace("$","").trim();
        return Double.parseDouble(price);
    }

    public ItemsInCartPopup addDressToTheBasket(){
        wait.until(ExpectedConditions.visibilityOf(listViewButton));
        listViewButton.click();
        addBtnFirstDressOnList.click();
        return new ItemsInCartPopup(driver);
    }


}
