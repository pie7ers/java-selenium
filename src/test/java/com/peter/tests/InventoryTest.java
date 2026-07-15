package com.peter.tests;

import com.peter.base.BaseTest;
import com.peter.data.TestData;
import com.peter.pages.CartPage;
import com.peter.pages.InventoryPage;
import com.peter.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

    @Test
    public void shouldAddProductsToCart() {

        InventoryPage inventory =
                new LoginPage(driver)
                        .login(
                                TestData.STANDARD_USER,
                                TestData.PASSWORD
                        );

        CartPage cart =
                inventory
                        .addProduct("Sauce Labs Backpack")
                        .addProduct("Sauce Labs Bike Light")
                        .goToCart();

        Assert.assertTrue(cart.isLoaded());

    }

}