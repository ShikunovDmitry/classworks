package com.itacademy.aqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OnlinerTests {
    WebDriver webDriver;

    By topMainMenuLocator = By.className("b-main-navigation");

    static {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
    }

    @BeforeMethod
    public void initialize() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.onliner.by/");
        webDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

    }

    @Test
    public void onlinerCanBeOpenedTest(){
        WebElement topMenu = webDriver.findElement(topMainMenuLocator);

        Assert.assertTrue(topMenu.isDisplayed(), "Top menu is not displayed");

    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
