package com.demoBlaze.Pages;

import com.demoBlaze.Base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileNotFoundException;

/**
 * Created by RUTHERFORD on 5/22/2021.
 */
public class ShoppingPage extends BaseClass {
    public ShoppingPage(WebDriver driver) throws FileNotFoundException {
        PageFactory.initElements(BaseClass.driver,this);
    }

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")
    @CacheLookup
    WebElement glxys6;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    @CacheLookup
    WebElement addglxycart;

    @FindBy(xpath = "//*[@id=\"nava\"]")
    @CacheLookup
    WebElement shophome;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a")
    @CacheLookup
    WebElement nexus6;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    @CacheLookup
    WebElement addnexuscart;

    @FindBy(xpath = "//*[@id=\"nava\"]")
    @CacheLookup
    WebElement nexushome;

    @FindBy(xpath = "//*[@id=\"next2\"]")
    @CacheLookup
    WebElement nxtbutton;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[5]/div/div/h4/a")
    @CacheLookup
    WebElement asusMonitor;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    @CacheLookup
    WebElement addasuscart;

    @FindBy(xpath = "//*[@id='navbarExample']/ul/li[4]/a")
    @CacheLookup
    WebElement cart;

    @FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[1]/h2")
    @CacheLookup
    WebElement ProductsPresent;

    public void setGlxys6() throws InterruptedException {
        Thread.sleep(5000);
        glxys6.click();
    }
    public void setAddglxycart() throws InterruptedException {
        Thread.sleep(3000);
        addglxycart.click();
        Thread.sleep(3000);
        Alert okglxy=driver.switchTo().alert();
        okglxy.accept();
    }
    public void setShophome() throws InterruptedException {
        Thread.sleep(5000);
        shophome.click();
    }
    public void setNexus6() throws InterruptedException {
        Thread.sleep(3000);
        nexus6.click();
    }
    public void setAddnexuscart() throws InterruptedException {
        Thread.sleep(5000);
        addnexuscart.click();
        Thread.sleep(3000);
        Alert oknexus=driver.switchTo().alert();
        oknexus.accept();
    }
    public void sethome() throws InterruptedException {
        Thread.sleep(3000);
        nexushome.click();
    }
    public void setNxtbutton() throws InterruptedException {
        Thread.sleep(3000);
        nxtbutton.click();
    }
    public void setAsusMonitor() throws InterruptedException {
        Thread.sleep(3000);
        asusMonitor.click();
    }
    public void setAddasuscart() throws InterruptedException {
        Thread.sleep(5000);
        addasuscart.click();
        Thread.sleep(3000);
        Alert okasus=driver.switchTo().alert();
        okasus.accept();
    }
    public void setCart() throws InterruptedException {
        Thread.sleep(4000);
        cart.click();
        String prdtPrnst=ProductsPresent.getText();
        if (prdtPrnst.equals("Products")){
            System.out.println("Products successfully added to Cart");
        }
        else {
            System.out.println("Shopping cart empty");
        }
    }
}
