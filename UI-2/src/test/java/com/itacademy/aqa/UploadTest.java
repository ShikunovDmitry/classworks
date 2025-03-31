package com.itacademy.aqa;

import com.itacademy.aqa.onliner.webDriver.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;

public class UploadTest {

    @BeforeMethod
    public void inialize() {

    }

    @Test
    public void uploadTest() {

        Path path = Path.of("screenshot.png");

        String absolutePath = path.toAbsolutePath().toString();

        Browser.getWebDriver().get("https://image.online-convert.com/convert-to-bmp");

        WebDriverWait wait = new WebDriverWait(Browser.getWebDriver(), 10);
        wait.until(webDriver -> webDriver.findElement(By.id("fileUploadInput")));
        WebElement uploadInput = Browser.getWebDriver().findElement(By.id("fileUploadInput"));
        uploadInput.sendKeys(absolutePath);

        WebDriverWait fileUploadWait = new WebDriverWait(Browser.getWebDriver(), 10);
        fileUploadWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[contains(text(),'screenshot.png')]")));

        Browser.getWebDriver().findElement(By.xpath("//button[contains(@class,'submit-btn')]")).click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(Browser.getWebDriver());
        fluentWait.pollingEvery(Duration.ofSeconds(2));
        fluentWait.withTimeout(Duration.ofSeconds(30));
        fluentWait.ignoring(NotFoundException.class);
        fluentWait.until(webDriver ->
                webDriver.findElements(By.xpath("//a[contains(text(),'screenshot.bmp')]")).size()>0);
        Browser.takeScreenShot();

    }


    @AfterMethod
    public void tearDown() {
        Browser.close();
    }
}
