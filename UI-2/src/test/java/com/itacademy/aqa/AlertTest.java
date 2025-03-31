package com.itacademy.aqa;

import com.itacademy.aqa.onliner.webDriver.Browser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    String baseUrl= "https://www.quackit.com/html/html_editors/scratchpad/?example=/javascript/javascript_alert_box_onclick";
    @BeforeMethod
    public void inialize() {

    }

    @Test
    public void alertTest() throws InterruptedException {
        Browser.getWebDriver().get(baseUrl);

        WebElement frameElement = Browser.getWebDriver().findElement(By.xpath("//iframe[@sandbox][@srcdoc]"));

        Browser.getWebDriver().switchTo().frame(frameElement);

        Browser.getWebDriver().findElement(By.xpath("//input[@value='Click me']")).click();

        Alert alert = Browser.getWebDriver().switchTo().alert();
        Thread.sleep(10_000);
        System.out.println(alert.getText());
        alert.accept();


        Browser.getWebDriver().switchTo().defaultContent();

    }

    @Test
    public void alertTest2() throws InterruptedException {
        Browser.getWebDriver().get(baseUrl);

        WebElement frameElement = Browser.getWebDriver().findElement(By.xpath("//iframe[@sandbox][@srcdoc]"));

        Browser.getWebDriver().switchTo().frame(frameElement);

        WebElement button = Browser.getWebDriver().findElement(By.xpath("//input[@value='Click me']"));

        Browser.getJavascriptExecutor().executeScript("arguments[0].click();",button);

        Alert alert = Browser.getWebDriver().switchTo().alert();
        Thread.sleep(10_000);
        System.out.println(alert.getText());
        alert.accept();


        Browser.getWebDriver().switchTo().defaultContent();

    }


    @Test
    public void scroll() throws InterruptedException {
        Browser.getWebDriver().get("https://www.quackit.com/javascript/javascript_alert_box.cfm");

        Browser.getJavascriptExecutor().executeScript("window.scrollBy(0,600)");

        Thread.sleep(10_000);


    }


    @AfterMethod
    public void tearDown() {
        Browser.close();
    }
}
