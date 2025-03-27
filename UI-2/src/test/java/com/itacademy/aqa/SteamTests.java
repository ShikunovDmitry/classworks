package com.itacademy.aqa;

import com.itacademy.aqa.onliner.webDriver.Browser;
import com.itacademy.aqa.onliner.webDriver.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class SteamTests {

    @BeforeMethod
    public void inialize(){
        Browser.getWebDriver().get("https://store.steampowered.com/");
    }

    @Test
    public void downloadTest() throws InterruptedException {

        String downloadDirectory = "C:\\Users\\Dzmitry_Shykunou\\Downloads\\";
//        String downloadDirectory = Configuration.getDownloadDirectory();

        String downloadPath = downloadDirectory + "SteamSetup.exe";

        File fileToVerify = new File(downloadPath);

        if(fileToVerify.exists()){
            fileToVerify.delete();
        }

        WebElement installPageWebElement =
                Browser.waitForElementToBeClickable(By.xpath("//*[contains(@class,'header_installsteam_btn_content')]"));

        installPageWebElement.click();

        WebElement downloadSteamButton = Browser.waitForElementToBeClickable(By.xpath("//*[contains(@class,'about_install_steam_link')][1]"));

        downloadSteamButton.click();

        FluentWait<File> wait = new FluentWait<>(fileToVerify);

        wait.withTimeout(Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofSeconds(5));

        wait.until(file -> file.exists() && file.length()>0);

        Assert.assertTrue(fileToVerify.exists(), " File wasn't downloaded by path " + downloadPath);

    }
    @AfterMethod
    public void tearDown() {
        Browser.close();
    }
}
