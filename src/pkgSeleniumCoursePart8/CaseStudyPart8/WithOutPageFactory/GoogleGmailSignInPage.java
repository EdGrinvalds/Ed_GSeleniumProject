package pkgSeleniumCoursePart8.CaseStudyPart8.WithOutPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleGmailSignInPage {

	WebDriver driver;
	WebDriverWait wait;
	WaitForPageLoadCompleteCaseStudy8 waitJScriptComplete;
	
	// Constructor
	public GoogleGmailSignInPage(WebDriver driver, WebDriverWait wait, WaitForPageLoadCompleteCaseStudy8 waitJScriptComplete)
	{
		// Create this class's local driver, wait, and waitJScriptComplete for use in methods.
		this.driver=driver;
		this.wait=wait;
		this.waitJScriptComplete=waitJScriptComplete;
	}
	
	// FIELDS AND BUTTONS
	// Locators for various fields and buttons needed to sign into a GMail account.
	By locatorGMailEmailAddress = By.id("identifierId");
	By locatorGmailPassword = By.name("password");
	By locatorGmailNextButtonOnEmailAddress = By.id("identifierNext");
	By locatorGmailNextButtonOnPassword = By.id("passwordNext");
	By locatorGmailNextButtonOnAccountRecovery = By.linkText("Done");
	
	
	// METHODS
	// For performing actions on GMail Sign in page.
	
	// Type email address
	public void typeGmailAddress(String gmailAddress)
	{
		//driver.findElement(locatorGMailEmailAddress).sendKeys(gmailAddress);
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorGMailEmailAddress)).sendKeys(gmailAddress);
	}
	
	// Type password
	public void typePassword(String password)
	{
		//Does not work reliably. Need to implement explicit waits. Implicit again did not work either.
		//driver.findElement(locatorGmailPassword).sendKeys(password);
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorGmailPassword)).sendKeys(password);		
	}
	
	// Click on Next button after entering GMail address.
	public void clickOnGmailAddressNextButton()
	{
		//Does not work reliably. Need to implement explicit waits. Implicit again did not work either.
		//driver.findElement(locatorGmailNextButtonOnEmailAddress).click();
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorGmailNextButtonOnEmailAddress));
		wait.until(ExpectedConditions.elementToBeClickable(locatorGmailNextButtonOnEmailAddress)).click();
	}
	
	// Click on Next button after entering password.
	public void clickOnGmailPasswordNextButton() throws InterruptedException
	{
		//Does not work reliably. Need to implement explicit waits. Implicit again did not work either.
		//driver.findElement(locatorGmailNextButtonOnPassword).click();
		Thread.sleep(1000);
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorGmailNextButtonOnPassword));
		wait.until(ExpectedConditions.elementToBeClickable(locatorGmailNextButtonOnPassword)).click();
	}
	
	// Click on Done button on Account Recovery setup.
	public void clickOnGmailAccountRevcoveryDoneButton()
	{
		//Does not work reliably. Need to implement explicit waits. Implicit again did not work either.
		//driver.findElement(locatorGmailNextButtonOnAccountRecovery).click();
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorGmailNextButtonOnAccountRecovery));
		wait.until(ExpectedConditions.elementToBeClickable(locatorGmailNextButtonOnAccountRecovery)).click();
	}
	
	// Single method to sign in
	public void signIn(String gmailAddress, String password) throws InterruptedException
	{
		typeGmailAddress(gmailAddress);
		clickOnGmailAddressNextButton();
		typePassword(password);
		clickOnGmailPasswordNextButton();
		
		//Next method call no longer needed. Commented out. After clicking on the Done button a few times,
		//Google does not preset the Account Recovery any more.
		//I setup a new account on GMail for this case study and it prompted me 3 times before stopping the presentation
		//of new account setup to setup account recovery.
		//clickOnGmailAccountRevcoveryDoneButton();
	}
}




