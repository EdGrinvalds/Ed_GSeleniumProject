package pkgSeleniumCoursePart8.CaseStudyPart8.WithOutPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GoogleGmailHomePage {

	WebDriver driver;
	WebDriverWait wait;
	WaitForPageLoadCompleteCaseStudy8 waitJScriptComplete;
	
	// Constructor
	public GoogleGmailHomePage(WebDriver driver, WebDriverWait wait, WaitForPageLoadCompleteCaseStudy8 waitJScriptComplete)
	{
		// Create this class's local driver, wait, and waitJScriptComplete for use in methods.
		this.driver=driver;
		this.wait=wait;
		this.waitJScriptComplete=waitJScriptComplete;
	}
	
	// BUTTONS AND LINKS
	// Create variable of type By for a locator of the Google GMail Home page's "Sign in" button
	// and "Gmail" link.
	By locatorSignIn = By.xpath("//a[contains(text(),'Sign')]");
	By locatorGmail = By.xpath("//a[contains(text(),'Gmail')]");
	
	
	//METHODS
	// Method to click on sign in button.
	public void clickOnSignInButton()
	{
		//Does not work reliably. Need to implement explicit waits. Implicit again did not work either.
		//driver.findElement(locatorSignIn).click();
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorSignIn));
		wait.until(ExpectedConditions.elementToBeClickable(locatorSignIn)).click();
	}

	
	// Method to click on "Gmail" link.
	public void clickOnGmailButton()
	{
		//Does not work reliably. Need to implement explicit waits. Implicit again did not work either.
		//driver.findElement(locatorGmail).click();
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorGmail));
		wait.until(ExpectedConditions.elementToBeClickable(locatorGmail)).click();
	}	
	
}

