package com.google.homepage.tests;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends AbstractTest {

    String searchPhrase = "apple";

    @Test
    public void validateSearchResults() {
        List<String> listOfResults = homePage.acceptCookies()
                .typeIntoUserNameField(searchPhrase)
                .clickSearchButton()
                .getSearchResults();

        listOfResults.forEach(result -> assertThat(result.toLowerCase()).contains(searchPhrase.toLowerCase()));
    }

    @Test
    public void validateRemoteKeyboard(){

    }

}
