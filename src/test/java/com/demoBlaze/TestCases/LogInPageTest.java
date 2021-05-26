package com.demoBlaze.TestCases;

import com.demoBlaze.Base.BaseClass;
import com.demoBlaze.Pages.LogInPage;
import com.demoBlaze.Pages.SignUpPage;
import com.demoBlaze.Utilities.Reporting;
import com.google.common.base.Verify;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

/**
 * Created by RUTHERFORD on 5/22/2021.
 */
@Listeners({Reporting.class})
public class LogInPageTest extends BaseClass {
    public static LogInPage logInPage;
    public static SignUpPage signUpPage;

    public LogInPageTest() throws FileNotFoundException {
        super();
    }
    @BeforeTest(alwaysRun = true)
    public void setUpLogInPage() throws FileNotFoundException, InterruptedException {
        initializaton();
        logInPage=new LogInPage(driver);
        signUpPage=new SignUpPage(driver);
        signUpPage.setSignUpbutton();
        signUpPage.setUsernameField(properties.getProperty("username"));
        signUpPage.setPasswordField(properties.getProperty("password"));
        signUpPage.setConfirmSignUp();
    }
    @Test(priority = 0)
    public void testLoginButton(){
        logInPage.setLoginButton();
        logger.info("Log in button clicked");
    }
    @Test(priority = 1)
    public void testLoginUsername(){
        logInPage.setLoginUsername(properties.getProperty("username"));
        Verify.verify(true);
        logger.info("Username entered");
    }
    @Test(priority = 2)
    public void testLoginPassword(){
        logInPage.setLoginPassword(properties.getProperty("password"));
        logger.info("Password entered");
    }
    @Test(priority = 3)
    public void testLoginLogin(){
        logInPage.setLoginLogin();
        logger.info("Login clicked");
    }
}
