package com.crm.SalesAndInventorySystemProject.ListeneresUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.crm.SalesAndInventorySystemProject.BaseClassUtility.BaseClassUtilty;
import com.crm.SalesAndInventorySystemProject.WebDriverUtility.UtilityClassObject;

public class ListenerImplementationClass implements ITestListener,ISuiteListener
{

	public ExtentSparkReporter spark;
	public static ExtentTest test;
	public static ExtentReports report;//to use this report for every testcase make it as static
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report configuration");  
		
		String timeStamp1=new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report"+"-"+timeStamp1+".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);
		
		//add Environment info and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-11");
		report.setSystemInfo("Browser", "Chrome-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("=======>"+result.getMethod().getMethodName()+">=====START======");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"===> Started <===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=======>"+result.getMethod().getMethodName()+">=====END======");
		test.log(Status.PASS, result.getMethod().getMethodName()+"===> Completed <===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testCaseName= result.getMethod().getMethodName();
		//TakesScreenshot ts=(TakesScreenshot) UtilityClassObject.getDriver();
		TakesScreenshot ts=(TakesScreenshot) BaseClassUtilty.sdriver;
		
		//extend report uses Base64 file
		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		
		Date d=new Date();
		String timeStamp1=d.toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath,testCaseName+"_"+timeStamp1);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"===> Failed <===");
		
	}
 
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.INFO, result.getMethod().getMethodName()+"===> Skipped <===");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	


	
}
