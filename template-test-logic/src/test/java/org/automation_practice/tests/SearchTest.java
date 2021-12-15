package org.automation_practice.tests;

import com.github.javafaker.Faker;
import org.automation_practice.model.User;
import org.automation_practice.pageobjects.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SearchTest extends AbstractTest {

    Faker f = new Faker();
    User user = testData.getUsersData().get(0);
    String fakeItem = f.gameOfThrones().character();
    String expectedErrorMessage = "No results were found for your search \"" + fakeItem + "\"";

    @BeforeEach
    public void logIn() {
        addSessionCookieToBrowserOf(user);
    }

    @Test
    public void isSearchErrorDisplayed() {
        HomePage homePage = new HomePage(driver);
        String searchErrorText = homePage.topMenu()
                .searchItem(fakeItem).getSearchErrorText();
        Assertions.assertEquals(expectedErrorMessage, searchErrorText);
    }

    @ParameterizedTest
    @MethodSource("searchItems")
    public void ifListedProductsNamesContainsSearchedItem(String product) {
        HomePage homePage = new HomePage(driver);
        List<String> listOfSearchProductsNames = homePage.topMenu()
                .searchItem(product)
                .waitForSearchCounter()
                .getListOfSearchProductsNames(product);
        Assertions.assertTrue(listOfSearchProductsNames.stream().allMatch(str -> str.trim().toLowerCase().contains(product)));
    }

    private static Stream<Arguments> searchItems() {
        return Stream.of(
                Arguments.of("blouse"),
                Arguments.of("dress")
        );
    }
}
