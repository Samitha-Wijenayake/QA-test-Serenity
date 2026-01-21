package pages;

import net.bytebuddy.implementation.bind.annotation.Default;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;



public class LoginPage extends PageObject {

    @FindBy(name = "username")
    WebElementFacade usernameField;

    @FindBy(name = "password")
    WebElementFacade passwordField;

    @FindBy(css = "button[type='submit']")
    WebElementFacade loginButton;

    @FindBy(css = "div.alert.alert-danger.text-center")
    WebElementFacade errorMessage;

    public void enterUsername(String username) {
        usernameField.waitUntilVisible().type(username);
    }

    public void enterPassword(String password) {
        passwordField.waitUntilVisible().type(password);
    }

    public void clickLogin() {
        loginButton.waitUntilClickable().click();
    }

    public boolean isDashboardDisplayed() {
        System.out.println("Current URL: " + getDriver().getCurrentUrl());
        return getDriver().getCurrentUrl().contains("dashboard");
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
