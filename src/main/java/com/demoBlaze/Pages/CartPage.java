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
 * Created by RUTHERFORD on 5/24/2021.
 */
public class CartPage extends BaseClass {
    public CartPage(WebDriver driver) throws FileNotFoundException {
        PageFactory.initElements(BaseClass.driver,this);
    }

    @FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[2]/button")
    @CacheLookup
    WebElement placeOrder;

    @FindBy(xpath = "//*[@id='name']")
    @CacheLookup
    WebElement orderName;

    @FindBy(xpath = "//*[@id='country']")
    @CacheLookup
    WebElement orderCountry;

    @FindBy(xpath = "//*[@id='city']")
    @CacheLookup
    WebElement orderCity;

    @FindBy(xpath = "//*[@id='card']")
    @CacheLookup
    WebElement orderCard;

    @FindBy(xpath = "//*[@id='month']")
    @CacheLookup
    WebElement orderMonth;

    @FindBy(xpath = "//*[@id='year']")
    @CacheLookup
    WebElement orderYear;

    @FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
    @CacheLookup
    WebElement orderPurchase;

    @FindBy(xpath = "/html/body/div[10]/h2")
    @CacheLookup
    WebElement verifyMsg;

    @FindBy(xpath = "/html/body/div[10]/div[7]/div/button")
    @CacheLookup
    WebElement orderplaced;

    public void setPlaceOrder() throws InterruptedException {
        Thread.sleep(3000);
        placeOrder.click();
    }
    public void setOrderName(String oname) throws InterruptedException {
        Thread.sleep(3000);
        orderName.sendKeys(oname);
    }
    public void setOrderCountry(String ocountry){
        orderCountry.sendKeys(ocountry);
    }
    public void setOrderCity(String ocity){
        orderCity.sendKeys(ocity);
    }
    public void setOrderCard(String ocard) throws InterruptedException {
        Thread.sleep(3000);
        orderCard.sendKeys(ocard);
    }
    public void setOrderMonth(String omonth){
        orderMonth.sendKeys(omonth);
    }
    public void setOrderYear(String oyear){
        orderYear.sendKeys(oyear);
    }
    public void setOrderPurchase() throws InterruptedException {
        orderPurchase.click();
        Thread.sleep(10000);
        String doneMsg=verifyMsg.getText();
        if (doneMsg.equals("Thank you for your purchase!")){
            System.out.println("Order successfully placed");
        }
        else {
            System.out.println("Order not placed");
        }
    }
    public void setOrderplaced() throws InterruptedException {
        Thread.sleep(3000);
        orderplaced.click();
    }
}
