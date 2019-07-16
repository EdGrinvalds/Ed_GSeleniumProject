package pkgSeleniumCoursePart5.CaseStudyPart5;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


//-------------------------------------------
public class CaseStudy5 {

	public static void main(String[] args) throws InterruptedException {
 		
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
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(capabilities);
		
		//Setup global timeout waits for this Case Study's test script.
		driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS );
		//Will use explicit waits. Do not mix implicit and explicit waits together. Reference: https://www.seleniumhq.org/docs/04_webdriver_advanced.jsp
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Initialize explicit waiter
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		//Initialize class for waiting for page to complete loading
		//This is a custom wait created since the Selenium provided driver.manage().timeouts().pageLoadTimeout(time, timeUnits)
		// setup above did not always appear to work as expected in certain situations.
		WaitForPageLoadComplete waitComplete = new WaitForPageLoadComplete();
		
		
		//********************************************
		//
		//CASE STUDY TEST SCRIPT
		//
		//Case study's Introductory Paragraph and Steps and duplicated here exactly as given in Case Study for Module 5...
		//
		//Introductory Paragraph:
		//
		//The candidate who has registered for edureka portal wants to update all the 
		//professional and personal details available in the portal
		//Write a selenium script to do the same and explore the edureka portal.
		//
		//Steps:
		//********************************************
		
		//*****
		// 1. Login to the edureka
		//
		//*****
		//CLick "Log in" button on the main page
		driver.get("https://www.edureka.co/");
		driver.findElement(By.xpath("//a[text()='Log In']")).click();

