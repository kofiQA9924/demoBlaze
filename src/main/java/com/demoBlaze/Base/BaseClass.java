package com.demoBlaze.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by RUTHERFORD on 5/22/2021.
 */
public class BaseClass {
    public static Properties properties;
    public static FileInputStream fileInputStream;
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Logger logger;

    public BaseClass() throws FileNotFoundException {
        logger=Logger.getLogger("DemoBlaze");
        try {
            properties=new Properties();
            fileInputStream=new FileInputStream("Configuration/Configuration.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initializaton(){
        String browserName =properties.getProperty("browser");
        if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
            driver=new ChromeDriver();
        }
        else if (browserName.equals("msedge")){
            System.setProperty("webdriver.msedge.driver","Drivers/msedgedriver.exe");
            driver=new EdgeDriver();
        }
        else if (browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","Drivers/geckodriver.exe");
            driver=new FirefoxDriver();
        }
        else {
            System.out.println("Browser not supported");
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
    }
}
// add some comments
/*
Additional comments
*/