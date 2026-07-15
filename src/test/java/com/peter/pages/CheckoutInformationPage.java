package com.peter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage extends BasePage {

    private final By txtFirstName = By.id("first-name");
    private final By txtLastName = By.id("last-name");
    private final By txtPostalCode = By.id("postal-code");
    private final By btnContinue = By.id("continue");

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutOverviewPage continueCheckout(
            String firstName,
            String lastName,
            String postalCode) {

        type(txtFirstName, firstName);
        type(txtLastName, lastName);
        type(txtPostalCode, postalCode);

        click(btnContinue);

        return new CheckoutOverviewPage(driver);
    }

}