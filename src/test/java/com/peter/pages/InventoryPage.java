package com.peter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private final By lblTitle = By.cssSelector(".title");

    private final By btnCart = By.id("shopping_cart_container");

    private final By menuButton = By.id("react-burger-menu-btn");

    private final By logoutButton = By.id("logout_sidebar_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return getText(lblTitle).equals("Products");
    }

    public InventoryPage addProduct(String productName) {

        String id = "add-to-cart-" + normalizeProductName(productName);

        click(By.id(id));

        return this;
    }

    public CartPage goToCart() {

        click(btnCart);

        return new CartPage(driver);
    }

    public LoginPage logout() {

        click(menuButton);

        click(logoutButton);

        return new LoginPage(driver);
    }

    private String normalizeProductName(String productName) {

        return productName
                .trim()
                .toLowerCase()
                .replace(" ", "-");
    }

}