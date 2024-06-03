package com.itacademy.listeners;

import com.itacademy.pages.CatalogPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.Method;
import java.util.List;

public class ElementActionListener implements WebDriverListener {

    @Override
    public void afterClick(WebElement element) {
        System.out.println("There was a " + element.getTagName() + " click");
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        System.out.println("There was a Get method");
    }

    @Override
    public void afterFindElement(WebElement element, By locator, WebElement result) {
        System.out.println("There was a Finding element method");
    }

    @Override
    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
        System.out.println("There was a Finding element method");

        //Allure.step("");    - возможно прикрутить Аллюр
    }
}
