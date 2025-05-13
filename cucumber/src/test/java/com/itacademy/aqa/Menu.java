package com.itacademy.aqa;

public class Menu {
    public Menu(String title, boolean isAvailable, int subMenuCount) {
        this.title = title;
        this.isAvailable = isAvailable;
        this.subMenuCount = subMenuCount;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    private boolean isAvailable;

    public int getSubMenuCount() {
        return subMenuCount;
    }

    public void setSubMenuCount(int subMenuCount) {
        this.subMenuCount = subMenuCount;
    }

    private int subMenuCount;
}
