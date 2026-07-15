package com.peter.base;

import com.peter.driver.DriverFactory;
import com.peter.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        DriverFactory.initDriver();

        driver = DriverFactory.getDriver();

        driver.get(ConfigReader.get("baseUrl"));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverFactory.quitDriver();

    }

}