package com.itacademy.aqa;

import com.itacademy.aqa.builder.User;
import com.itacademy.aqa.pageObject.LoginPage;
import com.itacademy.aqa.webdriver.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Unit test for simple App.
 */
public class AppTest{

    @Test
    public void testLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("testUser");
        loginPage.enterPassword("testPassword");
        loginPage.clickLoginButton();

        Assertions.assertEquals("Dashboard", loginPage.getPageTitle());
        driver.quit();
    }

    @Test
    public void testSingleton() {
        WebDriver driver = WebDriverManager.getDriver();
        driver.get("https://example.com");
        Assertions.assertEquals("Example Domain", driver.getTitle());

        WebDriverManager.quitDriver();
    }

    @Test
    public void builderTest(){
        User admin = new User.Builder()
            .withUserName("admin")
            .withPassword("qwaszx!2")
            .withRole("admin")
            .build();

        User admin2 = new User.Builder()
            .withUserName("admin")
            .withRole("admin")
            .build();

    }
}
