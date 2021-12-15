package org.automation_practice.tests;

import org.automation_practice.pageobjects.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddItemsToBasketTest extends AbstractTest {

    @AfterEach
    void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void shouldConfirmThatItemWasAddedToBasket() {
        HomePage homePage = new HomePage(driver);
        String confirmationMessageText = homePage.topMenu()
                .navigateToTShirtsPage().addTShirtToBasket().getConfirmationMessageText().trim();

        Assertions.assertEquals("Product successfully added to your shopping cart", confirmationMessageText);
    }

    @Test
    public void shouldCumulateItemsInCartPopup() {
        HomePage homePage = new HomePage(driver);
        for (int i = 1; i < 4; i++) {
            int productQuantity = homePage.topMenu().navigateToTShirtsPage().addTShirtToBasket().getProductQuantity();
            homePage.itemsInCartPopup().clickContinueShopping();
            Assertions.assertEquals(i, productQuantity);

        }
    }

    @Test
    public void shouldCumulateTotalPriceInCartPopup() {
        HomePage homePage = new HomePage(driver);
        for (int i = 1; i < 4; i++) {
            double tShirtPrice = homePage.topMenu().navigateToTShirtsPage().getTShirtPrice();
            double cartTotalProductPrice = homePage.tShirtsPage().addTShirtToBasket().getCartTotalProductPrice();
            Assertions.assertEquals(tShirtPrice * i, cartTotalProductPrice);

            homePage.itemsInCartPopup().clickContinueShopping();
        }
    }

    @Test
    public void shouldAddTwoDifferentItemsToCart() {
        HomePage homePage = new HomePage(driver);
        String dressName = homePage.topMenu().navigateToCasualDressesPage().getDressName();
        homePage.casualDressesPage().addDressToTheBasket().clickContinueShopping();

        String tShirtName = homePage.topMenu().navigateToTShirtsPage().getTShirtName();
        homePage.tShirtsPage().addTShirtToBasket().clickContinueShopping();

        Assertions.assertTrue(homePage.topMenu().checkIfItemExistInTheCart(dressName));
        Assertions.assertTrue(homePage.topMenu().checkIfItemExistInTheCart(tShirtName));
    }

    @Test
    public void shouldSumProductAndShippingCosts() {
        HomePage homePage = new HomePage(driver);
        double dressPrice = homePage.topMenu().navigateToCasualDressesPage().getDressPrice();
        homePage.casualDressesPage().addDressToTheBasket().clickContinueShopping();

        double tShirtPrice = homePage.topMenu().navigateToTShirtsPage().getTShirtPrice();
        homePage.tShirtsPage().addTShirtToBasket().clickContinueShopping();

        double shippingCost = homePage.topMenu().getShippingCosts();
        double expectedTotalCosts = dressPrice + tShirtPrice + shippingCost;
        double totalCosts = homePage.topMenu().getCartTotal();

        Assertions.assertTrue(compareFloatNum(expectedTotalCosts,totalCosts));
    }


}