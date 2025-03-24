package com.itacademy.aqa;

import com.itacademy.aqa.onliner.pageObject.elements.TopMenuEnum;
import com.itacademy.aqa.onliner.pageObject.pages.MainPage;
import com.itacademy.aqa.onliner.pegeFactory.pages.AvtoPage;
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

public class OnlinerPageObjectTests {
    WebDriver webDriver;

    static {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
    }

    @BeforeMethod
    public void initialize() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10L, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(10L, TimeUnit.SECONDS);
        webDriver.get("https://www.onliner.by/");
    }

    @Test
    public void onlinerCanBeOpenedTest(){

        MainPage mainPage = new MainPage(webDriver);

        Assert.assertTrue(mainPage.isPageOpened(), "Onliner main page is not opened");

    }

    @Test
    public void avtoCanBeOpened(){
        MainPage mainPage = new MainPage(webDriver);

        mainPage.getTopMenu().clickOnItem(TopMenuEnum.AUTOSALES);

        AvtoPage avtoPage = new AvtoPage(webDriver);

        Assert.assertTrue(avtoPage.isPageOpened(), "Автобарахолка page is not opened");

    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
