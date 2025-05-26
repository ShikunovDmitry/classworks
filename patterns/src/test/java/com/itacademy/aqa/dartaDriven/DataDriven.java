package com.itacademy.aqa.dartaDriven;

import com.itacademy.aqa.pageObject.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriven {
  @ParameterizedTest
  @CsvFileSource(resources = "/test-data/loginData.csv", numLinesToSkip = 1)
  public void testLogin(String username, String password, String expectedTitle) {
    WebDriver driver = new ChromeDriver();
    driver.get("https://example.com/login");

    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    loginPage.clickLoginButton();

    Assertions.assertEquals(expectedTitle, loginPage.getPageTitle());
    driver.quit();
  }
}
