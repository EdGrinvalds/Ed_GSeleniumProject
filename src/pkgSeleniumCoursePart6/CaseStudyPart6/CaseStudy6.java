package pkgSeleniumCoursePart6.CaseStudyPart6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CaseStudy6 {
	
	//********************************************
	//
	// CASE STUDY TEST SCRIPT
	//
	// Case study's Introductory Paragraph and Steps and duplicated here exactly as given in Case Study for Module 5...
	//
	// Introductory Paragraph:
	//
	// Test the edureka portal to throw an exception while registering a user who already
	// holds an account with the same email id. Log in to the edureka portal with the 
	// registered email id,and search for all the courses available and Logout of the edureka 
	// portal. Write test cases using TestNG for above scenario.
	//
	// STEPS:
	//
	//********************************************

	
	//*****
	// STEP 1. Launch the Chrome browser
	//
	//*****

	//Initialize globally available Webdriver
	WebDriver driver;
	
	@BeforeSuite
	public void Setup() {	
	
		//Setup so Chrome launches incognito so browser history is not maintained producing autocomplete 
		//urls for navigations which may cause false positives test results.
		ChromeOptions optionsChrome = new ChromeOptions();
		optionsChrome.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, optionsChrome);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver(capabilities);
		
		//Setup global timeout waits for this Case Study's test script.
		driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS );
		
		//Maximize window
		driver.manage().window().maximize();
	}

	
	//*****
	// STEP 2. Log in to the account and browser for all the courses
	//
	//*****
	
	@Test( priority = 10 )
	public void OpenAUT() {
		driver.get("http://newtours.demoaut.com/");
	}

	
	@Parameters( {"Username", "Password"} ) 
	@Test( priority = 20, dependsOnMethods = "OpenAUT" )
	public void Login(String UName, String Pwd) throws InterruptedException {

		//Initialize local explicit waiter
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		//Enter Username
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("userName"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("userName"))).sendKeys(UName);
	  
		//Enter Password
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys(Pwd);

		// Click on Sign in button
		driver.findElement(By.name("login")).click();

	}
	
	
	@Test( priority = 30, enabled = false)
	public void SupportLink() throws InterruptedException {
		
		//Initialize local explicit waiter
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// Click on Sign off
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("SUPPORT"))).click();
	}
	
	
	//*****
	// STEP 3. Logout of the account
	//
	//*****
	
	@Test( priority = 40 )
	public void Logout() throws InterruptedException {
		
		//Initialize local explicit waiter
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// Click on Sign off
		wait.until(ExpectedConditions.presenceOfElementLocated((By.linkText("SIGN-OFF")))).click();
		
	}
	
	
	//*****
	// STEP 4. Use all the concepts learned in TestNG (dependency, priority, etc)
	//
	// NOTE: Following is a list of concepts that were implemented
	//		 to exhibit their proper use in both this CaseStudy6 class
	//		 and its partner TestNG companion xml file.:
	//
	//		 - annotations,
	//		 - parameterization,
	//		 - sequencing via dependency,
	//		 - sequencing via priority,
	//		 - disabling/disabling tests,
	//		 - grouping for excluding/including tests
	//		
	//		 Data provider, parallel execution and cross browser testing were not used heere since bot
	//		 data provider and parallel execution were not substantively applicable to this particular case study.
	//		 Cross browser testing could have been implemented; however, instructor indicated
	//		 to only run Chrome browser driver for all submitted case studies.
	//
	//*****
	
	@Test( priority = 41, groups = "DebuggingOnly")
	public void Debugging() throws InterruptedException {
		
		// TO USE THIS TEST FOR A 30 SECOND PAUSE AND BROWSER TERMINATION IN THE TEST SEQUENCE:
		//	- Remove or comment out the group DebuggingOnly from test exclusion in companion xml file.
		//	- Set priority in between any two other @Test in this file to insert into sequence where desired.
		//		  - 
		Thread.sleep(30000);
		driver.quit();
	}
	
	//*****
	// STEP 5. Create another test case to register the user with same email and an exception has to be shown on portal.
	//
	// NOTE: Instructor indicated to use the http://newtours.demoaut.com/ rather than Edureka site so the expected failure
	//		 on opening a duplicate account with same email does NOT occur on this http://newtours.demoaut.com/ demo site.
	//		 In fact, an SQA would call this a BUG discovered and report it.
	//
	//*****		
	
	@Parameters( {"Username", "Password", "Email"} ) 
	@Test( priority = 50, dependsOnMethods = "Logout")
	public void RegistrationAttemptSameEmailExpectFailure(String UName, String Pwd, String Eml) throws InterruptedException {
		
		//NOTE. Initial user was created with user name matching email as given in the CaseStudy6.xml parameters.
		//Initialize local explicit waiter
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		// Click on Sign off so a new account registration can be attempted.
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("REGISTER"))).click();
		
		//Enter Eml into the Registration form's field labeled "Email"
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("userName"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("userName"))).sendKeys(Eml);
		//Enter UName into the Registration form's field labeled "User Name"
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email"))).sendKeys(UName);
		//Enter Pwd into the Registration form's field labeled "Password"
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password"))).sendKeys(UName);
		//Enter Pwd into the Registration form's field labeled "Confirm Password"
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("confirmPassword"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("confirmPassword"))).sendKeys(UName);

		//Sleep here merely to understand bug / aberrant behavior of site.
		Thread.sleep(5000);
		
		//Click registration
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("register"))).click();
		
		//Sleep here again merely to understand bug / aberrant behavior of site.
		Thread.sleep(5000);
		
		//Output to show instructor and grader that a bug was found on this web site.
		System.out.println("\n---> BUG discovered on http://newtours.demoaut.com/ site here."
				         + "\n---> Allows a new account registration creation when existing account exists."
				         + "\n---> Expected a failure here in the TestNG output below and in the reports, but all passed.");
	}
	
	
	
	@Test( priority = 60 )
	public void CloseBrowser() throws InterruptedException {
		driver.close();
	}
	
	//*****
	// STEP 6. Check for the HTML report generated
	//
	// NOTE: This step was completed by enclosing a successful as expected test results by providing
	//		 the testng-results.xml and its companion test-failing.xml into the package ZIP file submitted for grading/review.
	//
	//*****	

		
	@AfterSuite()
	public void QuitBrowser() throws InterruptedException {
		driver.quit();
	}
	
}
