package ppkgzEdSelCertProj.testCases;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ppkgzEdSelCertProj.appModules.BlogPageNav_Action;
import ppkgzEdSelCertProj.appModules.ClickOnFilteredLink;
import ppkgzEdSelCertProj.appModules.SignIn_Action;
import ppkgzEdSelCertProj.pageObjects.BaseClass;
import ppkgzEdSelCertProj.utility.Constant;
import ppkgzEdSelCertProj.utility.ExcelUtils;
import ppkgzEdSelCertProj.utility.Log;
import ppkgzEdSelCertProj.utility.Utils;
import ppkgzEdSelCertProj.utility.WaitForPageLoadComplete;

public class ExploreBlogsOnEdureka {
	
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
  @Test
  public void ExploreBlogsOnEdurekaTest() throws Exception {
	  
	  //Initialize instance for waiting for page to complete loading.
	  //This is a custom wait created since the Selenium provided driver.manage().timeouts().pageLoadTimeout(time, timeUnits)
	  //This custom wait uses the Selenium JavascriptExecutor to run a script "return document.readyState" in a loop and waits for up to
	  //n seconds to complete. n = the parameter passed into the instantiation below here
	  WaitForPageLoadComplete waitComplete = new WaitForPageLoadComplete(30);
	  
	  //Initialize strings used for filtering and clicking on links for the CLickOnFilteredLink
	  String filter = "Selenium";
	  String selectSubstring = "interview";
	  
	  //**********
	  //*
	  //*  Test Case Story Title: Testing Edureka Portal to list the blogs written on selenium
	  //*
	  //*  Steps 1-5 below are exactly as given in test case story requirements...
	  //*
	  //**********
	  
	  try {
	  
		  // 1. Login to the Portal.     
		  SignIn_Action.Execute(iTestCaseRow);
		  Log.info("TEST CASE STEP 1 OF 5: Logged into application portal.");


		  // 2. Navigate to blogs page.
		  //Do not mix the commented out below Selenium explicit waits with Selenium implicit wait
		  //defined in this framework.
		  //Use custom wait designed for this framework not relying on Selenium library waits.
		  //WebDriverWait waitElement = new WebDriverWait(driver,30);
		  //waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar\"]/ul/li[3]/a")));
		  waitComplete.waitForLoad(driver);	  
		  BlogPageNav_Action.Execute();
		  Log.info("TEST CASE STEP 2 OF 5: Navigate to blogs page.");

		  // 3. Refine the search for selenium blogs.
		  filter = "Selenium";
		  selectSubstring = "interview";

		  waitComplete.waitForLoad(driver);	  
		  ClickOnFilteredLink.withSubstrings(filter, selectSubstring);
		  Log.info("TEST CASE STEP 3 OF 5: Refine the search for selenium blogs.");

		  // 4. Explore the blogs on interview questions.
		  filter = "questions";
		  selectSubstring = "professionals";

		  waitComplete.waitForLoad(driver);
		  ClickOnFilteredLink.withSubstrings(filter, selectSubstring);
		  Log.info("TEST CASE STEP 4 OF 5: Explore the blogs on interview questions.");


		  // 5. Close all the blogs tab.
		  waitComplete.waitForLoad(driver);
		  //Get handles to the windows into an ArrayList.
		  ArrayList<String> tabsBefore = new ArrayList<String> (driver.getWindowHandles());
		  //Use the list of window handles to get total number of windows/tabs open and to switch between windows.
		  int beforeTabCloseCount = tabsBefore.size();

		  //Close blogs tab.
		  driver.close();

		  //Ensure user is on the home page.
		  String originalHandle = tabsBefore.get(0);
		  driver.switchTo().window(originalHandle);

		  //Get another new list of window/tab handles to determine number of tabs that are yet open.
		  ArrayList<String> tabsAfter = new ArrayList<String> (driver.getWindowHandles());

		  //If the number of tabs expected and number of tabs actually open do not match,
		  //then assert an error and fail test.
		  int afterTabCloseCount = tabsAfter.size();
		  int expectedTabCloseCount = beforeTabCloseCount - 1;
		  if( expectedTabCloseCount != afterTabCloseCount)
			  throw new Exception("Blogs tab did not close as expected.");
		  
		  Log.info("TEST CASE STEP 5 OF 5: Close all the blogs tab."); 

		  //IF TEST PASSED, LOG PASS TO EXCEL SHEET. IF TEST FAILED, THROW TO EXCEPTION
		  //THAT WILL CAUGHT AND PERFORM DIFFERENT FAILED WORK.
		  if(BaseClass.bResult == true){
			  // If the value of boolean variable is True, then  test is complete and passed and log to excel sheet
			  ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
		  }else{
			  // If the value of boolean variable is False, then your test is fail, and you like to report it accordingly
			  // This is to throw exception in case of fail test, this exception will be caught by catch block below
			  throw new Exception("Test Case Failed because of a Verification. See log4j log output and failure screenshot for details.");
		  }
    
	}catch (Exception e) {
	
		// If in case an exception occurred during the test, it will mark your test as Fail in the Excel sheet.
		ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
		Utils.takeScreenshot(driver, sTestCaseName);
		Log.error(e.getMessage());
	
		// Again throwing the exception to fail the test completely in the TestNG results
		throw (e);
	}
	  
  }

  
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	// Configuring Log4j logs, please see the following posts to learn about Log4j Logging
	  	DOMConfigurator.configure("C:/Users/edgri/eclipse-workspace-jee-2019-03/Ed_GSeleniumProject/src/ppkgzEdSelCertProj/test-output-log4j/log4j.xml");
	  	
	  	// Getting the Test Case name, as it will going to use in so many places
	  	// The main use is to get the TestCase row from the Test Data Excel sheet
	  	sTestCaseName = this.toString();
	  	// From above method we get long test case name including package and class name etc.
	  	// The below method will refine your test case name, exactly the name use have used
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	
	  	// Start printing the logs and printing the Test Case name
		Log.startTestCase(sTestCaseName);
		
		// Setting up the Test Data Excel file using Constants variables
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		// Fetching the Test Case row number from the Test Data Sheet
		// This row number will be feed to so many functions, to get the relevant data from the Test Data sheet 
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		// Launching the browser, this will take the Browser Type from Test Data Sheet 
		driver = Utils.OpenBrowser(iTestCaseRow);
		
		// Initializing the Base Class for Selenium driver
		new BaseClass(driver);  
      }

  
  @AfterMethod
  public void afterMethod() {
	    // Printing beautiful logs to end the test case
	    Log.endTestCase(sTestCaseName);
	    // Closing the opened driver
	    driver.quit();
		}
}
