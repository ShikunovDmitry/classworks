package com.itacademy.aqa.onliner.pageObject.pages;

import com.itacademy.aqa.onliner.pageObject.elements.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private TopMenu topMenu;
    private WebDriver webDriver;
    private static final By PAGE_LOCATOR = By.className("widget-item");


    public TopMenu getTopMenu() {
        return topMenu;
    }

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        topMenu = new TopMenu(webDriver);
    }

    public boolean isPageOpened() {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_LOCATOR));
            return webDriver.findElement(PAGE_LOCATOR).isDisplayed();
        } catch (NotFoundException ex) {
            return false;
        }
    }
}
