package com.itacademy.aqa;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class QTestListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() +
                " qTest was " + (result.isSuccess() ? "SUCCESS" : "FAILED"));

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " qTest was "
                + (result.isSuccess() ? "SUCCESS" : "FAILED"));
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On test finished");
    }
}
