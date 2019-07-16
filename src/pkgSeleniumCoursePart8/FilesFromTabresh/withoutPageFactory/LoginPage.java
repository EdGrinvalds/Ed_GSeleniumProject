package pkgSeleniumCoursePart8.FilesFromTabresh.withoutPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

WebDriver driver;
	
	// Constructor
	public LoginPage(WebDriver driver)
	{
		// "this" keyword is used here to distinguish global and local varaible "driver"
		this.driver=driver;
	}
	
	
	// Locator for sign in button
	By loc_emailAddress= By.id("email");
	By loc_password= By.id("passwd");
	By loc_signInButton= By.id("SubmitLogin");
	
	// Type email address
	public void typeEmailAddress(String emailAddress)
	{
		driver.findElement(loc_emailAddress).sendKeys(emailAddress);
	}
	
	// Type password
	public void typePassword(String password)
	{
		driver.findElement(loc_password).sendKeys(password);
	}
	
	// Click on sign in button
	public void clickOnSignInButton()
	{
		driver.findElement(loc_signInButton).click();
	}
	
	// Single method to sign in
	public void signIn(String emailAddress, String password)
	{
		typeEmailAddress(emailAddress);
		typePassword(password);
		clickOnSignInButton();
		
	}
}