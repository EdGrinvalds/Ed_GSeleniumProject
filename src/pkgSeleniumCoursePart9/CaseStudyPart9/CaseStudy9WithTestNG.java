package pkgSeleniumCoursePart9.CaseStudyPart9;

import pkgSeleniumCoursePart9.CaseStudyPart9.utilities.*;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CaseStudy9WithTestNG {
	
	WebDriver driver;
	WebDriverWait wait;
	WaitForPageLoadComplete waitJScriptComplete;
		  
	@BeforeTest
		public void OpenBrowser() {
	
			// Before and @Test is run, execute the following...
			
			// Setup so Chrome launches incognito so browser history is not maintained producing autocomplete 
			// urls for navigations which may cause false positives test results.
			ChromeOptions optionsChrome = new ChromeOptions();
			optionsChrome.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, optionsChrome);
	
			// Launch incognito Chrome browser session and go to edureka home page
			// because from an earlier 
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(capabilities);
			driver.get("https://www.edureka.co/");
	
			// Setup global timeout waits for this Case Study's test script.
			driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
			// Maximize window
			driver.manage().window().maximize();
			
			//Initialize explicit waiter. Will use global implicit waits along with PageFacory to handle
			//test driver and AUT asynchronous operation and reduce timing exceptions between them.
			//wait = new WebDriverWait(driver, 15);
	
			// Initialize implicit waiter.
			// Will not use implicit waits in this case study since the edureka site is
			// know from doing an earlier case study that explicit and fluent waits are need.
			// Also a custom wait class will be part of this package in case it is needed to use
			// a JavascriptExecutor to poll the document.readystate until it returns complete.
			// WebDriverWait wait = new WebDriverWait(driver, 15);
	
			// Initialize class for waiting for page to complete loading
			// This is a custom wait created since the Selenium provided implicit, explicit and/or fluent waits
			// do not always work, and this custom wait can aid in reducing/eliminating timing exceptions will be used
			// if needed during case study/test case development.
			waitJScriptComplete = new WaitForPageLoadComplete();
		}


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
	
	@Test(priority = 10, dataProvider = "loginCredentialsDataFeed")	
		
		//*****
		// 1. Launch browser and navigate to the Edureka portal
		//
		//*****
	
		//** Done in the TestNG @BeforeTest of this test script


		
		//*****
		// 2. Log In with your credentials, reading the data from excel sheet (fetch username and password).
		//
		//*****
	
		//** Enter email and password from excel file via a dataprovider.
		public void Login(String email, String password) throws Exception {
			
			edurekaHomePage ehp = new edurekaHomePage(driver, wait, waitJScriptComplete);
			ehp.Login(email, password);
		
		}
		
		//*****
		// 4. Filter for selenium blogs.
		//
		//*****
		//*****
		// 5. Navigate to interview questions in the blog
		//
		//*****
	
		//** First open the Edureka site blogs page so filtering can take place.
	@Test( priority = 20,  dependsOnMethods = "Login" )
		public void NavigateToBlogs( ) throws Exception {
			
			//Open blogs page.
			edurekaHomePage ehp = new edurekaHomePage(driver, wait, waitJScriptComplete);
			ehp.NavigateToBlogs();
	
		}
	
	
		//** Filter for blog links with "selenium" in the linkname and then click on the link
		//   with the specified substring "interview" to navigate to the interview questions blog.
		//   Click on the blog as given here are in the general instructions in as given in
		//   the comments above under the header "CASE STUDY TEST SCRIPT".
	@Test( priority = 30, dependsOnMethods = "NavigateToBlogs" )
		public void FilterAndClickBlog() throws Exception {
		
			String filter = "selenium";
			String selectSubstring = "interview";
			
			ClickOnFilteredString fac = new ClickOnFilteredString(driver);
			fac.withSubstrings(filter, selectSubstring);
			
			
		}
		
		
		//*****
		// 6. Automate using Framework mechanism, create a generic framework
		//    for reading and writing data to excel
		//
		//*****
		//
		// This was completed through all the code in this case study plus the classes included in the
		// Case Study package. Reading (ref. @dataprovider) and writing to an Excel file code (ref. @AfterMethod)
		// are included.


	@DataProvider
		public Object[][] loginCredentialsDataFeed() throws Exception {
	
			//Declare variables and default initialization
			Workbook wb = null;
			Sheet sh = null;
			int numrows = 0;
			int numcols = 0;
			
			// To import the Excel file and fetch the data bytes from the file and pass it to the script
			FileInputStream myfis = new FileInputStream("C:\\Users\\edgri\\eclipse-workspace-jee-2019-03\\Ed_GSeleniumProject\\src\\pkgSeleniumCoursePart9\\CaseStudyPart9\\test-data\\TestData.xlsx");
			
			wb = WorkbookFactory.create(myfis);
	
			sh = wb.getSheet("LoginCreds");
	
			numrows = sh.getLastRowNum();
			
			// NOTE1:
			// Add 1 to numrows immediately after getting the last row but it is important before instantiating the loginData 2-dimensional array. 
			// Need to have an array that is correct number of rows deep. Note that sheet functions use a row indowx starting at zero.
			numrows = numrows + 1;
			//System.out.println(numrows);
	
			numcols = sh.getRow(0).getLastCellNum();
			//System.out.println(numcols);
	
			Object[][] loginData = new Object[numrows][numcols];
	
			for(int row = 0; row < numrows; row++) 
			{
				//System.out.println(row);
	
				for(int col = 0; col < numcols; col++) 
				{
	
					// Fetch the data from the excel file and capture those bytes of the cell
					loginData[row][col] = sh.getRow(row).getCell(col).toString();
	
				}
	
			}
			return loginData;
		}

	
	
	@AfterMethod
		public void FetchAndAddEachTestsStatusToExcelFile( ITestResult result, ITestResult name ) throws Exception {
		
	
			//***********
			//
			// REPORTING
			//
			//***********
			
			// After all tests are run, then open Excel file and report status overall status of the test case.
			
			String filePathWithFileName = "C:\\Users\\edgri\\eclipse-workspace-jee-2019-03\\Ed_GSeleniumProject\\src\\pkgSeleniumCoursePart9\\CaseStudyPart9\\test-data\\TestCaseTestsAndStatus.xlsx";
			String sheetName = "Status";
			
			int status = result.getStatus();
			String testName = result.getName();
			String statusText = null;
	
		    WriteOneRowToExcelFile writeTimeDateAndStatus = new WriteOneRowToExcelFile();
		    
		    switch (status) {
			    case ITestResult.SUCCESS:
			        System.out.println("====== SUCCESS: " + testName + " ======");
			        statusText = "PASS";
			        writeTimeDateAndStatus.dateTimeAndStatus(filePathWithFileName, sheetName, statusText);
			        // Expected when passed
			        break;
		
			    case ITestResult.FAILURE:
			        System.out.println("====== FAILURE: " + testName + " ======");
			        statusText = "FAIL";
			        writeTimeDateAndStatus.dateTimeAndStatus(filePathWithFileName, sheetName, statusText);
			        // Expected when failed
			        break;
		
			    case ITestResult.SKIP:
			        System.out.println("====== SKIPPED ======");
			        statusText = "SKIPPED";
			        writeTimeDateAndStatus.dateTimeAndStatus(filePathWithFileName, sheetName, statusText);
			        // Expected when skipped
			        break;
		
			    default:
			        throw new RuntimeException("Invalid test status");
		    }
		    
		}

	
	@AfterTest
		public void QuitBrowser() {
			
			//***********
			//
			// CLEANUP
			//
			//***********
			
			//Exit opened browser session.
			driver.quit();
		}

	}

