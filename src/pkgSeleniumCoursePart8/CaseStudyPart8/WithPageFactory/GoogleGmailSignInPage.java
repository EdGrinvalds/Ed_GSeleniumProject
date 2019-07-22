package pkgSeleniumCoursePart8.CaseStudyPart8.WithPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
		PageFactory.initElements(driver, this);
		
		this.wait=wait;
		this.waitJScriptComplete=waitJScriptComplete;
	}
	
	// FIELDS AND BUTTONS
	// Locators for various fields and buttons needed to sign into a GMail account.
	//By locatorGMailEmailAddress = By.id("identifierId");
	//By locatorGmailPassword = By.name("password");
	//By locatorGmailNextButtonOnEmailAddress = By.id("identifierNext");
	//By locatorGmailNextButtonOnPassword = By.id("passwordNext");
	//By locatorGmailNextButtonOnAccountRecovery = By.linkText("Done");
	
	@FindBy(id = "identifierId")
	WebElement txtGMailEmailAddress;
	
	@FindBy(name = "password")
	WebElement txtGmailPassword;
	
	@FindBy(id = "identifierNext")
	WebElement btnGmailNextButtonOnEmailAddress;
	
	@FindBy(id = "passwordNext")
	WebElement btnGmailNextButtonOnPassword;
	
	@FindBy(linkText = "Done")
	WebElement linkGmailNextButtonOnAccountRecovery;
	
	
	// METHODS
	// For performing actions on GMail Sign in page.
	
	// Type email address
	public void typeGmailAddress(String gmailAddress)
	{
		//waitJScriptComplete.waitForLoad(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(locatorGMailEmailAddress));
		txtGMailEmailAddress.sendKeys(gmailAddress);
	}
	
	// Type password
	public void typePassword(String password) throws InterruptedException
	{
		Thread.sleep(2000);
		waitJScriptComplete.waitForLoad(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(locatorGmailPassword));	
	    txtGmailPassword.sendKeys(password);

	}
	
	// Click on Next button after entering GMail address.
	public void clickOnGmailAddressNextButton() throws InterruptedException
	{

		//Thread.sleep(2000);
		waitJScriptComplete.waitForLoad(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(locatorGmailNextButtonOnEmailAddress));
		//wait.until(ExpectedConditions.elementToBeClickable(locatorGmailNextButtonOnEmailAddress));
		btnGmailNextButtonOnEmailAddress.click();
	}
	
	// Click on Next button after entering password.
	public void clickOnGmailPasswordNextButton() throws InterruptedException
	{

		//Thread.sleep(2000);
		waitJScriptComplete.waitForLoad(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(locatorGmailNextButtonOnPassword));
		//wait.until(ExpectedConditions.elementToBeClickable(locatorGmailNextButtonOnPassword));
		btnGmailNextButtonOnPassword.click();
	}
	
	// Click on Done button on Recovery setup.
	public void clickOnGmailAccountRevcoveryDoneButton()
	{
		//waitJScriptComplete.waitForLoad(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(locatorGmailNextButtonOnAccountRecovery));
		//wait.until(ExpectedConditions.elementToBeClickable(locatorGmailNextButtonOnAccountRecovery));
		linkGmailNextButtonOnAccountRecovery.click();
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




