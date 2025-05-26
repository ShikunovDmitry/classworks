package com.itacademy.aqa.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Page Object для страницы логина
public class LoginPage {
    private WebDriver driver;

    // Локаторы
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");

    // Конструктор
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы взаимодействия с элементами
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    // Добавьте методы для проверки ошибок или валидации.
}