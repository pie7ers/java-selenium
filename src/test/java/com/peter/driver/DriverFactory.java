package com.peter.driver;

import com.peter.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;

import java.time.Duration;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {
    }

    private static ChromeOptions getChromeOptions() {

        ChromeOptions options = new ChromeOptions();

        if (ConfigReader.getBoolean("headless")) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-save-password-bubble");

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        // Disable password checkup popup
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        return options;
    }

    public static void initDriver() {

        String browser = ConfigReader.get("browser").toLowerCase();
        boolean headless = ConfigReader.getBoolean("headless");

        WebDriver webDriver;

        switch (browser) {

            case "firefox":

                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (headless) {
                    firefoxOptions.addArguments("-headless");
                }

                webDriver = new FirefoxDriver(firefoxOptions);

                break;

            case "edge":

                WebDriverManager.edgedriver().setup();

                EdgeOptions edgeOptions = new EdgeOptions();

                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                }

                webDriver = new EdgeDriver(edgeOptions);

                break;

            case "safari":

                SafariOptions safariOptions = new SafariOptions();

                webDriver = new SafariDriver(safariOptions);

                break;

            case "chrome":

            default:

                WebDriverManager.chromedriver().setup();

                // ChromeOptions chromeOptions = new ChromeOptions();
                //
                // if (headless) {
                // chromeOptions.addArguments("--headless=new");
                // }
                webDriver = new ChromeDriver(getChromeOptions());
                System.out.println("Driver class: " + webDriver.getClass());
                System.out.println("Options: " + getChromeOptions().asMap());

                break;
        }

        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(ConfigReader.getInt("implicitWait")));

        webDriver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(ConfigReader.getInt("pageLoadTimeout")));

        driver.set(webDriver);

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();

        }

    }

}