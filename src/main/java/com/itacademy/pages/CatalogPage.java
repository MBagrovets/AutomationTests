package com.itacademy.pages;

import com.itacademy.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogPage extends BasePage {

    public void openUrl(){
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);  //this - это CatalogPage.class. Создает элементы по @FindBy
    }

    @FindBy (xpath = "//*[@class = 'sc-124al1g-0 jCsgpZ']")
    private WebElement firstElementBtn;

    public void clickFirstElementBtn(){
        firstElementBtn.click();    //когда обращаемся к этому методу, происходит поиск по @FindBy
    }

    @FindBy (xpath = "//span[@class = 'checkmark']")
    private WebElement sizeBtn;

    @FindBy (xpath = "//p[@class = 'sc-124al1g-4 eeXMBo']")
    private WebElement itemInCatalog;

    public WebElement getItemInCatalog(){
        return itemInCatalog;
    }

    @FindBy (xpath = "//p[@class = 'sc-124al1g-4 eeXMBo']")
            private List<WebElement> nameOfElement;

    public List<WebElement> getNameOfElement(){
        return nameOfElement;
    }

    @FindBy(xpath = "//*[text()='Add to cart']")
    private List<WebElement> addToCartBtn;


    public List<WebElement> getAddToCartBtn() {
        return addToCartBtn;
    }

    public void clickSizeBtn(){
        sizeBtn.click();
    }

    @FindBy (xpath = "//*[@class = 'sc-124al1g-4 eeXMBo']")
            public List<WebElement>listOfProducts;

    @FindBy (xpath = "//span[@class = 'checkmark']")
    public List<WebElement> xsList;

    @FindBy (xpath = "//*[@class = 'sc-ebmerl-4 iliWeY']/p")
    public List <WebElement> listOfProductsNaming;

    @FindBy (xpath = "//*[@class = 'sc-ebmerl-4 iliWeY']/p")
    public List<WebElement> sizeListOfProductsNaming;


    @FindBy (xpath = "//*[contains (text(), 'follow me on Linkedin.')]")
    private WebElement followToLinkedinBtn;

    public void clickFollowToLinkedinBtn() {
        followToLinkedinBtn.click();
    }

}
