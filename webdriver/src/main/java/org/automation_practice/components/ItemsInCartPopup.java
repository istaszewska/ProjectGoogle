package org.automation_practice.components;

import org.automation_practice.AbstractPage;
import org.automation_practice.pageobjects.ShoppingCartSummaryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemsInCartPopup extends AbstractPage {

    @FindBy(css = ".layer_cart_product>h2")
    private WebElement productAddedToCartMessage;
    @FindBy(id = "layer_cart_product_quantity")
    private WebElement productQuantity;
    @FindBy(id = "layer_cart_product_price")
    private WebElement cartTotalProductPrice;
    @FindBy(className = "continue")
    private WebElement continueShoppingBtn;
    @FindBy(xpath = "//a[@title = 'Proceed to checkout']")
    private WebElement proceedToCheckoutBtn;


    public ItemsInCartPopup(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationMessageText() {
        wait.until(ExpectedConditions.visibilityOf(productAddedToCartMessage));
        return productAddedToCartMessage.getText();
    }

    public int getProductQuantity() {
        wait.until(ExpectedConditions.visibilityOf(productQuantity));
        return Integer.parseInt(productQuantity.getText());
    }

    public double getCartTotalProductPrice() {
        wait.until(ExpectedConditions.visibilityOf(cartTotalProductPrice));
        String total = cartTotalProductPrice.getAttribute("outerText").replace("$", "").trim();
        return Double.parseDouble(total);
    }

    public void clickContinueShopping() {
        wait.until(ExpectedConditions.visibilityOf(continueShoppingBtn)).click();
    }

    public ShoppingCartSummaryPage proceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutBtn)).click();
        return new ShoppingCartSummaryPage(driver);
    }

}
