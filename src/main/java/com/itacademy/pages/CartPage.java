package com.itacademy.pages;

import com.itacademy.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{

    public CartPage() {
        PageFactory.initElements(DriverManager.getDriver(),this);  //this - это CatalogPage.class. Создает элементы по @FindBy
    }
    @FindBy(xpath = "//p[@class = 'sc-11uohgb-2 elbkhN']")
    private WebElement itemInBasket;

    public WebElement getItemInBacket(){
        return itemInBasket;
    }

    @FindBy (xpath = "//*[@class = 'sc-11uohgb-2 elbkhN']")
    private List<WebElement> itemsInCart;

    public List<WebElement> getItemsInCart(){
        return itemsInCart;
    }

}
