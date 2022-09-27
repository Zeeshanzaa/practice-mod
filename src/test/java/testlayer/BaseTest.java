package testlayer;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;

import applicationLayer.LoginPage;
import commonLibs.implementation.CommonDriver;
import commonLibs.utility.ConfigUtil;
import commonLibs.utility.ReportUtil;
import commonLibs.utility.ScreenShotUtil;

public class BaseTest {
	
String currentWorkingDirectory;
String configFileName;
Properties configProperty;
String htmlreportFileName;
ReportUtil reportUtil;
String browserUrl;
String browser;
CommonDriver commonDriver;
WebDriver driver;
LoginPage loginPage;
ScreenShotUtil screenShotUtil;
String testCaseName;
String executionTime;
String screenShotFileName;

	@BeforeSuite
	public void preSetUp() throws IOException {
		
		currentWorkingDirectory=System.getProperty("user.dir");
		
		configFileName = currentWorkingDirectory + "/config/config.properties";
		
		configProperty=ConfigUtil.readProperties(configFileName);
		
		htmlreportFileName=currentWorkingDirectory + "/extentreports/flipKart.html";
		
		reportUtil = new ReportUtil(htmlreportFileName);
	}

	@BeforeClass
	public void setUp() throws Exception {
		
		browserUrl=configProperty.getProperty("browserUrl");
		
		browser=configProperty.getProperty("browser");
		
		commonDriver = new CommonDriver(browser);
		
		driver=commonDriver.getDriver();
		
		loginPage = new LoginPage(driver);
		
		screenShotUtil = new ScreenShotUtil(driver);
		
		commonDriver.navigatToUrl(browserUrl);
		
		
		
		
	}
	
	@AfterMethod
	public void postTestTation(ITestResult result) throws Exception {
		
		testCaseName=result.getName();
		
		long executionTime=System.currentTimeMillis();
		
		screenShotFileName=currentWorkingDirectory + "/screenshot/" + testCaseName + executionTime + ".jpeg";
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			reportUtil.addLogs(Status.FAIL, "one or more steps failed");
			screenShotUtil.captureAndTakeScreenShot(screenShotFileName);
			reportUtil.attachScreenShot(screenShotFileName);
		}
		
	}
	
	@AfterClass
	public void tearDown() {
	commonDriver.closeAllBrowsers();	
	}
	
	@AfterSuite
	public void postTearDown() {
		reportUtil.flushReports();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
