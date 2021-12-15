package org.automation_practice.tests;

import org.automation_practice.pageobjects.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PaymentMethods_LoggedOutUserTest extends AbstractTest {

    @AfterEach
    void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    String user = testData.getUsersData().get(0).getEmail();
    String password = testData.getUsersData().get(0).getPassword();

    @Test
    public void shouldPayByBankWire() {
        HomePage homePage = new HomePage(driver);
        double tShirtPrice = homePage.topMenu().navigateToTShirtsPage().getTShirtPrice();
        double shippingPrice = homePage.tShirtsPage().addTShirtToBasket().proceedToCheckout().getShippingPrice();
        double taxValue = homePage.shoppingCartSummaryPage().getTaxValue();
        double expectedTotalCosts = tShirtPrice + shippingPrice + taxValue;
        double totalCosts = homePage.shoppingCartSummaryPage().getTotalCosts();

        Assertions.assertTrue(compareFloatNum(expectedTotalCosts, totalCosts));

        String paymentHeaderText = homePage.shoppingCartSummaryPage().clickProceedToCheckout().loginForm()
                .fillAndSendLoginForm(user, password)
                .shoppingCartSummaryPage()
                .proceedToShipping()
                .markTermsOfServiceCheckbox()
                .clickProceedToCheckout()
                .clickPayByBankWire().getPaymentHeaderText();
        Assertions.assertEquals("BANK-WIRE PAYMENT.", paymentHeaderText);

        String orderConfirmationText = homePage.shoppingCartSummaryPage().confirmOrder()
                .getOrderConfirmationText();
        Assertions.assertEquals("Your order on My Store is complete.", orderConfirmationText);
    }

    @Test
    public void shouldPayByCheck() {
        HomePage homePage = new HomePage(driver);
        double tShirtPrice = homePage.topMenu().navigateToTShirtsPage().getTShirtPrice();
        double shippingPrice = homePage.tShirtsPage().addTShirtToBasket().proceedToCheckout().getShippingPrice();
        double taxValue = homePage.shoppingCartSummaryPage().getTaxValue();
        double expectedTotalCosts = tShirtPrice + shippingPrice + taxValue;
        double totalCosts = homePage.shoppingCartSummaryPage().getTotalCosts();

        Assertions.assertTrue(compareFloatNum(expectedTotalCosts, totalCosts));

        String paymentHeaderText = homePage.shoppingCartSummaryPage().clickProceedToCheckout().loginForm()
                .fillAndSendLoginForm(user, password)
                .shoppingCartSummaryPage()
                .proceedToShipping()
                .markTermsOfServiceCheckbox()
                .clickProceedToCheckout()
                .clickPayByCheck().getPaymentHeaderText();
        Assertions.assertEquals("CHECK PAYMENT", paymentHeaderText);

        String orderConfirmationText = homePage.shoppingCartSummaryPage().confirmOrder()
                .getOrderConfirmationAlertText();
        Assertions.assertEquals("Your order on My Store is complete.", orderConfirmationText);
    }

}
