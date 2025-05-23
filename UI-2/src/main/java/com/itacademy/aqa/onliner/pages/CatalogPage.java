package com.itacademy.aqa.onliner.pages;

import com.itacademy.aqa.onliner.elements.Button;
import com.itacademy.aqa.onliner.webDriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage extends BaseOnlinerPage {

    private static final By PAGE_LOCATOR = By.xpath("//*[@class='catalog-navigation__title'][text()='Каталог']");

    private static final By ALL_MENU_ITEMS_LOCATOR =
            By.xpath("//*[@class='catalog-navigation-classifier']//*[@class='catalog-navigation-classifier__item-title']");

    @Override
    public boolean isPageOpened() {
        WebElement pageElement = Browser.waitForElementToBeVisible(PAGE_LOCATOR);
        return pageElement != null && pageElement.isDisplayed();
    }

    public Button getCatalogMainMenu(String expectedMenuItem) {

        List<WebElement> menuElements = Browser.getWebDriver().findElements(ALL_MENU_ITEMS_LOCATOR);

        WebElement menuWebElement = menuElements.stream().filter(webElement -> webElement.getText().contains(expectedMenuItem))
                .findFirst().orElse(null);
        return menuWebElement != null ? new Button(menuWebElement) : null;

    }
}

