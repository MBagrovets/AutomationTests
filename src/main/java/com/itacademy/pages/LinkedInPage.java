package com.itacademy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertEquals;

public class LinkedInPage extends BasePage{

    public void openUrl(){
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    public LinkedInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);  //this - это CatalogPage.class. Создает элементы по @FindBy
    }

    @FindBy(xpath = "//*[@class = 'sign-in-modal__outlet-btn cursor-pointer btn-md btn-primary'][@data-modal = 'public_profile_top-card_title-modal-id_sign-in-modal'][contains (text(), 'Sign in')]")
    private WebElement firstSignInBtn;


    public void clickFirstSignInBtn(){
        firstSignInBtn.click();
    }

    @FindBy (xpath = "//*[@class = 'text-color-text font-sans text-md outline-0 bg-color-transparent grow'][@id = 'public_profile_contextual-sign-in_sign-in-modal_session_key']")
    private WebElement emailArea;

    public void sendEmail(String email){
        emailArea.sendKeys(email);
    }

    @FindBy(xpath = "//*[@class = 'text-color-text font-sans text-md outline-0 bg-color-transparent grow'][@id = 'public_profile_top-card_title-modal-id_sign-in-modal_session_password']")
    private WebElement passwordArea;

    public void sendPassword(String password){
        passwordArea.sendKeys(password);
    }

    @FindBy(xpath = "//*[@data-tracking-control-name = 'public_profile_contextual-sign-in-modal_sign-in-modal_sign-in-submit-btn']")
    private WebElement secondSignInBtn;

    public void clickSecondSignInBtn(){
        secondSignInBtn.click();
    }

    @FindBy(xpath = "//*[contains(text(), 'Please enter an email address or phone number')]")
    private WebElement emptyEmailError;

    public WebElement getEmptyEmailError(){
        return emptyEmailError;
    }

    @FindBy (xpath = "//*[contains (text(), 'Please enter a password')]")
    private WebElement emptyPasswordError;

    public WebElement getEmptyPasswordError(){
        return emptyPasswordError;
    }

    @FindBy (xpath = "//*[contains (text(), 'The password you provided must have at least 6 characters')]")
    private WebElement incorrectPasswordError;

    public WebElement getIncorrectPasswordError(){
        return incorrectPasswordError;
    }

    public void signInForm(String email, String password, String errorMessage) throws Exception {
        sendEmail(email);
        sendPassword(password);
        clickSecondSignInBtn();
        Thread.sleep(2000);
        if (errorMessage.equals("Please enter an email address or phone number")) {
            assertEquals(getEmptyEmailError().getText(), errorMessage);
        } else if (errorMessage.equals("Please enter a password")) {
            assertEquals(getEmptyPasswordError().getText(), errorMessage);
        } else if (errorMessage.equals("The password you provided must have at least 6 characters")) {
            assertEquals(getIncorrectPasswordError().getText(), errorMessage);
        } else {
            throw new Exception("Unknown error message");
        }
    }
}
