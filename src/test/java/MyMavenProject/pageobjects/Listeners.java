package MyMavenProject.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import MyMavenProject.resourses.ExtentReport;


public class Listeners implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReport.getReportObject();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		BaseTest BT = new BaseTest();
		test.fail(result.getThrowable());
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String filePath = null;
		try {
			filePath = BT.getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

//	@Override
//	public void onTestSkipped(ITestResult result) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//		// TODO Auto-generated method stub
//	}
//
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
//
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	protected void finalize() throws Throwable {
//		// TODO Auto-generated method stub
//	}

	

}
