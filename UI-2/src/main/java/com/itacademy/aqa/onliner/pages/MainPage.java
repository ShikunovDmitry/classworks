package com.itacademy.aqa.onliner.pages;

import com.itacademy.aqa.onliner.webDriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

public class MainPage extends BaseOnlinerPage{

    private static final By PAGE_LOCATOR = By.className("widget-item");

    public MainPage() {
        super();
    }

    @Override
    public boolean isPageOpened() {
        try {
            return Browser.waitForElementToBeVisible(PAGE_LOCATOR).isDisplayed();
        } catch (NotFoundException ex) {
            return false;
        }
    }
}
