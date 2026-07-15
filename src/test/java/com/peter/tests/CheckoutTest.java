package com.peter.tests;

import com.peter.base.BaseTest;
import com.peter.data.TestData;
import com.peter.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void shouldCompleteCheckoutSuccessfully() {

        InventoryPage inventory =
                new LoginPage(driver)
                        .login(
                                TestData.STANDARD_USER,
                                TestData.PASSWORD
                        );

        CheckoutCompletePage complete =
                inventory

                        .addProduct("Sauce Labs Backpack")

                        .goToCart()

                        .checkout()

                        .continueCheckout(
                                "Peter",
                                "Crouch",
                                "110111"
                        )

                        .finish();

        Assert.assertTrue(
                complete.isOrderCompleted()
        );

    }

}