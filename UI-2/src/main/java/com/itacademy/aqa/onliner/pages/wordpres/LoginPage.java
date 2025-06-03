package com.itacademy.aqa.onliner.pages.wordpres;

import com.itacademy.aqa.onliner.webDriver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
  private final static By USER_NAME_LOCATOR = By.id("user_login");
  private final static By PASSW_LOCATOR = By.id("user_pass");
  private final static By SUBMIT_BUTTON = By.id("wp-submit");

  public void login(String userName, String password) {
    WebElement userNameField = Browser.waitForElementToBeVisible(USER_NAME_LOCATOR);
    WebElement userPasswordField = Browser.waitForElementToBeVisible(PASSW_LOCATOR);
    WebElement submitButton = Browser.waitForElementToBeClickable(SUBMIT_BUTTON);

    userNameField.clear();
    userNameField.sendKeys(userName);

    userPasswordField.clear();
    userPasswordField.sendKeys(password);

    submitButton.click();
  }

  public boolean isPageOpened() {
    WebElement userNameField = Browser.waitForElementToBeVisible(USER_NAME_LOCATOR);
    return userNameField != null;
  }
}
