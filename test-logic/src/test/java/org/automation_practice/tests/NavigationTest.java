package org.automation_practice.tests;

import org.automation_practice.pageobjects.AboutUs.AboutUsHeaders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class NavigationTest extends AbstractTest {

    @Test
    public void shouldNavigateToAboutUsPage() {
        List<String> headersNames = homePage.acceptCookies()
                .footer()
                .navigateToPageFromFooter("O nas")
                .aboutUsPage()
                .getHeadersNames();

        Assertions.assertTrue(headersNames.containsAll(AboutUsHeaders.exceptedHeaders()));
    }

    @Test
    public void shouldNavigateToGoogleDoodles() {
        String currentUrl = homePage.acceptCookies()
                .navigateToLuckyStrike()
                .getCurrentUrl();

        Assertions.assertEquals("https://www.google.com/doodles/", currentUrl);
    }

}