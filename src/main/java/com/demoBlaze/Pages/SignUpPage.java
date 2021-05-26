package com.demoBlaze.Pages;

import com.demoBlaze.Base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

/**
 * Created by RUTHERFORD on 5/22/2021.
 */
public class SignUpPage extends BaseClass {
    public SignUpPage(WebDriver driver) throws FileNotFoundException {
        PageFactory.initElements(BaseClass.driver,this);
    }

    @FindBy(xpath = "//*[@id='signin2']")
    @CacheLookup
    WebElement SignUpbutton;

    @FindBy(xpath = "//*[@id='sign-username']")
    @CacheLookup
    WebElement usernameField;

    @FindBy(xpath = "//*[@id='sign-password']")
    @CacheLookup
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
    @CacheLookup
    WebElement ConfirmSignUp;

    public void setSignUpbutton(){
        SignUpbutton.click();
    }
    public void setUsernameField(String uname) throws InterruptedException {
        usernameField.sendKeys(uname);
        Thread.sleep(3000);
    }
    public void setPasswordField(String pwd){
        passwordField.sendKeys(pwd);
    }
    public void setConfirmSignUp() throws InterruptedException {
        ConfirmSignUp.click();
        Thread.sleep(3000);
        Alert ok=driver.switchTo().alert();
        ok.accept();
    }
}
