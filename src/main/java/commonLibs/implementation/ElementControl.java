package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementControl {
	
WebDriver driver;

	public ElementControl(WebDriver driver) {
		this.driver=driver;
	}
	
	public void sendKeys(WebElement element,String text) {
		element.sendKeys(text);
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void cancelWindowPopUp(WebElement element) {
		element.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
