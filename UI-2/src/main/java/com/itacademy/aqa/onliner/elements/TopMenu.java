package com.itacademy.aqa.onliner.elements;

import com.itacademy.aqa.onliner.webDriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenu {


    private static final String ITEM_PATTER = "//nav//*[contains(text(),'%s')]";

    public void clickOnItem(TopMenuEnum topMenuEnum) {

        String xPath = String.format(ITEM_PATTER, topMenuEnum.getValue());
        By menuItemLocator = By.xpath(xPath);

        WebElement element = Browser.waitForElementToBeClickable(menuItemLocator);

        element.click();
    }
}
