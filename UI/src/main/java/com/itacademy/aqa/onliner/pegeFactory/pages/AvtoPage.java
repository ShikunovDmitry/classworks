package com.itacademy.aqa.onliner.pegeFactory.pages;


import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AvtoPage {

    @FindBy(className = "vehicle-form__offers")
    private WebElement firsVehicleOffer;

    public AvtoPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageOpened() {
        try {
            return firsVehicleOffer.isDisplayed();
        } catch (NotFoundException ex) {
            return false;
        }

    }


}
