package com.itacademy;

import com.itacademy.pages.CartPage;
import com.itacademy.pages.CatalogPage;
import com.itacademy.utils.ScreenshotUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CompareProducts extends BaseTest {

//              Тест 1
//              1. Найдите название первого продукта
//              2. Добавьте в корзину первый продукт
//              3. Сравните название продукта в корзине с названием продукта из первого пункта

    @Test
    public void test1() throws IOException, InterruptedException {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openUrl();
        CartPage cartPage = new CartPage(driver);

        String itemInCatalogText = catalogPage.getItemInCatalog().getText();
        catalogPage.clickFirstElementBtn();
        String itemInBasketText = cartPage.getItemInBacket().getText();
        Thread.sleep(4000);

        Assert.assertEquals(itemInBasketText,itemInCatalogText);

        //ScreenshotUtils.takeScreenshot(driver);
    }

//              Тест 2.
//              1. Получите названия всех продуктов(используйте List)
//              2. Добавьте все продукты в корзину
//              3. Сравните все названия продуктов в корзине с листом из первого пункта
    @Test
    public void test2() throws InterruptedException {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openUrl();
        CartPage cartPage = new CartPage(driver);

        catalogPage.getNameOfElement();
        catalogPage.getAddToCartBtn();
        List<String> elementsOnPage = catalogPage.getNameOfElement().stream().map(x->x.getText()).toList();
        for(WebElement element: catalogPage.getAddToCartBtn()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element); //позволяет кликнуть по элементу, даже если его не видно
        }
        Thread.sleep(3000); //чтобы успеть посмотреть
        cartPage.getItemsInCart();
        List<String> elementsInCart = cartPage.getItemsInCart().stream().map(x->x.getText()).toList();

        Assert.assertEquals(elementsOnPage,elementsInCart);
    }

//              Тест 3
//              1. Получите названия всех продуктов(используйте List)
//              2. Отфильтруйте продукты по любому размеру(сверху слева есть размеры S, M, ML и др)
//              3. Получите лист для текущих продуктов и сравните что его размер меньше листа из первого пункта

    @Test
    public void test3(){
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openUrl();

        List<String> allProductsList = catalogPage.listOfProducts.stream().map(x->x.getText()).toList();
        catalogPage.clickSizeBtn();
        List<String> xsProducts = catalogPage.xsList.stream().map(x->x.getText()).toList();

        if (xsProducts.size() < allProductsList.size()) {
            System.out.println("Размер списка текущих продуктов меньше размера списка всех продуктов");
        } else {
            System.out.println("Размер списка текущих продуктов больше или равен размеру списка всех продуктов");
        }
    }

//              Тест 4
//              1. Получите количество продуктов расспарсив сверху стрингу  16 Product(s) found
//              2. Отфильтруйте продукты по любому размеру(сверху слева есть размеры S, M, ML и др)
//              3. Получите количество продуктов после фильтра  расспарсив сверху стрингу   Product(s) found и сравните с числом из первого пункта

    @Test
    public void test4() throws InterruptedException{

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openUrl();

        List<String> allProductsList = catalogPage.listOfProductsNaming.stream().map(x->x.getText()).toList();
        catalogPage.clickSizeBtn();
        Thread.sleep(3000);
        List<String> sizeAllProductsList = catalogPage.sizeListOfProductsNaming.stream().map(x->x.getText()).toList();

        if (allProductsList.equals(sizeAllProductsList)) {
            System.out.println("Списки продуктов совпадают");
        } else {
            System.out.println("Списки продуктов не совпадают");
        }
    }
}