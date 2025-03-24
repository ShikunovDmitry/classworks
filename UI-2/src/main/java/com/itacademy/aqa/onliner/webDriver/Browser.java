package com.itacademy.aqa.onliner.webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Browser {

    static {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
    }

    private static WebDriver webDriver;

    private Browser() {
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            initDriver();
        }
        return webDriver;
    }

    public static void initDriver() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10L, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(10L, TimeUnit.SECONDS);
    }

    public static WebElement waitForElementToBeClickable(By locator) {

        WebDriverWait wait = new WebDriverWait(getWebDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = getWebDriver().findElement(locator);
        return element;
    }

    public static WebElement waitForElementToBeVisible(By locator) {

        WebDriverWait wait = new WebDriverWait(getWebDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = getWebDriver().findElement(locator);
        return element;
    }

    public static void close() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
