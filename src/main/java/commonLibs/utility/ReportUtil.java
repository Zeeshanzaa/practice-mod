package commonLibs.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportUtil {
	
ExtentHtmlReporter reporter;

	ExtentReports extent;
	
	ExtentTest extentTest;
	
	public ReportUtil(String htmlreportFileName) {
		
		htmlreportFileName=htmlreportFileName.trim();
		
		reporter = new ExtentHtmlReporter(htmlreportFileName);
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		}
	public void createTestCaseName(String testCaseName) {
		extentTest=extent.createTest(testCaseName);
	}
	public void addLogs(Status status,String comment) {
		extentTest.log(status, comment);
	}
	public void attachScreenShot(String filename) throws IOException {
		extentTest.addScreenCaptureFromPath(filename);
	}
	public void flushReports() {
		extent.flush();
	}
}
