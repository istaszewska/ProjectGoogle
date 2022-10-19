package com.google.homepage.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends AbstractTest {

    String searchPhrase = "apple";
    String randomText = RandomStringUtils.random(30, true, true);

    @Test
    public void validateSearchResults() {
        List<String> listOfResults = homePage.acceptCookies()
                .typeInSearchField(searchPhrase)
                .clickSearchButton()
                .getSearchResults();

        listOfResults.forEach(result -> assertThat(result.toLowerCase()).contains(searchPhrase.toLowerCase()));
    }

    @Test
    public void validateInvalidSearch() {
        homePage.acceptCookies()
                .typeInSearchField(randomText)
                .getElementAndPressKey(homePage.getSearchInputBox(), Keys.ENTER);

        String expectedErrorMessage = "Podana fraza - " + randomText + " - nie została odnaleziona.";
        String actualErrorMessage = homePage.getErrorMessage();

        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @ParameterizedTest
    @MethodSource("calculationData")
    public void validateSearchCalculations(String calculation, String expectedResult){
        homePage.acceptCookies()
                .typeInSearchField(calculation)
                .getElementAndPressKey(homePage.getSearchInputBox(), Keys.ENTER);

        String calculationResult = homePage.getCalculationResult().getText();

        Assertions.assertEquals(expectedResult, calculationResult);
    }

    private static Stream<Arguments> calculationData() {
        return Stream.of(
                Arguments.of("2 + 2" , "4"),
                Arguments.of("-1 * 1", "-1"),
                Arguments.of("-1 / -1", "1"),
                Arguments.of("0,1 - 0,1", "0")
        );
    }
}
