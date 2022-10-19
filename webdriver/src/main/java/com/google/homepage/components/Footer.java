package com.google.homepage.components;

import lombok.Getter;
import com.google.homepage.AbstractPage;
import com.google.homepage.pageobjects.AboutUs.AboutUsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class Footer extends AbstractPage {

    public Footer(WebDriver driver) {
        super(driver);
    }

    public AboutUsPage aboutUsPage() {
        return new AboutUsPage(driver);
    }

    public Footer navigateToPageFromFooter(String pageName) {
        waitForButtonAndClick(findFooterButtonByName(pageName));
        return this;
    }

    private WebElement findFooterButtonByName(String buttonName) {
        return driver.findElement(By.xpath(String.format("//div//a[contains(text(),'%s')]", buttonName)));
    }


}
