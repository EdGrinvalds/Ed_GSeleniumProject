package pkgSeleniumCoursePart9.CaseStudyPart9;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
// Leaving in below unused import to be able to easily try implicit waiting as necessary.
import org.openqa.selenium.support.ui.WebDriverWait;

import pkgSeleniumCoursePart5.CaseStudyPart5.WaitForPageLoadComplete;
import pkgSeleniumCoursePart9.CaseStudyPart9.utilities.*;

public class CaseStudy9 {
	
	@FindBy(tagName="")
	private WebElement id;

	public static void main(String[] args) throws Exception{
			
			//***********
			//
			// SETUP
			//
			//***********
			//
			// Setup so Chrome launches incognito so browser history is not maintained producing autocomplete 
			// urls for navigations which may cause false positives test results.
			ChromeOptions optionsChrome = new ChromeOptions();
			optionsChrome.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, optionsChrome);
			
			// Launch incognito Chrome browser session and go to edureka home page
			// because from an earlier 
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver(capabilities);
			driver.get("https://www.edureka.co/");
			
			// Setup global timeout waits for this Case Study's test script.
			driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
				
			// Maximize window
			driver.manage().window().maximize();
			
			// Initialize implicit waiter.
			// Will not use implicit waits in this case study since the edureka site is
			// know from doing an earlier case study that explicit and fluent waits are need.
			// Also a custom wait class will be part of this package in case it is needed to use
			// a JavascriptExecutor to poll the document.readystate until it returns complete.
			// WebDriverWait wait = new WebDriverWait(driver, 15);
			
			// Initialize class for waiting for page to complete loading
			// This is a custom wait created since the Selenium provided implicit, explicit and/or fluent waits
			// do not always work.
			WaitForPageLoadComplete waitJScriptComplete = new WaitForPageLoadComplete();
			
			
			//********************************************
			//
			// CASE STUDY TEST SCRIPT
			//
			// Case study's Introductory Paragraph and Steps and duplicated here exactly as given in Case Study for Module 9...
			//
			// Introductory Paragraph:
			//
			// Write an automation script to explore the blogs written in Edureka portal for Selenium interview questions. 
			// Use the concept of framework mechanism in Selenium to read the login credentials through Excel page
			// and update the status of the test case to Excel sheet back. 
			// 
			// Create a generic framework which can be reused to update any excel pages.
			//
			//
			// STEPS:
			//
			//********************************************
			
			//*****
			// 1. Launch browser and navigate to the Edureka portal
			//
			//*****
			//TODO: For login and navigation to blogs tab use CaseStudy5.java


			
			//*****
			// 2. Log In with your credentials, reading the data from excel sheet (username,password)a
			//
			//*****
			//TODO:
			driver.findElement(By.xpath("//a[text()='Log In']")).click();
			
			
			//*****
			// 4. Filter for selenium blogs
			//
			//*****
			
			
			//*****
			// 5. Navigate to interview questions in the blog
			//
			//*****
			//TODO: For login and navigation to blogs tab use CaseStudy5.java
			
			
			//*****
			// 6. Automate using Framework mechanism, create a generic framework
			//    for reading and writing data to excel
			//
			//*****
			//
			// This was completed through all the code in this case study plus the classes included in the
			// Case Study package.
			
			//***********
			//
			//CLEANUP
			//
			//***********
			
			//Exit opened browser sessions.
			driver.quit();
			
	}

}
