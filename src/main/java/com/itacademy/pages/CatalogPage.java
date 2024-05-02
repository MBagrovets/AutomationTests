package com.itacademy.pages;

import com.itacademy.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage extends BasePage {

    @FindBy (xpath = "//*[@class = 'sc-124al1g-0 jCsgpZ']")
    private WebElement firstElementBtn;

    public void clickFirstElementBtn(){
        firstElementBtn.click();    //когда обращаемся к этому методу, происходит поиск по @FindBy
    }

    @FindBy (xpath = "//span[@class = 'checkmark']")
    private WebElement sizeBtn;

    public void clickSizeBtn(){
        sizeBtn.click();
    }

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);  //this - это CatalogPage.class. Создает элементы по @FindBy
    }

    public void openUrl(){
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }
}
