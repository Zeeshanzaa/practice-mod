package testlayer;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTest extends BaseTest {

	
	
		@Parameters({"productName"})
		@Test
		public void toVerifySearchAppleProduct(String productName) {
			
			reportUtil.createTestCaseName("to Verify Search Apple Product");
			
			reportUtil.addLogs(Status.INFO, "perform searching");
			
			loginPage.searchAppleProduct(productName);
			
			Set<String> handler = driver.getWindowHandles();
			
			Iterator<String> it = handler.iterator();
			
			String ParentWindowId = it.next();
			
			String childWindowId1 = it.next();
			
			driver.switchTo().window(childWindowId1);
			
			String actualTitle=commonDriver.getTitleOfPage();
			String expectedTitle="APPLE iPhone 11 ( 64 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com";
			
			

			reportUtil.addLogs(Status.INFO, "comparing expected title vs actual title");
			
			Assert.assertEquals(actualTitle, expectedTitle);
			System.out.print(actualTitle);
			
			
		}
		
		
		
		
		
	
	
	
	
	
}
