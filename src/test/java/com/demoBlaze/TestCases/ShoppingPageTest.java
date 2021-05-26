package com.demoBlaze.TestCases;

import com.demoBlaze.Base.BaseClass;
import com.demoBlaze.Pages.LogInPage;
import com.demoBlaze.Pages.ShoppingPage;
import com.demoBlaze.Pages.SignUpPage;
import com.demoBlaze.Utilities.Reporting;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

/**
 * Created by RUTHERFORD on 5/23/2021.
 */
@Listeners({Reporting.class})
public class ShoppingPageTest extends BaseClass {
    public static LogInPage logInPage;
    public static ShoppingPage shoppingPage;
    public static SignUpPage signUpPage;

    public ShoppingPageTest() throws FileNotFoundException {
        super();
    }
    @BeforeTest
    public void setUpShopTest() throws FileNotFoundException, InterruptedException {
        initializaton();
        logInPage=new LogInPage(driver);
        shoppingPage=new ShoppingPage(driver);
        signUpPage=new SignUpPage(driver);
        signUpPage.setSignUpbutton();
        signUpPage.setUsernameField(properties.getProperty("username"));
        signUpPage.setPasswordField(properties.getProperty("password"));
        signUpPage.setConfirmSignUp();
        logInPage.setLoginButton();
        logInPage.setLoginUsername(properties.getProperty("username"));
        logInPage.setLoginPassword(properties.getProperty("password"));
        logInPage.setLoginLogin();
    }
    @Test(priority = 0)
    public void testGlxys6() throws InterruptedException {
        shoppingPage.setGlxys6();
        Assert.assertTrue(true);
        logger.info("Galaxy clicked");
    }
    @Test(priority = 1)
    public void testAddgxlycart() throws InterruptedException {
        shoppingPage.setAddglxycart();
        Assert.assertTrue(true,"Galaxy added to cart");
        logger.info("logger added to cart");
    }
    @Test(priority = 2)
    public void testShophome() throws InterruptedException {
        shoppingPage.setShophome();
        Assert.assertTrue(true);
        logger.info("Navigated to Shop page");
    }
    @Test(priority = 3)
    public void testNexus6() throws InterruptedException {
        shoppingPage.setNexus6();
        Assert.assertTrue(true,"Nexus 6 selected");
        logger.info("Nexus 6 is selected");
    }
    @Test(priority = 4)
    public void testAddnexuscart() throws InterruptedException {
        shoppingPage.setAddnexuscart();
        Assert.assertTrue(true);
        logger.info("nexus 6 added to cart");
    }
    @Test(priority = 5)
    public void testhome() throws InterruptedException {
        shoppingPage.sethome();
        Assert.assertTrue(true,"Navigated to Shopping Page");
        logger.info("Shop page opened");
    }
    @Test(priority = 6)
    public void testNxtbutton() throws InterruptedException {
        shoppingPage.setNxtbutton();
        Assert.assertTrue(true);
        logger.info("Next button clicked");
    }
    @Test(priority = 7)
    public void testAsusMonitor() throws InterruptedException {
        shoppingPage.setAsusMonitor();
        Assert.assertTrue(true);
        logger.info("Asus Monitor clicked");
    }
    @Test(priority = 8)
    public void testAddasuscart() throws InterruptedException {
        shoppingPage.setAddasuscart();
        Assert.assertTrue(true,"Asus added to cart");
        logger.info("Asus Monitor added to cart");
    }
    @Test(priority = 9)
    public void testCart() throws InterruptedException {
        shoppingPage.setCart();
        Assert.assertTrue(true,"Cart page opened");
        logger.info("Cart opened");
    }
}
