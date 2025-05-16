package pages;

import enums.MenuEnum;
import forms.DropdownMenu;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class MainPage {

    private MainMenu mainMenu = new MainMenu();

    private DropdownMenu dropdownMenu = new DropdownMenu();

    @Step("Show menu item")
    public void showMenuByItem(String menuItem) {
        mainMenu.hoverOverItem(menuItem);
        dropdownMenu.waitUntilVisible();
    }
    @Step("Show menu by item")
    public void showMenuByItem(MenuEnum menuItem) {
        Allure.description("Item name  " + menuItem);
        mainMenu.hoverOverItem(menuItem.getMenuText());
        dropdownMenu.waitUntilVisible();
    }
    @Step("Is dropdown visible")
    public boolean isDropdownItemVisible(String name) {

        return dropdownMenu.isItemVisible(name);
    }
}
