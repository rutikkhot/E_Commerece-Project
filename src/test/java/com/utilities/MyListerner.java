package com.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListerner implements ITestListener {

	private static final Logger logger = LogManager.getLogger(MyListerner.class);
	private static ExtentReports reports = MyReport.getInstance();
	
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test cases Execution is started= "+result.getName());
		ExtentTest test = reports.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test cases is pass= "+result.getName());
		extentTest.get().log(Status.PASS,"This test case is pass= "+result.getName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test cases is failed= "+result.getName());
		extentTest.get().log(Status.FAIL, "This test case got failed= "+result.getName());
		String addscrenshot=Takescreenshot.takeScreenShot(result.getName());
		extentTest.get().addScreenCaptureFromPath(addscrenshot);
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test cases is skipped= "+result.getName());
	}
	@Override
	public void onStart(ITestContext context) {
		logger.info("test suite execution started");
		
	}
	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test suite execution is completed");
		reports.flush();
	}
	
	
}
