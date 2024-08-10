package ServiceBox.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ServiceBOX.Resources.ExtentReportsTestNG;

//import org.testng.ITestListener;

public class listeners extends BaseTest implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtentReportsTestNG.getReportObject();
	//To Avoid concurrency when tests are executing parallelly
	//test should run as synchronised so ThreadLocal class is used
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal();// it ma
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//////ITestListener.super.onTestStart(result);
		
		//For retreiving testcase name and testcase method name (2 functions are used)
		test =extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//sets unique thread id like validation test runs means it will take that test 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		//It comes to fail case due to reason
		extentTest.get().fail(result.getThrowable());
		try {
			
			
			//Explanation : Gettestclass - means take the class name from xml file.
			//getRealclass: it goes to the respective java class and take the driver name
			//getfield: it gives field in respective class
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String filePath = null;
		try {
			filePath = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromBase64String(filePath, result.getMethod().getMethodName());
		//Screenshot and Attach to Report
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}

}
