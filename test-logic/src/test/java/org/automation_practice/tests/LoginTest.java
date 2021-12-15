package org.automation_practice.tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.automation_practice.pageobjects.HomePage;

import java.util.stream.Stream;

public class LoginTest extends AbstractTest {

    String user = testData.getUsersData().get(0).getEmail();
    String password = testData.getUsersData().get(0).getPassword();
    HomePage homePage = new HomePage(driver);

    @Test
    public void shouldLogIn() {
        homePage.header()
                .goToLogInPage()
                .loginForm()
                .fillAndSendLoginForm(user, password);
        Assertions.assertTrue(homePage.header().isSignOutIsDisplayed());
    }

    @ParameterizedTest
    @MethodSource("loginFormData")
    public void shouldNotLoginWithIncorrectCredentials(String email, String password, String expectedErrorMessage) {
        String errorMessage = homePage.header().goToLogInPage().loginForm()
                .fillAndSendLoginForm(email, password)
                .getErrorMessage();
        Assertions.assertEquals(expectedErrorMessage, errorMessage);
    }

    private static Stream<Arguments> loginFormData() {
        return Stream.of(
                Arguments.of("ifListedProductsNamesContainsSearchedItem@softie.pl", "wrong Password", "Authentication failed."),
                Arguments.of("ifListedProductsNamesContainsSearchedItem@softie.pl", "", "Password is required."),
                Arguments.of("", "wrong Password", "An email address required."),
                Arguments.of("", "", "An email address required.")
        );
    }
}
