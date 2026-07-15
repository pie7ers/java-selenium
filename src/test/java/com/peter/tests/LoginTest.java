package com.peter.tests;

import com.peter.base.BaseTest;
import com.peter.data.TestData;
import com.peter.pages.InventoryPage;
import com.peter.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.peter.constants.Messages;

public class LoginTest extends BaseTest {

    @Test
    public void shouldLoginSuccessfully() {

        LoginPage loginPage = new LoginPage(driver);

        InventoryPage inventoryPage =
                loginPage.login(
                        TestData.STANDARD_USER,
                        TestData.PASSWORD
                );

        Assert.assertTrue(
                inventoryPage.isLoaded()
        );

    }

    @Test
    public void shouldNotLoginWithInvalidPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginWithInvalidCredentials(
                "standard_user",
                "123456"
        );

        Assert.assertTrue(
                loginPage.isErrorDisplayed()
        );

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                Messages.LOGIN_ERROR
        );

    }

}