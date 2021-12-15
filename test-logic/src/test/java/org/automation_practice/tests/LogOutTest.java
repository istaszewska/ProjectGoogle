package org.automation_practice.tests;

import org.automation_practice.model.User;
import org.automation_practice.pageobjects.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogOutTest extends AbstractTest {

    User user = testData.getUsersData().get(0);

    @BeforeEach
    public void logIn() {
        addSessionCookieToBrowserOf(user);
    }

    @Test
    public void shouldLogOut() {
        HomePage homePage = new HomePage(driver);
        homePage.header().logOut();
        Assertions.assertTrue(homePage.header().isSignInIsDisplayed());
    }
}
