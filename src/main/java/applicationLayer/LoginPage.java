package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	
	@FindBy(xpath="//input[@class='_3704LK']")
	WebElement searchBar;
	@FindBy(xpath="//button[@class='L0Z3Pu']")
	WebElement searchButton;
	@FindBy(xpath="//a[contains(.,'APPLE iPhone 11 (White, 64 GB)')]")
	WebElement appleProduct;
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	WebElement windowPopUp;
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	public void searchAppleProduct(String productName) {
		
		elementControl.click(windowPopUp);
		elementControl.click(searchBar);
		elementControl.sendKeys(searchBar, productName);
		elementControl.click(searchButton);
		elementControl.click(appleProduct);
	}
	
}
