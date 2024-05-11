package com.itacademy.listeners;

import com.itacademy.utils.DriverManager;
import com.itacademy.utils.ScreenshotUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

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
        DriverManager.quitDriver();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("========================================");
        System.out.println("Test "+ result.getMethod().getMethodName()+" failed");
        System.out.println("========================================");
        //с DriverManager можно делать скрины:
        ScreenshotUtils.takeScreenshot(DriverManager.getDriver()); // скриншоты в Listeners делаются немного по-другому
        System.out.println(DriverManager.getDriver().getPageSource()); // напечатает на выходе все дерево HTML
        DriverManager.quitDriver();
    }
}
