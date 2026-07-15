package com.peter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By lblTitle = By.cssSelector(".title");
    private final By btnCheckout = By.id("checkout");
    private final By btnContinueShopping = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return "Your Cart".equals(getText(lblTitle));
    }

    public CheckoutInformationPage checkout() {

        click(btnCheckout);

        return new CheckoutInformationPage(driver);
    }

    public InventoryPage continueShopping() {

        click(btnContinueShopping);

        return new InventoryPage(driver);
    }

    public CartPage removeProduct(String productName) {

        String id = "remove-" + normalize(productName);

        click(By.id(id));

        return this;
    }

    private String normalize(String productName) {

        return productName
                .trim()
                .toLowerCase()
                .replace(" ", "-");

    }

}