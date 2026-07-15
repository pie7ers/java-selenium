package com.peter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final By lblComplete = By.className("complete-header");
    private final By btnBackHome = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOrderCompleted() {

        return "Thank you for your order!"
                .equals(getText(lblComplete));

    }

    public InventoryPage backHome() {

        click(btnBackHome);

        return new InventoryPage(driver);

    }

}