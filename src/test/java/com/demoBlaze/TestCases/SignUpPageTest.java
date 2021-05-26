package com.demoBlaze.TestCases;

import com.demoBlaze.Base.BaseClass;
import com.demoBlaze.Pages.SignUpPage;
import com.demoBlaze.Utilities.Reporting;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

/**
 * Created by RUTHERFORD on 5/22/2021.
 */
@Listeners({Reporting.class})
public class SignUpPageTest extends BaseClass {
    public static SignUpPage signUpPage;

    public SignUpPageTest() throws FileNotFoundException {
        super();
    }
    @BeforeTest
    public void setUpSignTest() throws FileNotFoundException {
        initializaton();
        signUpPage=new SignUpPage(driver);
    }

    @Test(priority = 0)
    public void testSignButton(){
        signUpPage.setSignUpbutton();
        Assert.assertTrue(true);
        logger.info("Sign in button clicked");
    }
    @Test(priority = 1)
    public void testUsername() throws InterruptedException {
        signUpPage.setUsernameField(properties.getProperty("username"));
        logger.info("Username clicked");
    }
    @Test(priority = 2)
    public void testPassword(){
        signUpPage.setPasswordField(properties.getProperty("password"));
        logger.info("Password clicked");
    }
    @Test(priority = 3)
    public void testConfirmSignup() throws InterruptedException {
        signUpPage.setConfirmSignUp();
        logger.info("Sign up confirmed");
    }
}
