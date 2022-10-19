package com.google.homepage.pageobjects.AboutUs;

import com.google.homepage.AbstractPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class AboutUsPage extends AbstractPage {

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get all headers' names")
    public List<String> getHeadersNames() {
        return driver.findElements(By.xpath("//a[@role='menuitem']"))
                .stream().map(element -> element.getText().toLowerCase().trim()).collect(Collectors.toList());
    }

}
