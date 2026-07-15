package com.peter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By txtUsername = By.id("user-name");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.id("login-button");
    private final By lblError = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String username) {
        type(txtUsername, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(txtPassword, password);
        return this;
    }

    public LoginPage clickLogin() {
        click(btnLogin);
        return this;
    }

    public InventoryPage login(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        click(btnLogin);

        return new InventoryPage(driver);
    }

    public LoginPage loginWithInvalidCredentials(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        click(btnLogin);

        return this;
    }

    /**
     * Devuelve el mensaje de error.
     */
    public String getErrorMessage() {
        return getText(lblError);
    }

    /**
     * Indica si existe un mensaje de error.
     */
    public boolean isErrorDisplayed() {
        return isDisplayed(lblError);
    }

}