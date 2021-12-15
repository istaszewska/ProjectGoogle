package org.automation_practice.pageobjects;

import org.automation_practice.AbstractPage;
import org.automation_practice.components.LoginForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartSummaryPage extends AbstractPage {

    @FindBy(id = "total_shipping")
    private WebElement shippingPrice;
    @FindBy(id = "total_tax")
    private WebElement taxValue;
    @FindBy(id = "total_price")
    private WebElement totalCosts;
    @FindBy(className = "standard-checkout")
    private WebElement proceedToCheckoutBtn;
    @FindBy(xpath = "//button[@name='processAddress']")
    private WebElement proceedToShippingBtn;
    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    private WebElement confirmOrderBtn;
    @FindBy(className = "checker")
    private WebElement termsOfServiceCheckbox;
    @FindBy(className = "bankwire")
    private WebElement bakWirePaymentBtn;
    @FindBy(css = ".cheque-indent>strong")
    private WebElement orderConfirmationText;
    @FindBy(className = "page-subheading")
    private WebElement bankPaymentHeader;
    @FindBy(className = "cheque")
    private WebElement paymentByCheckBtn;
    @FindBy(className = "alert-success")
    private WebElement orderConfirmationAlert;


    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
    }

    public LoginForm loginForm() {
        return new LoginForm(driver);
    }

    public double getShippingPrice() {
        wait.until(ExpectedConditions.visibilityOf(shippingPrice));
        String shippingCost = shippingPrice.getAttribute("outerText").replace("$", "").trim();
        return Double.parseDouble(shippingCost);
    }

    public double getTaxValue() {
        wait.until(ExpectedConditions.visibilityOf(taxValue));
        String tax = taxValue.getAttribute("outerText").replace("$", "").trim();
        return Double.parseDouble(tax);
    }

    public double getTotalCosts() {
        wait.until(ExpectedConditions.visibilityOf(totalCosts));
        String costs = totalCosts.getAttribute("outerText").replace("$", "").trim();
        return Double.parseDouble(costs);
    }

    public ShoppingCartSummaryPage clickProceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutBtn)).click();
        return this;
    }

    public ShoppingCartSummaryPage markTermsOfServiceCheckbox() {
        wait.until(ExpectedConditions.visibilityOf(termsOfServiceCheckbox)).click();
        // wait.until(ExpectedConditions.elementToBeSelected(termsOfServiceCheckbox));
        return this;
    }

    public ShoppingCartSummaryPage clickPayByBankWire() {
        wait.until(ExpectedConditions.visibilityOf(bakWirePaymentBtn)).click();
        return this;
    }

    public ShoppingCartSummaryPage clickPayByCheck() {
        wait.until(ExpectedConditions.visibilityOf(paymentByCheckBtn)).click();
        return this;
    }

    public ShoppingCartSummaryPage confirmOrder() {
        wait.until(ExpectedConditions.visibilityOf(confirmOrderBtn)).click();
        return this;
    }

    public String getOrderConfirmationText() {
        wait.until(ExpectedConditions.visibilityOf(orderConfirmationText));
        return orderConfirmationText.getAttribute("outerText").trim();
    }

    public String getPaymentHeaderText() {
        wait.until(ExpectedConditions.visibilityOf(bankPaymentHeader));
        return bankPaymentHeader.getAttribute("outerText").trim();
    }

    public String getOrderConfirmationAlertText() {
        wait.until(ExpectedConditions.visibilityOf(orderConfirmationAlert));
        return orderConfirmationAlert.getAttribute("outerText").trim();
    }

    public ShoppingCartSummaryPage proceedToShipping() {
        wait.until(ExpectedConditions.visibilityOf(proceedToShippingBtn)).click();
        return this;
    }

}
