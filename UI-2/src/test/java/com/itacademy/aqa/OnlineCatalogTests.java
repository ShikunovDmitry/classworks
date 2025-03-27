package com.itacademy.aqa;

import com.itacademy.aqa.onliner.elements.TopMenuEnum;
import com.itacademy.aqa.onliner.pages.CatalogPage;
import com.itacademy.aqa.onliner.pages.MainPage;
import com.itacademy.aqa.onliner.webDriver.Browser;
import com.itacademy.aqa.onliner.webDriver.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OnlineCatalogTests {

    CatalogPage catalogPage;

    @BeforeMethod
    public void initialize() {
        Browser.getWebDriver().get(Configuration.getBaseUrl());
        MainPage mainPage = new MainPage();
        mainPage.getTopMenu().clickOnItem(TopMenuEnum.CATALOG);
        catalogPage = new CatalogPage();
    }

    @Test
    public void catalogPageIsAvailable(){
        catalogPage = new CatalogPage();
        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page wasn't opened");
    }

    @Test(dataProvider = "expectedCatalogMenuItems")
    public void catalogMenuItemAvailableInTheMainMenu(String expectedMenuItem){
        var expectedTopMenuItem = catalogPage.getCatalogMainMenu(expectedMenuItem);

        Assert.assertNotNull(expectedTopMenuItem, expectedMenuItem + " wasn't found");

        Assert.assertEquals(expectedTopMenuItem.getText(),
                expectedMenuItem,
                "Item text doesn't match");

    }


    @AfterMethod
    public void tearDown() {
        Browser.close();
    }

    @DataProvider
    public static Object[][] expectedCatalogMenuItems(){
        return new Object[][]{
                {"Onlíner Prime"},
                {"Электроника"},
                {"Компьютеры и сети"},
                {"Бытовая техника"},
                {"На каждый день"},
                {"Стройка и ремонт"},
                {"Дом и сад"},
                {"Авто и мото"},
                {"Красота и спорт"},
                {"Детям и мамам"}
        };
    }
}
