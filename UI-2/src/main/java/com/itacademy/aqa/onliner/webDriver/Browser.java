package com.itacademy.aqa.onliner.webDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Browser {

    public static final int TIME_OUT_IN_SECONDS = 30;
    public static final long DEFAULT_TIMEOUT = 15L;

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

        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(TIME_OUT_IN_SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = getWebDriver().findElement(locator);
        return element;
    }

    public static WebElement waitForElementToBeVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(TIME_OUT_IN_SECONDS));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement element = getWebDriver().findElement(locator);
            return element;
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    public static void takeScreenShot() {
        File screenShotsFolder = new File(Configuration.getScreenShotFolder());

        if (!screenShotsFolder.exists()) {
            screenShotsFolder.mkdirs();
        }
        TakesScreenshot ts = (TakesScreenshot) Browser.getWebDriver();

        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss-SS--a");

        String formattedDate = simpleDateFormat.format(date);

        String fileName = Configuration.getBrowserEnum() + formattedDate + ".png";

        try {
            Files.write(new File(screenShotsFolder.getPath() + "/" + fileName).toPath(),
                    screenshot, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static JavascriptExecutor getJavascriptExecutor(){
        return (JavascriptExecutor) getWebDriver();
    }

    public static void close() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
