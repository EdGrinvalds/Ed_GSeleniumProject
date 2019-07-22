package pkgSeleniumCoursePart9.CaseStudyPart9;

import org.testng.Assert;

import pkgSeleniumCoursePart9.CaseStudyPart9.utilities.WaitForPageLoadComplete;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class edurekaHomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	WaitForPageLoadComplete waitJScriptComplete;
	
	//Constructor
	public edurekaHomePage(WebDriver driver, WebDriverWait wait, WaitForPageLoadComplete waitJScriptComplete) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		this.wait=wait;
		this.waitJScriptComplete = waitJScriptComplete;
		
	}
	
	
	@FindBy(xpath = "//a[text()='Log In']")
	WebElement LogInLocator;
	
	@FindBy(xpath = "//form[@action='/users/signin']//following::input[1]")
	//@FindBy(id = "si_popup_email")
	WebElement EmailLocator;
	
	@FindBy(xpath = "//form[@action='/users/signin']//following::input[2]")
	WebElement PasswordLocator;
	
	@FindBy(xpath = "//*[@id='si_popup_passwd']//following::button[1]")
	WebElement SignInClickLocator;
	
	@FindBy(xpath = "//*[@id='dropdownMenu4']")
	WebElement BlogDropDownLocator;
	
	@FindBy(xpath = "//*[@data-button-name='Community Blog']")
	WebElement CommunityBlogMenuItemLocator;

	@FindBy(xpath = "//button[contains(text(),'No thanks') and @id='wzrk-cancel']")
	WebElement ModalDialogNoThansBtnLocator;
	
	@FindBy(xpath = "//span[contains(text(), 'Tset')]")
	WebElement LoginFirstNameLocator;
	
	
	public void Login(String email, String password) throws Exception {

		LogInLocator.click();

		// NOTE1. These 3 commented out statements will also work instead of using
		// the TestNG EmailLocator.sendkeys(email) statement below.
		//waitJScriptComplete.waitForLoad(driver);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='si_popup_email']"))).click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='si_popup_email']"))).sendKeys(email);

		EmailLocator.sendKeys(email);
		
		//Validate email string entered correctly.
		String emailCompare = EmailLocator.getAttribute("value");
		boolean emailInputValidation = email.equals(emailCompare);
		//System.out.println(email);
		//System.out.println(emailCompare);
		//System.out.println(emailInputValidation + "\n");
		if( ! emailInputValidation ) {
			Assert.fail("Email string expected: " + email + " did not match actual: " + emailCompare);
		}
		
		PasswordLocator.click();
		
		PasswordLocator.sendKeys(password);
		//Validate password string entered correctly.
		String passwordCompare = PasswordLocator.getAttribute("value");
		boolean passwordInputValidation = password.equals(passwordCompare);
		//System.out.println(password);
		//System.out.println(passwordCompare);
		//System.out.println(passwordInputValidation + "\n");
		if( ! passwordInputValidation ) {
			Assert.fail("Password string expected: " + password + " did not match actual: " + passwordCompare);
		}
		
		SignInClickLocator.click();
		
		// If the user's first name not displayed in top menu, login failed and this check will make test fail.
		LoginFirstNameLocator.isDisplayed();

	}
	
	
	public void NavigateToBlogs() throws Exception {
		
		BlogDropDownLocator.click();
		
		CommunityBlogMenuItemLocator.click();
		
		// Edureka site puts blogs page into a new tab so...
		// Switch to tab with blogs.
		ArrayList<String> arrWindowshandlesList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(arrWindowshandlesList.get(1));
		
		// Currently Edureka site pops up a dialog up immediately on the blogs tab that is modal
		// and must be closed before having access to blogs page.
		ModalDialogNoThansBtnLocator.click();	
		
	}

}
