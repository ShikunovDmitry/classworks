package com.itacademy.aqa.onliner.webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Browser {

    public static final int TIME_OUT_IN_SECONDS = 30;
    public static final long DEFAULT_TIMEOUT = 10L;

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
        webDriver = BrowserFactory.createDriver(Configuration.getBrowserEnum());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    public static WebElement waitForElementToBeClickable(By locator) {

        WebDriverWait wait = new WebDriverWait(getWebDriver(), TIME_OUT_IN_SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = getWebDriver().findElement(locator);
        return element;
    }

    public static WebElement waitForElementToBeVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getWebDriver(), TIME_OUT_IN_SECONDS);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement element = getWebDriver().findElement(locator);
            return element;
        } catch (NotFoundException ex){
            System.out.println(ex.getMessage());
            return null;
        }

    }

    public static void close() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
