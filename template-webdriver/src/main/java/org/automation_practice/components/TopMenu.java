package org.automation_practice.components;

import org.automation_practice.AbstractPage;
import org.automation_practice.pageobjects.CasualDressesPage;
import org.automation_practice.pageobjects.SearchPage;
import org.automation_practice.pageobjects.TShirtsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenu extends AbstractPage {

    @FindBy(id = "search_query_top")
    private WebElement searchInputBox;
    @FindBy(name = "submit_search")
    private WebElement submitSearchButton;
    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womanMenuOption;
    @FindBy(xpath = "//ul[contains(@class,'submenu-container')]//a[@title='T-shirts']")
    private WebElement tShirtsSubMenuOption;
    @FindBy(css = ".shopping_cart>a")
    private WebElement cartWidget;
    @FindBy(className = "cart_block_total")
    private WebElement cartTotal;
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
    private WebElement dressesMenuOption;
    @FindBy(xpath = "//ul[contains(@class,'submenu-container')]/li/a[@title='Casual Dresses']")
    private WebElement casualDressesBtn;
    @FindBy(className = "cart_block_list")
    private WebElement cartItemListBox;
    @FindBy(className = "cart_block_shipping_cost")
    private WebElement shippingCosts;


    public TopMenu(WebDriver driver) {
        super(driver);
    }

    public SearchPage searchItem(String item) {
        searchInputBox.sendKeys(item);
        submitSearchButton.click();
        return new SearchPage(driver);
    }

    public TShirtsPage navigateToTShirtsPage() {
        hooverOverWebElement(womanMenuOption);
        wait.until(ExpectedConditions.visibilityOf(tShirtsSubMenuOption)).click();
        return new TShirtsPage(driver);
    }

    public double getCartTotal() {
        wait.until(ExpectedConditions.visibilityOf(cartWidget));
        hooverOverWebElement(cartWidget);
        String total = cartTotal.getAttribute("outerText").replace("$", "").trim();
        return Double.parseDouble(total);
    }

    public double getShippingCosts() {
        wait.until(ExpectedConditions.visibilityOf(cartWidget));
        hooverOverWebElement(cartWidget);
        String shippingCost = shippingCosts.getAttribute("outerText").replace("$", "").trim();
        return Double.parseDouble(shippingCost);
    }

    public boolean checkIfItemExistInTheCart(String itemName) {
        hooverOverWebElement(cartWidget);
        wait.until(ExpectedConditions.visibilityOf(cartItemListBox));
        String CART_ITEM_XPATH = "//a[@title='%s' and @class='cart_block_product_name']";
        return driver.findElement(By.xpath(String.format(CART_ITEM_XPATH, itemName))).isDisplayed();
    }

    public CasualDressesPage navigateToCasualDressesPage() {
        hooverOverWebElement(dressesMenuOption);
        casualDressesBtn.click();
        return new CasualDressesPage(driver);
    }


}
