package applicationLayer;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.ElementControl;


public class BasePage {
	
	ElementControl elementControl;
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		
		this.driver=driver;
		elementControl = new ElementControl(driver);
		
	}
}
