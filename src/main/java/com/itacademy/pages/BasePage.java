package com.itacademy.pages;

import com.itacademy.listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

}
