package com.itacademy.aqa;

import com.itacademy.aqa.onliner.webDriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.time.Duration;

public class ActionsTest {
    String baseUrl= "https://jqueryui.com";
    @BeforeMethod
    public void inialize() {

    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
        Browser.getWebDriver().get(baseUrl + "/draggable/#sortable");

        WebElement frame = Browser.getWebDriver().findElement(By.className("demo-frame"));

        Browser.getWebDriver().switchTo().frame(frame);

        Assert.assertEquals(Browser.getWebDriver().findElements(By.tagName("li")).size(), 6);

        WebElement source = Browser.getWebDriver().findElement(By.id("draggable"));

        WebElement target = Browser.getWebDriver().findElement(By.xpath("//li[text()='Item 3']"));

        Actions actions = new Actions(Browser.getWebDriver());

        actions.clickAndHold(source).moveToElement(target).release().perform();

        Thread.sleep(5000);

        Browser.getWebDriver().switchTo().defaultContent();

    }

    @Test
    public void dropableTest() throws InterruptedException {
        Browser.getWebDriver().get(baseUrl + "/droppable/");

        WebElement frame = Browser.getWebDriver().findElement(By.className("demo-frame"));

        Browser.getWebDriver().switchTo().frame(frame);


        WebElement source = Browser.getWebDriver().findElement(By.id("draggable"));

        WebElement target = Browser.getWebDriver().findElement(By.id("droppable"));

        new Actions(Browser.getWebDriver())
                .clickAndHold(source)
                .moveToElement(target)
                .release()
                .perform();

        Thread.sleep(5000);
        System.out.println(target.getCssValue("background-color"));
        Assert.assertTrue(target.getCssValue("background-color").contains("255, 250, 144"));

        Browser.getWebDriver().switchTo().defaultContent();

    }


    @AfterMethod
    public void tearDown() {
        Browser.close();
    }
}
