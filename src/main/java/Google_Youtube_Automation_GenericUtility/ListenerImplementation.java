package Google_Youtube_Automation_GenericUtility;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{

	
    WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+"------>Testscript excution started");
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS,methodName+"----->passed");
		Reporter.log(methodName+"----->testScript execution successfull");
		
	}

	public void onTestFailure(ITestResult result) {
		
//		String methodname=result.getMethod().getMethodName();
//		String failedScript=methodname+new JavaUtility().getSystemDate();
//		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
//		File src=edriver.getScreenshotAs(OutputType.FILE);
//		File dest=new File("./screenshotOBS/"+failedScript+".png");
//		try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		try {
//			String ssName=WebdriverUtility.getScreenshot(BaseClass.sdriver,result.getMethod().getMethodName());
//			test.addScreenCaptureFromPath("./Screenshot/"+ssName+".png");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		test.log(Status.FAIL,result.getThrowable().getMessage() );
//		Reporter.log("testscript execution failed",true);
		
		
		String ssname=result.getName();
		TakesScreenshot t=(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+ssname+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
		}
		
	}

	public void onTestSkipped(ITestResult result) {  
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"--skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("test execution skipped");
	}

	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("Automation-Practice");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Google_Youtube");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);report.setSystemInfo("Base-Browser","Chrome");
		report.attachReporter(htmlReport);report.setSystemInfo("OS ", "Windows");
		report.attachReporter(htmlReport);report.setSystemInfo("Base-URL", "https://www.youtube.com");
		report.attachReporter(htmlReport);report.setSystemInfo("Reporter-name", "Rajhans Mehta");
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	
}
