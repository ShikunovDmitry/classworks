package com.itacademy.aqa.onliner.pages;

import com.itacademy.aqa.onliner.webDriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AvtoPage extends BaseOnlinerPage{

    private static final By FIRS_VEHICLE_OFFER_LOCATOR = By.className("vehicle-form__offers");

    public AvtoPage() {
        super();
    }

    @Override
    public boolean isPageOpened() {
        List<WebElement> webElements = Browser.getWebDriver().findElements(FIRS_VEHICLE_OFFER_LOCATOR);
        return !webElements.isEmpty();
    }


}
