package com.itacademy.aqa.onliner.elements;

public enum TopMenuEnum {
    CATALOG("Каталог"),
    NEWS("Новости"),
    AUTOSALES("Автобарахолка"),
    FLATSALES(""),
    SERVICES("");

    private String value;

    TopMenuEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
