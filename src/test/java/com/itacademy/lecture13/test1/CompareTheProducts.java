package com.itacademy.lecture13.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CompareTheProducts {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//              Тест 1
//              1. Найдите название первого продукта
//              2. Добавьте в корзину первый продукт
//              3. Сравните название продукта в корзине с названием продукта из первого пункта

    @Test
    public void test1(){
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");


        WebElement itemInCatalog = driver.findElement(By.xpath("//p[@class = 'sc-124al1g-4 eeXMBo']"));
        WebElement addButton = driver.findElement(By.xpath("//*[@class = 'sc-124al1g-0 jCsgpZ']"));
        addButton.click();
        WebElement itemInBasket = driver.findElement(By.xpath("//p[@class = 'sc-11uohgb-2 elbkhN']"));

        Assert.assertEquals(itemInCatalog.getText(),itemInBasket.getText());
    }

//              Тест 2.
//              1. Получите названия всех продуктов(используйте List)
//              2. Добавьте все продукты в корзину
//              3. Сравните все названия продуктов в корзине с листом из первого пункта
    @Test
    public void test2(){
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        List<WebElement> list1 = driver.findElements(By.xpath("//p[@class = 'sc-124al1g-4 eeXMBo']"));
        List <WebElement> add = driver.findElements(By.xpath("//*[text()='Add to cart']"));

        List<String> a = list1.stream().map(x->x.getText()).toList();

        for(WebElement element:add)
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

        List<WebElement> list2 = driver.findElements(By.xpath("//*[@class = 'sc-11uohgb-2 elbkhN']"));

        List<String> b = list2.stream().map(x->x.getText()).toList();

        Assert.assertEquals(a,b);
    }

//              Тест 3
//              1. Получите названия всех продуктов(используйте List)
//              2. Отфильтруйте продукты по любому размеру(сверху слева есть размеры S, M, ML и др)
//              3. Получите лист для текущих продуктов и сравните что его размер меньше листа из первого пункта

    @Test
    public void test3(){
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        List<WebElement> listOfProducts = driver.findElements(By.xpath("//*[@class = 'sc-124al1g-4 eeXMBo']"));
        List<String> allProductsList = listOfProducts.stream().map(x->x.getText()).toList();

        WebElement size = driver.findElement(By.xpath("//span[@class = 'checkmark']"));

        List<WebElement> xsList = driver.findElements((By.xpath("//span[@class = 'checkmark']")));
        List<String> xsProducts = xsList.stream().map(x->x.getText()).toList();

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
    public void test4() throws InterruptedException {

        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        WebElement allProducts = driver.findElement(By.xpath("//*[@class = 'sc-ebmerl-4 iliWeY']/p"));
        String countText = allProducts.getAttribute("innerText");

        String[] parts = countText.split(" ");
        int productCount = 0;

        for(String part:parts){
            if(part.matches("\\d+")){
                productCount = Integer.parseInt(part);
                break;
            }
        }

        WebElement size = driver.findElement(By.xpath("//span[@class = 'checkmark']"));
        size.click();

        Thread.sleep(5000);

        WebElement sizeProducts = driver.findElement(By.xpath("//*[@class = 'sc-ebmerl-4 iliWeY']/p"));
        String sizeCountText = allProducts.getAttribute("innerText");

        String[] parts2 = countText.split(" ");
        int productCount2 = 0;

        for(String part:parts){
            if(part.matches("\\d+")){
                productCount2 = Integer.parseInt(part);
                break;
            }
        }

        if (productCount2 > productCount) {
            System.out.println("Размер списка 2 больше размера списка 1");
        } else if(productCount2 < productCount){
            System.out.println("Размер списка 2 меньше размера списка 1");
        } else{
            System.out.println("Размер списка 2 равен размеру списка 1");
        }
    }

    @AfterTest
    public void closeSession(){
        driver.quit();
    }

}
