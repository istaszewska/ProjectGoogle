package org.automation_practice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.automation_practice.AbstractPage;
import org.automation_practice.components.LoginForm;
import org.automation_practice.components.RegisterForm;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginForm loginForm() {
        return new LoginForm(driver);
    }

    public RegisterForm registerForm() {
        return new RegisterForm(driver);
    }

}
