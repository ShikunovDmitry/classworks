package com.itacademy.aqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
    WebDriver webDriver;
    By searchFieldLocator = By.name("q");

    static {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
    }

    @BeforeMethod
    public void initialize() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://www.google.com");
    }


    @Test
    public void googlePageCanBeOpenedTest() throws InterruptedException {
        WebElement searchFieldWebElement = webDriver.findElement(searchFieldLocator);
        System.out.println("ID = " + searchFieldWebElement.getAttribute("id"));
        System.out.println("background-color = " + searchFieldWebElement.getCssValue("background-color"));

        Assert.assertTrue(searchFieldWebElement.isDisplayed(),
                "Cant find search field by " + searchFieldLocator);
    }

    @Test
    public void searchCanBePerformedTest() {
        WebElement searchFieldWebElement = webDriver.findElement(searchFieldLocator);
        searchFieldWebElement.clear();
        searchFieldWebElement.sendKeys("Selenium");
        searchFieldWebElement.submit();
        searchFieldWebElement = webDriver.findElement(searchFieldLocator);
        Assert.assertFalse(searchFieldWebElement.isDisplayed(), " Search is still visible");

    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
