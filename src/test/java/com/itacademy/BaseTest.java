package com.itacademy;

import com.itacademy.enums.Capability;
import com.itacademy.listeners.ElementActionListener;
import com.itacademy.listeners.TestListeners;
import com.itacademy.utils.DriverFactory;
import com.itacademy.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(TestListeners.class)  // остальные классы унаследуют Listeners отсюда
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

        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator(new ElementActionListener()); //для того, чтобы подтянуть лиссенеры из ElementActionListener (т.к. там применяется selenium.support.events.WebDriverListener)
        driver = decorator.decorate(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void closeSession(){
        driver.quit();
    }
}
