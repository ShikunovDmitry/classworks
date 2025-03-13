package com.itacademy.aqa;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "testData")
    public static Object[][] dataProvider(){
        return new Object[][]{
                {"expected","actual"},
                {"expected2","actual2"}
        };
    }
}
