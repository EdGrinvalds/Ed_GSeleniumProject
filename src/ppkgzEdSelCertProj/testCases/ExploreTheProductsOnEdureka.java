package ppkgzEdSelCertProj.testCases;


import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ppkgzEdSelCertProj.pageObjects.AllCourses_Page;
import ppkgzEdSelCertProj.pageObjects.BaseClass;
import ppkgzEdSelCertProj.pageObjects.Home_Page;
import ppkgzEdSelCertProj.pageObjects.Search_Page;
import ppkgzEdSelCertProj.utility.Constant;
import ppkgzEdSelCertProj.utility.ExcelUtils;
import ppkgzEdSelCertProj.utility.Log;
import ppkgzEdSelCertProj.utility.Utils;
import ppkgzEdSelCertProj.utility.WaitForPageLoadComplete;
import ppkgzEdSelCertProj.appModules.SignIn_Action;


public class ExploreTheProductsOnEdureka{
	
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
  
@Test
public void ExploreTheProductsOnEdurekaTest() throws Exception {	  

	//Initialize instance for waiting for page to complete loading.
	//This is a custom wait created since the Selenium provided driver.manage().timeouts().pageLoadTimeout(time, timeUnits)
	//This custom wait uses the Selenium JavascriptExecutor to run a script "return document.readyState" in a loop and waits for up to
	//n seconds to complete. n = the parameter passed into the instantiation below.
	WaitForPageLoadComplete waitComplete = new WaitForPageLoadComplete(30);

	//**********
	//*
	//*  Test Case Story Title: Testing Edureka Portal for selenium course
	//*
	//*  Steps 1-6 below are exactly as given in test case story requirements...
	//*
	//**********

	try {

		// 1. Login to the Portal.
		SignIn_Action.Execute(iTestCaseRow);
		Log.info("TEST CASE STEP 1 OF 6: Logged into application portal.");


		// 2. Navigate to “All Course” page.
		//NOTE: An "All Course" button to get to a page is now called "all-courses"
		waitComplete.waitForLoad(driver);

		//Click on the Courses menu item on the home page.
		Home_Page.Course_menu_item().click();
		Log.info("TEST CASE STEP 2 OF 6: Navigate to “Course” page.");


		// 3. Refine the search for selenium.
		waitComplete.waitForLoad(driver);

		AllCourses_Page.SearchBar_textfield().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Course));
		AllCourses_Page.SearchBar_textfield().sendKeys(Keys.ENTER);
		Log.info("TEST CASE STEP 3 OF 6: Refine the search for selenium.");


		// 4. Add the selenium course to wishlist.
		waitComplete.waitForLoad(driver);
		//Get the heart-shaped wish-list  button icon color.
		//And if the icon is not red, click it so icon turns red and (presumably) 
		String bgColorExpected = "rgba(255, 0, 4, 1)";  //Red color essentially.
		String bgColorActual = Search_Page.SeleniumCertCourseWishList_button().getCssValue("color");
		if ( ! bgColorActual.contentEquals(bgColorExpected) )
			//Not red so click it and make it red to add to (presumably) add to wishlist.
			Search_Page.SeleniumCertCourseWishList_button().click();

		//Validate the wishlist button is now red in color indicating that this course is a wishlist item.
		bgColorActual = Search_Page.SeleniumCertCourseWishList_button().getCssValue("color");
		Assert.assertEquals( bgColorActual, bgColorExpected, "Wishlist button color not red." );
		Log.info("TEST CASE STEP 4 OF 6: Add the selenium course to wishlist. Wishlist heart is red.");


		// 5. Check that selenium course is added in the users wishlist.
		waitComplete.waitForLoad(driver);

		Home_Page.Profile_button().click();
		waitComplete.waitForLoad(driver);
		Home_Page.MyWishList_button().click();
		waitComplete.waitForLoad(driver);
		
		//The code statement below "Search_Page.FavouriteCourseSelenium_text().isDisplayed();" will fail.
		//Fails due to Edureka favourites/wishlist functionality is currently not working as expected.
		System.out.println("\n **** EXPECTED FAILURE of this ExploreTheProductsOnEdurekaTest test case: Due to Edureka favourites/wishlist functionality is currently not working as expected.\n");
		Search_Page.FavouriteCourseSelenium_text().isDisplayed(); 

		Log.info("TEST CASE STEP 5 OF 6: Check that selenium course is added in the users wishlist");

		//6. Try if enrolling can be done from the wishlist page...
		
		//NOTE:  This coding to try and enroll from wishlist cannot be done.
		//       There is a bug with the Edureka wishlist functionality.
		//       No course can be put on a user's wishlist by clicking on the wishlist heart-shaped
		//       button next to any course, including the Selenium Certification Course.
		//		 Also there is no other way to get a course onto the wishlist that could be determined
		//		 by navigating through and exporling the Edureka site.
		//
		//BUG:   ADDING A COURSE TO WISHLIST
		//       EDUREKA SITE WEB APP
		//
		//TODO:  Add code once Edureka fixes the website so wishlist items are saved when user clicks 
		//       on the wishlist heart next to the courses on the search page and it turns red.
		//		 Currently this does not occur so...
		//		 Cannot write this code now since the correct screen presentation does not occur to enable code to be written.
		//		 Thus, this test case code is written to prove it does not work and will throw an error and fail.

		Log.info("TEST CASE STEP 6 OF 6: Try enrolling can be done from the wishlist page");		    	 


		//IF TEST PASSED, LOG PASS TO EXCEL SHEET. IF TEST FAILED, THROW TO EXCEPTION
		//THAT WILL CAUGHT AND PERFORM DIFFERENT FAILED WORK.
		if(BaseClass.bResult == true){
			// If the value of boolean variable is True, then  test is complete and passed and log to excel sheet
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
		}else{
			// If the value of boolean variable is False, then your test is fail, and you like to report it accordingly.
			// This is to throw exception in case of fail test, this exception will be caught by catch block below.
			throw new Exception("Test Case Failed because of a Verification. See log4j log output and failure screenshot for details.");
		}

	//IF TEST FAILED, LOG FAIL TO EXCEL SHEET, TAKE AND SAVE A SCREENSHOT AT TIME OF FAILURE, AND LOG DETAIL MESSAGE AND THROW
	//AGAIN SO TESTNG CAN COMPLETE THE TESTNG RESULTS.
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
	driver.close();
	}

}
