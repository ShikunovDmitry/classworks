package com.itacademy.aqa.onliner.pages;

import com.itacademy.aqa.onliner.elements.TopMenu;

public abstract class BaseOnlinerPage {
    private TopMenu topMenu;

    public abstract boolean isPageOpened();

    public TopMenu getTopMenu() {
        return topMenu;
    }

    protected BaseOnlinerPage(){
        topMenu = new TopMenu();
    }
}
