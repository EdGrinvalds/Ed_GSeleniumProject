package ppkgzEdSelCertProj.appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ppkgzEdSelCertProj.pageObjects.BaseClass;
import ppkgzEdSelCertProj.pageObjects.EditProfile_Pages;
import ppkgzEdSelCertProj.pageObjects.Home_Page;
import ppkgzEdSelCertProj.utility.Log;
import ppkgzEdSelCertProj.utility.WaitForPageLoadComplete;

public class EditProfile_Action extends BaseClass {
	
	public EditProfile_Action(WebDriver driver) {
		
		super(driver);

	}

	
	public static void execute() throws Exception {
		
		//Initialize instance for waiting for page to complete loading.
	    WaitForPageLoadComplete waitComplete = new WaitForPageLoadComplete(30);
		
		try{
			
			// 1. This step was handled in UpdateProfileTest() test case file. Please reference the UpdateProfile.java file

			// 2. Navigate to My Profile.
		    waitComplete.waitForLoad(driver);
			Home_Page.Profile_button().click();
			
			waitComplete.waitForLoad(driver);
			EditProfile_Pages.MyProfile_menu_item().click();
			
			Log.info("Navigated to my profile page");
			
			// 3. Click on Edit Profile for the user.
			waitComplete.waitForLoad(driver);
			EditProfile_Pages.PersonalDetailsEdit_button().click();
			waitComplete.waitForLoad(driver);
			EditProfile_Pages.ProfessionalDetails_tab().click();
			
			Log.info("Navigated to edit profile Professional Details page");
			
			// 4. Update all the Professional details.
			waitComplete.waitForLoad(driver);
			Select current_job_level_dropdown = new Select(EditProfile_Pages.CurrentJobLevel_dropdown());
			current_job_level_dropdown.selectByIndex(3);
			Log.info("Selected the Current Job Level from its dropdown menu");
			
			waitComplete.waitForLoad(driver);
			Select industry_dropdown = new Select(EditProfile_Pages.Industry_dropdown());
			industry_dropdown.selectByIndex(2);
			Log.info("Selected the industry from its dropdown menu");
			
			waitComplete.waitForLoad(driver);
			EditProfile_Pages.Skills_textbox().clear();
			EditProfile_Pages.Skills_textbox().sendKeys("Selenium");
			Log.info("Entered text into Skills textbox");
			
			waitComplete.waitForLoad(driver);
			EditProfile_Pages.CompanyName_textbox().clear();
			EditProfile_Pages.CompanyName_textbox().sendKeys("SQA Testing Services, LLC");
			Log.info("Entered text into Company Name textbox");			
			
		}catch(Exception e){
			throw(e);
		}

	}
	
}
