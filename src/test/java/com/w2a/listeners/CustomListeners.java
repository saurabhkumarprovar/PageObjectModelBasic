package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.Page;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends Page implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		/*
		 * if (!(TestUtil.isTestRunnable("addCustomerTest", excel))) {
		 * 
		 * throw new SkipException("Skipping the test " +
		 * "addCustomerTest".toUpperCase() + " as the runmode is NO"); }
		 */
		 
	 test = rep.startTest(result.getName().toUpperCase());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS,result.getName().toUpperCase()+ " PASS");
		rep.endTest(test);
		rep.flush();

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("Test Case Failed");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed with exception : "+result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		rep.endTest(test);
		rep.flush();

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
