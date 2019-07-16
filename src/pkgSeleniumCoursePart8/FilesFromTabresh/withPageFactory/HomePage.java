package pkgSeleniumCoursePart8.FilesFromTabresh.withPageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	// Constructor
	public HomePage(WebDriver driver)
	{
		// "this" keyword is used here to distinguish global and local varaible "driver"
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Locator for sign in button
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement btnSignIn;
	
	// Method to click on sign in button
	public void clickOnSignInButton()
	{
		btnSignIn.click();
	}
	
}