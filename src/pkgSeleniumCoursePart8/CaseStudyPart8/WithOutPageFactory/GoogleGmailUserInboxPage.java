package pkgSeleniumCoursePart8.CaseStudyPart8.WithOutPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		this.wait=wait;
		this.waitJScriptComplete=waitJScriptComplete;
	}
	
	// FIELDS AND BUTTONS
	// Locators for various fields and buttons needed to interact in a user's GMail inbox.
	By locatorComposeButton = By.xpath("//*[contains(text(), 'Compose')]");
	By locatorEmailToRecipient = By.xpath("//textarea[@name='to']");
	By locatorEmailSubjectTextBox = By.xpath("//input[@name='subjectbox']");
	By locatorEmailMessageBody = By.xpath("//*[contains(concat(' ', normalize-space(@aria-label), ' '),' Message Body ') and @role='textbox']");
	By locatorEmailSendButton = By.xpath("//*[@aria-label='Send ‪(Ctrl-Enter)‬']");
	By locatorGmailAccountButton = By.xpath("//*[contains(concat(' ', normalize-space(@aria-label), ' '),' Google Account: gnitset.ekaf@gmail.com ')]");
	By locatorGmailAccountSignOutButton = By.xpath("//a[contains(text(), 'Sign out')]");
	
	
	// METHODS
	// For performing actions on in a user's GMail inbox.
	
	// Click on Compose button.
	public void clickOnGmailUserInboxComposeButton()
	{
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorComposeButton));
		wait.until(ExpectedConditions.elementToBeClickable(locatorComposeButton)).click();
	}
	
	public void typeToRecipient(String recipient)
	{
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorEmailToRecipient)).sendKeys(recipient);	
	}
	
	public void typeSubjectLine(String subject)
	{
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorEmailSubjectTextBox)).sendKeys(subject);	
	}
	
	public void typeMessageBody(String message)
	{
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorEmailMessageBody)).sendKeys(message);	
	}
	
	public void clickOnGmailMessageSendButton()
	{
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorEmailSendButton));
		wait.until(ExpectedConditions.elementToBeClickable(locatorEmailSendButton)).click();
	}
	
	public void clickOnGmailAccountButton()
	{
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorGmailAccountButton));
		wait.until(ExpectedConditions.elementToBeClickable(locatorGmailAccountButton)).click();
	}
	
	public void clickOnGmailAccountSignOutButton()
	{
		waitJScriptComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorGmailAccountSignOutButton));
		wait.until(ExpectedConditions.elementToBeClickable(locatorGmailAccountSignOutButton)).click();
	}	
	
}
