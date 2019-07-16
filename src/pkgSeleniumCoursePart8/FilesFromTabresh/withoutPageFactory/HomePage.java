package pkgSeleniumCoursePart8.FilesFromTabresh.withoutPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	
	// Constructor
	public HomePage(WebDriver driver)
	{
		// "this" keyword is used here to distinguish global and local varaible "driver"
		this.driver=driver;
	}
	
	
	// Locator for sign in button
	By loc_signIn= By.xpath("//a[contains(text(),'Sign in')]");
	
	// Method to click on sign in button
	public void clickOnSignInButton()
	{
		driver.findElement(loc_signIn).click();
	}
	
}