		//Enter email username and password
		//NOTE 1. The sleep in next code line needed for script robustnees. Because the explicit waits below alone (with or without the implicit wait above),
		//		  do not wait or delay and the sendKeys input of the email user name will fail intermittently by sending the keys before the
		//		  dialog box is ready to accept characters. The result is a front end truncated email address. 
		//		  For example, address "tsetekaf@gmail.com" may end up being "ekaf@gmail.com" or "l.com", etc. The course material has given no solution
		//		  to this type of dialog popup issue. It is  a dialog popup (and NOT an alert box popup which was covered in the course curriculum.	
		//		  Also using both the explicit wait for presenceOfElementLocated and elementToBeClickable methods are not doing their jobs
		//        in a robust manner for some reason. The 2 together in other situations in this script worked, but not here.
		Thread.sleep(1000);		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@action='/users/signin']//following::input[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@action='/users/signin']//following::input[1]"))).click();		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@action='/users/signin']//following::input[1]"))).sendKeys("tsetekaf@gmail.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@action='/users/signin']//following::input[2]"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@action='/users/signin']//following::input[2]"))).sendKeys("tsetekaf");

		//Click the Login button on the dialog popup
		driver.findElement(By.xpath("//*[@id='si_popup_passwd']//following::button[1]")).click();

		
		//*****
		// 2. Navigate to My Profile
		//
		//*****
		
		//NOTE2. Custom wait class made since the Selenium provided one for page load complete did not always work as expected.
		waitComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-button-name='Profile picture']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-button-name='Profile picture']"))).click();
		waitComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-button-name='My Profile']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-button-name='My Profile']"))).click();

		
		//*****
		// 3. Update professional and personal details
		//
		//*****
		
		//Click pencil icon to edit Personal Details
		//NOTE 3. See NOTE1. Eliminating implicit wait and also waiting for element to be present first and then clickable allowed for commenting out this sleep.
		//NOTE 4. Custom wait class made since the Selenium provided one for page load complete did not always work as expected.
		//Thread.sleep(100);
		waitComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='personal_details']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='personal_details']"))).click();
		
		//** Edit various Personal Details fields
		//Company textbox
		//NOTE 5. See NOTE1. Eliminating implicit wait and also waiting for element to be present first and then clickable allowed for commenting out this sleep.
		//NOTE 6. Custom wait class made since the Selenium provided one for page load complete did not always work as expected.
		//Thread.sleep(100);
		waitComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='fullname']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='fullname']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='fullname']"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='fullname']"))).sendKeys("tset ekaf");
		
		//Phone number textbox
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='phone_number']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='phone_number']"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='phone_number']"))).sendKeys("6125980011");
		
		//Current Role textbox
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='currentrole']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='currentrole']"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='currentrole']"))).sendKeys("Automated Tester");
		
		//Years Experience dropdown
		Select oSelectYearsExperience = new Select(driver.findElement(By.id("experience")));
		oSelectYearsExperience.selectByVisibleText("2-4 years");
		oSelectYearsExperience.selectByVisibleText("4-7 years");
		
		//Done with entering Personal Details, navigate to Professional Details entry fields
		//Click Continue button to get to Edureka's Career Service offering
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Continue')]"))).click();	
		
		//Click Skip to get past the Edureka Career Services offering and to get to Professional Details entry fields.
		//NOTE 7. Custom wait class made since the Selenium provided one for page load complete did not always work as expected.
		waitComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Skip ')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Skip ')]"))).click();
		
		
		//** Edit various Professional Details fields
		//NOTE 8. Custom wait class made since the Selenium provided one for page load complete did not always work as expected.
		//Company textbox
		waitComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='companyName']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='companyName']"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='companyName']"))).sendKeys("SQA Testing Services, LLC");
		

		//Industry dropdown
		Select oSelectIndustry = new Select(driver.findElement(By.name("currentIndustry")));
		oSelectIndustry.selectByVisibleText("Consulting");
		oSelectIndustry.selectByVisibleText("IT-Software / Software Services");
		
		//Skills textbox
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='userSkill']"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='userSkill']"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='userSkill']"))).sendKeys("Selenium");

		//Current Job Level dropdown
		Select oSelectCurrentJobLevel = new Select(driver.findElement(By.name("currentjob")));
		oSelectCurrentJobLevel.selectByVisibleText("Entry Level");
		oSelectCurrentJobLevel.selectByVisibleText("Mid Management");			

		
		//*****
		// 4. Explore the blogs and Navigate to Main page
		//
		//*****
		
		//** Navigate back to Main page in order to be able to click on Blogs link
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		
		//** Explore the blogs
		//Click on blog in Community menu item
		//NOTE 9. Custom wait class made since the Selenium provided one for page load complete did not always work as expected.
		waitComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='dropdownMenu4']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dropdownMenu4']"))).click();
		waitComplete.waitForLoad(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-button-name='Community Blog']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-button-name='Community Blog']"))).click();

		//-- Keep code below for future troubleshooting reference --
		//
		//String actualTitle = driver.getTitle();
		//System.out.println("Current window title: " + actualTitle);
		//
		//Set<String> awn = driver.getWindowHandles();
		//System.out.println("=============================================================");
		//System.out.println("All window names are:- " + awn);
		//System.out.println("=============================================================");
		//
		//ArrayList<String> arrWindowshandlesList = new ArrayList<String>(driver.getWindowHandles());
		//System.out.println("Index 0 window name in array:- " + arrWindowshandlesList.get(0));
		//System.out.println("Index 1 window name in array:- " + arrWindowshandlesList.get(1));
		//System.out.println("=============================================================");
		//
		//driver.switchTo().window(arrWindowshandlesList.get(1));
		//
		//actualTitle = driver.getTitle();
		//System.out.println("Current title: " + actualTitle);
		//
		//-- Keep code above for future troubleshooting reference --
		
		//** Switch to tab with blogs
		ArrayList<String> arrWindowshandlesList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(arrWindowshandlesList.get(1));
		
		//** Currently a dialog pops up immediately on the blogs tab that is modal and must be closed before having access to blogs page.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'No thanks') and @id='wzrk-cancel']"))).click();
		
		//** Click on the blog for SOftware Testing
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'Software Testing')]"))).click();
		
		//** Navigate back to the main page of the blog page.
		driver.navigate().back();
		
		//** Switch back to the tab of the Edureka home page as case study step indicstes (rther than closing the tab
		//   to get back to the home page.
		driver.switchTo().window(arrWindowshandlesList.get(0));
		//** Alternatively this code line below can be commented in and the above line commented out to just close the blogs tab
		//   to get back to the home page tab.
		//driver.close();

		
		//*****
		// 5. Logout of the portal
		//
		//*****
		
		//** Click Logout menu selection
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-button-name='Profile picture']"))).click();	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Log Out')]"))).click();
		
		
		//***********
		//
		//CLEANUP
		//
		//***********
		
		//Exit the all opened browser sessions.
		driver.quit();

	}

}
