package org.automation_practice.components;

import org.automation_practice.AbstractPage;
import org.automation_practice.pageobjects.HomePage;
import org.automation_practice.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement singInButton;

    @FindBy(className = "logout")
    private WebElement signOutButton;

    public Header(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLogInPage() {
        singInButton.click();
        return new LoginPage(driver);
    }

    public HomePage logOut(){
        signOutButton.click();
        return new HomePage(driver);
    }

    public boolean isSignOutIsDisplayed(){
        return signOutButton.isDisplayed();
    }

    public boolean isSignInIsDisplayed(){
        return singInButton.isDisplayed();}


}
