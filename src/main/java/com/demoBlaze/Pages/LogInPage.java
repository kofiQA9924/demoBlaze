package com.demoBlaze.Pages;

import com.demoBlaze.Base.BaseClass;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

/**
 * Created by RUTHERFORD on 5/22/2021.
 */
public class LogInPage extends BaseClass {
    public LogInPage(WebDriver driver) throws FileNotFoundException {
        PageFactory.initElements(BaseClass.driver,this);
    }

    @FindBy(xpath = "//*[@id=\"login2\"]")
    @CacheLookup
    WebElement LoginButton;

    @FindBy(xpath = "//*[@id='loginusername']")
    @CacheLookup
    WebElement LoginUsername;

    @FindBy(xpath = "//*[@id='loginpassword']")
    @CacheLookup
    WebElement LoginPassword;

    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
    @CacheLookup
    WebElement LoginLogin;

    @FindBy(xpath = "//*[@id=\"cat\"]")
    @CacheLookup
    WebElement CategoriesElement;

    public void setLoginButton(){
        LoginButton.click();
    }
    public void setLoginUsername(String Loguname){
        LoginUsername.sendKeys(Loguname);
    }
    public void setLoginPassword(String Logpswd){
        LoginPassword.sendKeys(Logpswd);
    }
    public void setLoginLogin(){
        LoginLogin.click();
        String txt=CategoriesElement.getText();
        if (txt.equals("CATEGORIES")){
            System.out.println(properties.getProperty("username")+" successfully logged in.");
        }
        else {
            System.out.println(properties.getProperty("username")+" login failed.");
        }
    }

}
