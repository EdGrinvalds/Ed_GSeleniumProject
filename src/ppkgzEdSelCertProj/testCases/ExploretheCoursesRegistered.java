package ppkgzEdSelCertProj.testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ppkgzEdSelCertProj.appModules.SignIn_Action;
import ppkgzEdSelCertProj.pageObjects.BaseClass;
import ppkgzEdSelCertProj.utility.Constant;
import ppkgzEdSelCertProj.utility.ExcelUtils;
import ppkgzEdSelCertProj.utility.Log;
import ppkgzEdSelCertProj.utility.Utils;
import ppkgzEdSelCertProj.utility.WaitForPageLoadComplete;


public class ExploretheCoursesRegistered {
	
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
@Test
public void ExploretheCoursesRegisteredTest() throws Exception {

	 //Initialize instance for waiting for page to complete loading.
     //This is a custom wait created since the Selenium provided driver.manage().timeouts().pageLoadTimeout(time, timeUnits)
     //This custom wait uses the Selenium JavascriptExecutor to run a script "return document.readyState" in a loop and waits for up to
	 //n seconds to complete. n = the parameter passed into the instantiation below.
     WaitForPageLoadComplete waitComplete = new WaitForPageLoadComplete(30);


 		//**********
 		//*
 		//*  Test Case Story Title: Check the enrolled courses for a user
 		//*
 		//*  Steps 1-4 below are exactly as given in test case story requirements...
 		//*
 		//**********

  	try {

 		// 1. Login to the Portal
 		SignIn_Action.Execute(iTestCaseRow);
 		Log.info("TEST CASE STEP 1 OF 4: Logged into application portal.");

 		//2. Navigate to the My Course Page
 		waitComplete.waitForLoad(driver);
 		driver.findElement(By.xpath("//*[@data-button-name='Profile picture']")).click();
 		waitComplete.waitForLoad(driver);
 		driver.findElement(By.xpath("//*[@data-button-name='My Orders']")).click();
 		waitComplete.waitForLoad(driver);
 		Log.info("TEST CASE STEP 2 of 4: Navigated to user's My Course page.");

 		// 3. Validate if any courses have been enrolled for the user
 		if(driver.getPageSource().contains("It looks like you are not enrolled for any course"))
 		{
 			//System.out.println("Not enrolled to any course");
 			Log.info("TEST CASE STEP 3 of 4: Verified user not enrolled for any courses");
 		}

 		// 4. Logout of the Portal
 		driver.navigate().back();
 		waitComplete.waitForLoad(driver);
 		driver.findElement(By.xpath("//*[@data-button-name='Profile picture']")).click();
 		waitComplete.waitForLoad(driver);
 		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
 		Log.info("TEST CASE STEP 4 of 4: Logged out of application portal.");

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
