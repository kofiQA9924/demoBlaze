package com.demoBlaze.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.demoBlaze.Base.BaseClass.driver;

/**
 * Created by RUTHERFORD on 5/24/2021.
 */
public class Reporting extends TestListenerAdapter {
    public static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static Capture capture;


    @Override
    public void onStart(ITestContext testContext) {
        extentHtmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Test-Output/"+System.currentTimeMillis()+"reports.html");
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setTheme(Theme.DARK);
        extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        extentHtmlReporter.config().setDocumentTitle("demoBlaze Reports");
        extentHtmlReporter.config().setReportName("demoBlaze Functional Test Report");
        extentReports.setSystemInfo("OS","Windows 10");
        extentReports.setSystemInfo("Hostname","LocalHost");
        extentReports.setSystemInfo("Engineering Dept.","QA Engineering");

    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        try {
            capture=new Capture(driver);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (tr.getStatus()==ITestResult.FAILURE){
            try {
                capture.Imaging();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Image not captured");
        }
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
    }

    @Override
    public void onFinish(ITestContext testContext) {
        System.out.println(testContext.getName());
        extentReports.flush();
    }
}
