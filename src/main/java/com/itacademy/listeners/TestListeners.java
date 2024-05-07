package com.itacademy.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.sql.SQLOutput;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("========================================");
        System.out.println("Test "+ result.getMethod().getMethodName()+" started");
        System.out.println("========================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("========================================");
        System.out.println("Test "+ result.getMethod().getMethodName()+" passed");
        System.out.println("========================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("========================================");
        System.out.println("Test "+ result.getMethod().getMethodName()+" failed");
        System.out.println("========================================");
        //ScreenshotUtils.takeScreenshot(driver); - скриншоты в Listeners делаются немного по-другому
        //System.out.println(driver.getPageSource()); - напечатает на выходе все дерево HTML
    }
}
