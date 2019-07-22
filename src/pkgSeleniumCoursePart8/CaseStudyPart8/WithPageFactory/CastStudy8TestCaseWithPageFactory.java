package pkgSeleniumCoursePart8.CaseStudyPart8.WithPageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import pkgSeleniumCoursePart8.CaseStudyPart8.WithPageFactory.GoogleGmailHomePage;
import pkgSeleniumCoursePart8.CaseStudyPart8.WithPageFactory.GoogleGmailSignInPage;

public class CastStudy8TestCaseWithPageFactory {
	
	@FindBy(tagName="")
	private WebElement id;

	public static void main(String[] args) throws Exception {
		
		//***********
		//
		//SETUP
		//
		//***********
		//
		//Setup so Chrome launches incognito so browser history is not maintained producing autocomplete 
		//urls for navigations which may cause false positives test results.
		ChromeOptions optionsChrome = new ChromeOptions();
		optionsChrome.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, optionsChrome);
		
		//Launch incognito Chrome browser session and go to Google home page.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(capabilities);
		driver.get("https://www.google.com/");
		
		//Setup global timeout waits for this Case Study's test script.
		driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
		//Will use explicit waits. Do not mix implicit and explicit waits together. Reference: https://www.seleniumhq.org/docs/04_webdriver_advanced.jsp
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			
		//Maximize window
		driver.manage().window().maximize();
		
		//Initialize explicit waiter
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		//Initialize class for waiting for page to complete loading
		//This is a custom wait created since the Selenium provided driver.manage().timeouts().pageLoadTimeout(time, timeUnits)
		// setup above did not always appear to work as expected in certain situations.
		WaitForPageLoadCompleteCaseStudy8 waitJScriptComplete = new WaitForPageLoadCompleteCaseStudy8();
		
		
		//********************************************
		//
		// CASE STUDY TEST SCRIPT
		//
		// Case study's Introductory Paragraph and Steps and duplicated here exactly as given in Case Study for Module 8...
		//
		// Introductory Paragraph:
		//
		// Automate the Gmail webpage to login, send a mail and logout using page object model testing of selenium,
		// without Page factory.
		//
		// Repeat the same with page factory concept.
		//
		//
		// STEPS:
		//
		//********************************************
		
		//*****
		//
		// STEP 1. Login to the Gmail account
		//
		//*****
		
		// Creating object of GoogleGmailHomePage
		GoogleGmailHomePage homePage= new GoogleGmailHomePage(driver, wait, waitJScriptComplete);
		
		// Click on Google Home page's "Sign in" button
		homePage.clickOnSignInButton();
		
		// Creating an object of GoogleGmailSignInPage
		GoogleGmailSignInPage loginPage = new GoogleGmailSignInPage(driver, wait, waitJScriptComplete);
		
		// Sign in
		// NOTE1. See NOTE3 if the email account is changed (1st parameter in the loginPage.signIn call here).
		loginPage.signIn("gnitsetekaf@gmail.com", "gnitsetekaf1!");
		
		// After sign in complete, Google brings you back to home page
		// so click on the "Gmail" link.
		homePage.clickOnGmailButton();
		
		//*****
		//
		// STEP 2. Compose and send a mail
		//
		//*****
		
		// Creating an object of GoogleGmailSignInPage
		GoogleGmailUserInboxPage userInboxPage = new GoogleGmailUserInboxPage(driver, wait, waitJScriptComplete);
		
		// Compose and send email
		// NOTE2: Email is sent to the user setup for this Case Study 8 to confirm email and script runs.
		//        Put a breakpoint on the on the first line after the userInboxPage.clickOnGmailMessageSendButton()
		//        to prevent logout, and see the email sent in the inbox of this user with a Subject Line "Case Study 8 Test Email".
		userInboxPage.clickOnGmailUserInboxComposeButton();
		userInboxPage.typeToRecipient("gnitsetekaf@gmail.com");
		userInboxPage.typeSubjectLine("Case Study 8 Test Email - With Page Factory");
		userInboxPage.typeMessageBody("Eureka!");
		userInboxPage.clickOnGmailMessageSendButton();
		
		
		//*****
		//
		// STEP 3. Logout from Gmail
		//
		//*****
		
		// NOTE3. If the sign account is changed above and does not match the account setup for this Case Study 8,
		//        then you MUST change the locator locatorGmailAccountButton in the GoogleGmailUserInboxPage class.
		//        Yes, more code could have been written to use string manipulations to create a xpath with the correct
		//		  search string using the account login put into this test case script above at the loginPage.signIn(arg0, arg1) call.
		
		userInboxPage.clickOnGmailAccountButton();
		userInboxPage.clickOnGmailAccountSignOutButton();
		
		//***********
		//
		//CLEANUP
		//
		//***********
		
		//Exit opened browser sessions.
		driver.quit();
		
	}

}
