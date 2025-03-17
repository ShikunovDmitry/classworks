package com.itacademy.aqa;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

//@Listeners({QTestListener.class, AnnotationTransformer.class})
public class SimpleSecondTest {

    @Test(description = "Simple test", priority = 1, groups = {"smoke", "regression"})
    public void simpleTest() {
        System.out.println("Simple Test Method.");
        Assert.assertTrue(new Random().nextInt(10) < 3);
    }

    @Test(dependsOnMethods = "simpleTest", alwaysRun = true, retryAnalyzer = RetryAnalyzer.class)
    public void simpleSecondTest() {
        System.out.println("Simple Second Test Method.");
        Assert.assertTrue(new Random().nextInt(10) < 3);
    }

    @Test(expectedExceptions = SecurityException.class, expectedExceptionsMessageRegExp = "Here.*", retryAnalyzer = RetryAnalyzer.class)
    public void testExceptionIsThrown() {
        new ExceptionThrower().thrower();
    }

    @Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
    public void testOfDataProvider(String expected, String actual) {
        Assert.assertNotEquals(actual, expected);
    }

}
