
package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonDriver {
	
private WebDriver driver;
private int pageLoadTimeout;
private int elementDetectionTimeout;

	public CommonDriver(String browser) throws Exception {
		
		pageLoadTimeout =20;
		elementDetectionTimeout=20;
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if (browser.equalsIgnoreCase("FF")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else {
		throw new Exception("invalid"+ browser);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	public void navigatToUrl(String browserUrl) {
		
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		driver.get(browserUrl);
	}
	public WebDriver getDriver() {
		return driver;
	}
	
	
	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}
	
	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
	
	public void closeAllBrowsers() {
		driver.quit();
	}
	public String getTitleOfPage() {
		return driver.getTitle();
	}
}
