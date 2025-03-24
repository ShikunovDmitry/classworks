package com.itacademy.aqa.onliner.pageObject.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenu {

    WebDriver webDriver;

    public TopMenu(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    private static final String ITEM_PATTER = "//nav//*[contains(text(),'%s')]";

    public void clickOnItem(TopMenuEnum topMenuEnum){

        String xPath = String.format(ITEM_PATTER,topMenuEnum.getValue());
        By menuItemLocator = By.xpath(xPath);

        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(menuItemLocator));

        WebElement element = webDriver.findElement(menuItemLocator);

        element.click();
    }
}
