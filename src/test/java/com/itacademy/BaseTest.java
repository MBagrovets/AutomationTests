package com.itacademy;

import com.itacademy.enums.Capability;
import com.itacademy.utils.DriverFactory;
import com.itacademy.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp(){

//        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
//        driver = new ChromeDriver();
//              ИЛИ:
//        driver = DriverFactory.createDriver("chrome");
//              ИЛИ (с ENUMS):

        driver = DriverFactory.createDriver(PropertyReader.getConfigProperty(Capability.BROWSER));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void closeSession(){
        driver.quit();
    }
}
