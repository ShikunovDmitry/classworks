package org.webdriver.onliner.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.webdriver.onliner.pages.ItemsInCatalogPage;
import org.webdriver.onliner.pages.StartPage;
import org.webdriver.onliner.utility.Browser;
import org.webdriver.onliner.utility.WebProperties;

import java.util.List;

public class FilterTest extends BaseTest {

    StartPage startPage;
    ItemsInCatalogPage itemsInCatalogPage;


    @BeforeMethod
    public void openOnliner(){
        Browser.getDriver().get(WebProperties.getBaseUrl());
        startPage = new StartPage();
        itemsInCatalogPage = new ItemsInCatalogPage();
    }

    @Test
    public void filterProductShouldWork() {
        Browser.getDriver().get(WebProperties.getBaseUrl() + "/tv");

        Assert.assertTrue(startPage.isOpened());

        Assert.assertTrue(startPage.getQuickNavigationForm().isItemExist("Телевизоры"),
                "Нет пункта меню телевизоры");

        startPage.getQuickNavigationForm().clickOnItem("Телевизоры");
        Assert.assertTrue(itemsInCatalogPage.isOpened("Телевизоры"));
        Assert.assertTrue(itemsInCatalogPage.getFilterForm().isExists(),"");

        itemsInCatalogPage.getFilterForm().chooseValueForSpecifiedFilter("Производитель", "LG");
        itemsInCatalogPage.waitUntilCatalogUpdated();

        List<String> titles = itemsInCatalogPage.getAllProductTitlesElements();
        Assert.assertTrue(titles.size()>0,"");

        SoftAssert softAssert = new SoftAssert();
        for (String title : titles) {
            softAssert.assertTrue(title.contains("LG"),
                "LG" + " is not found in " + title);
        }
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanup(){
        Browser.close();
    }
}

