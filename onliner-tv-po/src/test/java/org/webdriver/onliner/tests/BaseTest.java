package org.webdriver.onliner.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.webdriver.onliner.utility.Browser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    {
        System.setProperty("browserType", "CHROME");
    }

    @BeforeMethod
    public void initDriver(){
        Browser.initDriver();
    }
    @AfterMethod
    public void cleanup(){
        Browser.close();
    }
}
