package com.itacademy;

import net.bytebuddy.description.field.FieldList;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FacebookTest {

    WebDriver driver;  // создание драйвера

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver-win64.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void signUpFacebookTest() {
        driver.get("https://facebook.com");
        driver.findElement(By.cssSelector("[data-testid='open-registration-form-button']")).click();
        WebElement formTitle = driver.findElement(By.xpath("//div[text() = 'Sign Up']"));
        Assert.assertTrue(formTitle.isDisplayed(), "Sign up title isn't present");

        WebElement firstNameInputField = driver.findElement(By.name("firstname"));
        Point point = firstNameInputField.getLocation();
        Dimension dimension = firstNameInputField.getSize();
        firstNameInputField.click();
        firstNameInputField.sendKeys("Ivan");

        WebElement dayPicker = driver.findElement(By.name("birthday_day"));
        Select daySelect = new Select(dayPicker);
        daySelect.selectByIndex(3);
        daySelect.selectByValue("5");
        daySelect.selectByVisibleText("7");

        driver.findElement(By.cssSelector("[name= 'websubmit']")).click();
        WebElement error = driver.findElement(By.id("js_o"));
        Assert.assertEquals(error.getText(), "What's your name?");
    }

    @Test
    public void googleTest() {
        driver.get("http://www.google.com");
        //driver.manage().window().maximize(); //увеличить размер экрана

        WebElement element = driver.findElement(By.name("q"));

        driver.findElement(By.name("q")); //поиск по name, classname или id
        driver.findElement(By.className("gLFyf"));
        driver.findElement(By.id("APjFqb")); //best practice для поиска элемента!!!

        driver.findElement(By.xpath("//textarea[@class='gLFyf']"));  //как искали в devtools
        driver.findElement((By.cssSelector(".gLFyf .crver[aria-id='']")));

        List<WebElement> webElementList = driver.findElements(By.xpath("//*[text() = 'Add to cart']"));
        for (WebElement element1: webElementList) {
            element1.click();
        }
        List<WebElement> names= driver.findElements(By.cssSelector(".sc-124al1g-4.eeXMBo.sc-124al1g-4.eeXMBo"));
        //List<String> namesStr = names.stream().map(x->x.getText()).toList();
        element.sendKeys("Selenium");
        element.submit(); //это Enter
    }

    @AfterTest
    public void closeSession() {
        driver.quit(); //остановка сессии
    }

}
