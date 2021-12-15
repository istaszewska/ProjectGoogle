package org.automation_practice.components;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

@RequiredArgsConstructor
public enum Gender {

    MALE(By.cssSelector("label[for=id_gender1]")),
    FEMALE(By.cssSelector("label[for=id_gender2]"));

    @Getter
    private final By registerFormLocator;

}
