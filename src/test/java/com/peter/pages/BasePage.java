package com.peter.pages;

import com.peter.utils.ConfigReader;
import com.peter.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WaitUtils waitUtils;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        this.waitUtils = new WaitUtils(
                driver,
                ConfigReader.getInt("explicitWait")
        );

    }

    protected WebElement find(By locator) {
        return waitUtils.waitForVisibility(locator);
    }

    protected void click(By locator) {
        waitUtils.waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {

        WebElement element = find(locator);

        element.clear();

        element.sendKeys(text);

    }

    protected String getText(By locator) {
        return find(locator).getText();
    }

    protected boolean isDisplayed(By locator) {

        try {

            return find(locator).isDisplayed();

        } catch (Exception e) {

            return false;

        }

    }

}