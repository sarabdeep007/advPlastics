package TestComponents;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getExtentReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	Logger logger = (Logger) LogManager.getLogger(Listeners.class);
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		logger.info(result.getMethod().getMethodName()+" TEST STARTED");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().getStatus();
		extentTest.get().log(Status.PASS, "Test PASSED");
		
		logger.info(result.getMethod().getMethodName()+" is PASSED");
		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		extentTest.get().getStatus();
		extentTest.get().fail(result.getThrowable());
		logger.info(result.getMethod().getMethodName()+ " FAILED");
		
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String screenShotPath = null;
		
		try {
			screenShotPath = getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentTest.get().addScreenCaptureFromPath(screenShotPath, result.getMethod().getMethodName());
		logger.info(result.getMethod().getMethodName() + "'s SCREENSHOT CAPTURED");
		 
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		logger.info(result.getMethod().getMethodName()+ " is SKIPPED");
	 
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		 
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		 
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		 extent.flush();
	}

}
