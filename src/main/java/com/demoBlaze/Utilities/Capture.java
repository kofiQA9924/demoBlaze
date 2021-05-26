package com.demoBlaze.Utilities;

import com.demoBlaze.Base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by RUTHERFORD on 5/23/2021.
 */
public class Capture extends BaseClass {
    public Capture(WebDriver driver) throws FileNotFoundException {
    }
    public void Imaging() throws IOException {
        File ImgFilesrc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ImgFilesrc,new File(System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+"shotimg"));
    }
}