package com.itacademy.aqa;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class ListenerExample implements TestWatcher, AfterAllCallback, TestExecutionExceptionHandler {
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("if test disabled" + context.getDisplayName());
    }

    public void testSuccessful(ExtensionContext context) {
        System.out.println("if test successful" + context.getDisplayName());
    }

    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("if test aborted" + context.getDisplayName());
        System.out.println(cause.getMessage());
    }

    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("if test failed" + context.getDisplayName());
        System.out.println(cause.getMessage());

    }

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        System.out.println("I'm from throwable " + throwable.getMessage());
        if(extensionContext.getTags().contains("Smoke")){
            throw throwable;
        }
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("After all test execution");
    }
}
