package com.itacademy.aqa;

import com.itacademy.aqa.onliner.pages.wordpres.LoginPage;
import com.itacademy.aqa.onliner.webDriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WordPressTest {
  public static final String URL = "https://test-automation-epc6e4eqgsgdhged.eastus2-01.azurewebsites.net";

  @BeforeMethod()
  public void login(){
    Browser.getWebDriver().get(URL + "/wp-admin");

    LoginPage loginPage = new LoginPage();
    loginPage.login("test-admin","&2agnh5MyevReS8jhoYDTtbt");
  }

  @Test
  public void addTegExample(){

    String tag = String.valueOf(System.currentTimeMillis());

    Browser.getWebDriver().get(URL + "/wp-admin/post-new.php");

    Browser.getWebDriver().switchTo()
        .frame(Browser.getWebDriver().findElement(By.xpath("//iframe[@title='Editor canvas']")));

    WebElement titleElement = Browser.waitForElementToBeVisible(By.xpath("//*[contains(@class,'wp-block-post-title')]"));
    titleElement.clear();
    titleElement.sendKeys("Title " + System.currentTimeMillis());
    System.out.println(titleElement.getText());
    titleElement.sendKeys(Keys.ENTER);

    WebElement textElement = Browser.waitForElementToBeVisible(By.xpath("//*[contains(@class,'wp-block-post-content')]/p"));
    textElement.sendKeys("body " + System.currentTimeMillis());
    textElement.sendKeys(Keys.ENTER);

    Browser.getWebDriver().switchTo().defaultContent();

    Browser.waitForElementToBeClickable(By.id("tabs-0-edit-post/document")).click();

    WebElement inputTagField = Browser.waitForElementToBeVisible(By.xpath("//*[contains(@id,'components-form-token-input')]"));
    inputTagField.sendKeys(tag);
    inputTagField.sendKeys(Keys.ENTER);

    Browser.waitForElementToBeVisible(By.xpath(String.format("//*[contains(text(),'%s')]", tag)));

    WebDriverWait wait = new WebDriverWait(Browser.getWebDriver(), Duration.ofSeconds(15));
    wait.until(ExpectedConditions
        .presenceOfElementLocated(By.xpath(
            String.format("//*[contains(@id,'components-form-token-field__token-text')]//*[@data-wp-component][contains(text(),'%s')]", tag))));


    Browser.waitForElementToBeClickable(By.xpath("//button[contains(text(),'Publish')]")).click();
    Browser.waitForElementToBeClickable(By.xpath("//*[contains(@class,'editor-post-publish-panel__header')]/button[contains(text(),'Publish')]")).click();

    System.out.println("");


  }

  @AfterMethod
  public void tearDown(){
    Browser.close();
  }
}
