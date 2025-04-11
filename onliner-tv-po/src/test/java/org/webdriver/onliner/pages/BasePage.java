package org.webdriver.onliner.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.webdriver.onliner.elements.TopMenu;
import org.webdriver.onliner.utility.Browser;

public abstract class BasePage {
    public abstract void openPage();

    protected TopMenu topMenu = new TopMenu();


}
