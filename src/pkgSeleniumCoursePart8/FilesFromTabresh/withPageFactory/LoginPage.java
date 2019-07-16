package pkgSeleniumCoursePart8.FilesFromTabresh.withPageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver;
	
	// Constructor
	public LoginPage(WebDriver driver)
	{
		// "this" keyword is used here to distinguish global and local varaible "driver"
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="email")
	WebElement txtEmailAddress;
	
	@FindBy(id="passwd")
	WebElement txtPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement btnSignin;
	
	// Type email address
	public void typeEmailAddress(String emailAddress)
	{
		txtEmailAddress.sendKeys(emailAddress);
	}
	
	// Type password
	public void typePassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	// Click on sign in button
	public void clickOnSignInButton()
	{
		btnSignin.click();
	}
	
	// Single method to sign in
	public void signIn(String emailAddress, String password)
	{
		typeEmailAddress(emailAddress);
		typePassword(password);
		clickOnSignInButton();
		
	}
}