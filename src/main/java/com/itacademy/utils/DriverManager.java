package com.itacademy.utils;

import com.itacademy.enums.Capability;
import com.itacademy.listeners.ElementActionListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class DriverManager {                                                          //16 лекция
    static WebDriver driver;
    static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();
    //private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
    public synchronized static WebDriver getDriver() {
        if (localDriver.get() == null) {
            driver = DriverFactory.createDriver(PropertyReader.getConfigProperty(Capability.BROWSER));
            EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator(new ElementActionListener()); //для того, чтобы подтянуть лиссенеры из ElementActionListener (т.к. там применяется selenium.support.events.WebDriverListener)
            driver = decorator.decorate(driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            localDriver.set(driver);
            return driver;
        } else{
            return localDriver.get();
        }
    }

    public static void quitDriver(){
        localDriver.get().quit();
        localDriver.set(null);
    }

//    public static void quitDriver() {
//        LOGGER.info("Before quit");
//        if (localDriver.get() ==null)
//            driver.quit();
//        else
//            localDriver.get().quit();
//        LOGGER.info("After quit");
//        localDriver.set(null);
//        LOGGER.info("After set null");
//    }
}
