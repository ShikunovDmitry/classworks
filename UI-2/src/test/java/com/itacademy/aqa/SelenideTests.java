package com.itacademy.aqa;

import com.codeborne.selenide.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTests {
    static {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
    }

    @Test
    public void catalogSelectionTest(){

        open("https://catalog.onliner.by/");

        WebDriverRunner.getWebDriver().manage().window().maximize();

        SelenideElement section = $x("//div[@class='catalog-navigation-classifier']")
            .$x(".//span[contains(text(),'Электроника')]")
            .shouldBe(visible)
            .shouldBe(text("Электроника"));
    }
}
