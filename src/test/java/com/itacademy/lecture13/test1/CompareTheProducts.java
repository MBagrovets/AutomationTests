package com.itacademy.lecture13.test1;

//1. Найдите название первого продукта
//2. Добавьте в корзину первый продукт
//3. Сравните название продукта в корзине с названием продукта из первого пункта

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CompareTheProducts {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test
    public void clothesSite(){
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        WebElement addButton = driver.findElement(By.xpath("//div[@class = 'sc-124al1g-0 jCsgpZ']"));
        addButton.click();

        WebElement itemInCatalog = driver.findElement(By.xpath("//p[@class = 'sc-124al1g-4 eeXMBo'][contains(text(),'Cropped Stay Groovy off white')]"));
        WebElement itemInBasket = driver.findElement(By.xpath("//p[@class = 'sc-11uohgb-2 elbkhN'][contains(text(),'Cropped Stay Groovy off white')]"));


    }

    @AfterTest
    public void closeSession(){
        driver.quit();
    }

}
