package com.itacademy.aqa;

import com.itacademy.aqa.onliner.elements.TopMenuEnum;
import com.itacademy.aqa.onliner.pages.AvtoPage;
import com.itacademy.aqa.onliner.pages.MainPage;
import com.itacademy.aqa.onliner.webDriver.Browser;

import com.itacademy.aqa.onliner.webDriver.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OnlinerPageObjectTests {

    @BeforeMethod
    public void initialize() {
        Browser.getWebDriver().get(Configuration.getBaseUrl());
    }

    @Test
    public void onlinerCanBeOpenedTest(){

        MainPage mainPage = new MainPage();

        Assert.assertTrue(mainPage.isPageOpened(), "Onliner main page is not opened");

    }

    @Test
    public void avtoCanBeOpened(){
        MainPage mainPage = new MainPage();

        mainPage.getTopMenu().clickOnItem(TopMenuEnum.AUTOSALES);

        AvtoPage avtoPage = new AvtoPage();

        Assert.assertTrue(avtoPage.isPageOpened(), "Автобарахолка page is not opened");

    }

    @AfterMethod
    public void tearDown() {
        Browser.close();
    }
}
