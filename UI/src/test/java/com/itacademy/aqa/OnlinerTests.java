package com.itacademy.aqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OnlinerTests {
    WebDriver webDriver;

    By topMainMenuLocator = By.className("b-main-navigation");
    By topMenuAvtoLocator = By.xpath("//nav//*[contains(text(),'Автобарахолка')]");
    By avtoPageLocator = By.className("vehicle-form__offers");

    static {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
    }

    @BeforeMethod
    public void initialize() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10L, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(10L, TimeUnit.SECONDS);
        webDriver.get("https://www.onliner.by/");
        Thread.sleep(1000);


    }

    @Test
    public void onlinerCanBeOpenedTest(){
        WebElement topMenu = webDriver.findElement(topMainMenuLocator);

        Assert.assertTrue(topMenu.isDisplayed(), "Top menu is not displayed");

    }

    @Test
    public void avtoCanBeOpened(){
        WebDriverWait wait  = new WebDriverWait(webDriver,30);
        wait.until(ExpectedConditions.elementToBeClickable(topMenuAvtoLocator));

        WebElement avtoMenu = webDriver.findElement(topMenuAvtoLocator);

        avtoMenu.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(avtoPageLocator));
        WebElement avtoPageElement = webDriver.findElement(avtoPageLocator);
        Assert.assertTrue(avtoPageElement.isDisplayed(), "Автобарахолка страница не открыта");

    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
