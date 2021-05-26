package com.demoBlaze.TestCases;

import com.demoBlaze.Base.BaseClass;
import com.demoBlaze.Pages.CartPage;
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
 * Created by RUTHERFORD on 5/24/2021.
 */
@Listeners({Reporting.class})
public class CartPageTest extends BaseClass {
    public static LogInPage logInPage;
    public static ShoppingPage shoppingPage;
    public static SignUpPage signUpPage;
    public static CartPage cartPage;

    public CartPageTest() throws FileNotFoundException {
        super();
    }

    @BeforeTest
    public void setUpCart() throws FileNotFoundException, InterruptedException {
        initializaton();
        signUpPage=new SignUpPage(driver);
        logInPage=new LogInPage(driver);
        shoppingPage=new ShoppingPage(driver);
        cartPage=new CartPage(driver);
        signUpPage.setSignUpbutton();
        signUpPage.setUsernameField(properties.getProperty("username"));
        signUpPage.setPasswordField(properties.getProperty("password"));
        signUpPage.setConfirmSignUp();
        logInPage.setLoginButton();
        logInPage.setLoginUsername(properties.getProperty("username"));
        logInPage.setLoginPassword(properties.getProperty("password"));
        logInPage.setLoginLogin();
        shoppingPage.setGlxys6();
        shoppingPage.setAddglxycart();
        shoppingPage.setShophome();
        shoppingPage.setNexus6();
        shoppingPage.setAddnexuscart();
        shoppingPage.sethome();
        shoppingPage.setNxtbutton();
        shoppingPage.setAsusMonitor();
        shoppingPage.setAddasuscart();
        shoppingPage.setCart();
    }
    @Test(priority = 0)
    public void testPlaceOrder() throws InterruptedException {
        cartPage.setPlaceOrder();
        Assert.assertTrue(true);
    }
    @Test(priority = 1)
    public void testOrderName() throws InterruptedException {
        cartPage.setOrderName(properties.getProperty("username"));
        logger.info("Order name entered");
    }
    @Test(priority = 2)
    public void testOrderCountry(){
        cartPage.setOrderCountry(properties.getProperty("country"));
        logger.info("Order country entered");
    }
    @Test(priority = 3)
    public void testOrderCity(){
        cartPage.setOrderCity(properties.getProperty("city"));
        logger.info("Order city entered");
    }
    @Test(priority = 4)
    public void testOrderCard() throws InterruptedException {
        cartPage.setOrderCard(properties.getProperty("card"));
    }
    @Test(priority = 5)
    public void testOrderMonth(){
        cartPage.setOrderMonth(properties.getProperty("month"));
    }
    @Test(priority = 6)
    public void testOrderYear(){
        cartPage.setOrderYear(properties.getProperty("year"));
    }
    @Test(priority = 7)
    public void testOrderPurchase() throws InterruptedException {
        cartPage.setOrderPurchase();
    }
    @Test(priority = 8)
    public void testOrderplaced() throws InterruptedException {
        cartPage.setOrderplaced();
    }
}
