package pkgSeleniumCoursePart8.CaseStudyPart8.WithPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleGmailUserInboxPage {
	
	WebDriver driver;
	WebDriverWait wait;
	WaitForPageLoadCompleteCaseStudy8 waitJScriptComplete;

	// Constructor
	public GoogleGmailUserInboxPage(WebDriver driver, WebDriverWait wait, WaitForPageLoadCompleteCaseStudy8 waitJScriptComplete)
	{
		// Create this class's local driver, wait, and waitJScriptComplete for use in methods.
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		this.wait=wait;
		this.waitJScriptComplete=waitJScriptComplete;
	}
	
	// FIELDS AND BUTTONS
	// Locators for various fields and buttons needed to interact in a user's GMail inbox.
	//By locatorComposeButton = By.xpath("//*[contains(text(), 'Compose')]");
	//By locatorEmailToRecipient = By.xpath("//textarea[@name='to']");
	//By locatorEmailSubjectTextBox = By.xpath("//input[@name='subjectbox']");
	//By locatorEmailMessageBody = By.xpath("//*[contains(concat(' ', normalize-space(@aria-label), ' '),' Message Body ') and @role='textbox']");
	//By locatorEmailSendButton = By.xpath("//*[@aria-label='Send ‪(Ctrl-Enter)‬']");
	//By locatorGmailAccountButton = By.xpath("//*[contains(concat(' ', normalize-space(@aria-label), ' '),' Google Account: gnitset.ekaf@gmail.com ')]");
	By locatorGmailAccountSignOutButton = By.xpath("//a[contains(text(), 'Sign out')]");
	
	@FindBy(xpath = "//*[contains(text(), 'Compose')]")
	WebElement btnComposeButton;
	
	@FindBy(xpath = "//textarea[@name='to']")
	WebElement txtEmailToRecipient;
	
	@FindBy(xpath = "//input[@name='subjectbox']")
	WebElement txtEmailSubjectTextBox;
	
	@FindBy(xpath = "//*[contains(concat(' ', normalize-space(@aria-label), ' '),' Message Body ') and @role='textbox']")
	WebElement txtEmailMessageBody;
	
	@FindBy(xpath = "//*[@aria-label='Send ‪(Ctrl-Enter)‬']")
	WebElement btnEmailSendButton;
	
	@FindBy(xpath = "//*[contains(concat(' ', normalize-space(@aria-label), ' '),' Google Account: gnitset.ekaf@gmail.com ')]")
	WebElement btnGmailAccountButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign out')]")
	WebElement btnGmailAccountSignOutButton;

	
	// METHODS
	// For performing actions on in a user's GMail inbox.
	
	// Click on Compose button.
	public void clickOnGmailUserInboxComposeButton()
	{
		//waitJScriptComplete.waitForLoad(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(locatorComposeButton));
		//wait.until(ExpectedConditions.elementToBeClickable(locatorComposeButton)).click();
		btnComposeButton.click();
	}
	
	public void typeToRecipient(String recipient)
	{
		//waitJScriptComplete.waitForLoad(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(locatorEmailToRecipient)).sendKeys(recipient);	
		txtEmailToRecipient.sendKeys(recipient);
	}
	
	public void typeSubjectLine(String subject)
	{
		//waitJScriptComplete.waitForLoad(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(locatorEmailSubjectTextBox)).sendKeys(subject);
		txtEmailSubjectTextBox.sendKeys(subject);
	}
	
	public void typeMessageBody(String message)
	{
		//waitJScriptComplete.waitForLoad(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(locatorEmailMessageBody)).sendKeys(message);
		txtEmailMessageBody.sendKeys("message");
	}
	
	public void clickOnGmailMessageSendButton()
	{
		//waitJScriptComplete.waitForLoad(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(locatorEmailSendButton));
		//wait.until(ExpectedConditions.elementToBeClickable(locatorEmailSendButton)).click();
		btnEmailSendButton.click();
	}
	
	public void clickOnGmailAccountButton()
	{
		//waitJScriptComplete.waitForLoad(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(locatorGmailAccountButton));
		//wait.until(ExpectedConditions.elementToBeClickable(locatorGmailAccountButton)).click();
		btnGmailAccountButton.click();
	}
	
	public void clickOnGmailAccountSignOutButton()
	{
		//waitJScriptComplete.waitForLoad(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(locatorGmailAccountSignOutButton));
		//wait.until(ExpectedConditions.elementToBeClickable(locatorGmailAccountSignOutButton)).click();
		btnGmailAccountSignOutButton.click();
	}	
	
}
