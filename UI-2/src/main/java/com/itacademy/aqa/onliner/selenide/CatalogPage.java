package com.itacademy.aqa.onliner.selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {


    public SelenideElement getCatalogNavigation() {
        return $x("//div[@class='catalog-navigation-classifier']");
    }

    public void openPage() {
        open("https://catalog.onliner.by/");
    }

    public SelenideElement getSection(String sectionName) {
        return getCatalogNavigation().$x("span[contains(text(),'" + sectionName + "')]");
    }

}
