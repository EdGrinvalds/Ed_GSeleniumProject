package ppkgzEdSelCertProj.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ppkgzEdSelCertProj.utility.Log;

public class EditProfile_Pages extends BaseClass {
	
	private static WebElement element;
	
	
	public EditProfile_Pages(WebDriver driver) {
		
		super(driver);

	}
	
	/*Commented out. Not used.
	 *The following method was commented out. Using the Home_Page.Profile_button() method instead
	 *rather than duplicating functionality here.
	
	public static WebElement navigate_to_my_profile() {
		
	  	 element = null;
	   	 
	   	 try {
	   		 element= driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div[1]/ul[2]/li[1]/a"));
	   		 Log.info("Navigate to my profile button is found on the Home Page");
	   	 }catch (Exception e) {
	   		 Log.error("Continue button on Home page is not found");
	   		 throw(e);
	   	 }
	   	 return element;
	}
	*
	*
	*/
	
	
	public static WebElement MyProfile_menu_item() {
		
	   	 element = null;
	   	 
	   	 try {
	   		 
	   		 element= driver.findElement(By.xpath("//*[@data-button-name='My Profile']"));
	   		 Log.info("My Profile menu selection is found on the Home Page's Profile dropdown menu");
	   		 
	   	 }catch (Exception e){
	   		 
	   		 Log.error("My Profile menu selection on Home page's Profile dropdown menu is not found");
	   		 throw(e);
	   		 
	   	 }
	   	 return element;
	}
	
	
	/*Commented out. Not Used.
	 *The following method was handled with the method MyProfile_menu_item() above with a simpler xpath.

	 public static WebElement my_profile_button() {
	 
		
	   	 element = null;
	   	 
	   	 try {
	   		 element= driver.findElement(By.xpath("//*[@id=\"myprofile\"]/div[2]/div[1]/div/div[1]/h4[2]/span/i"));
	   		 Log.info("Navigate to my profile button is found on the Home Page");
	   	 }catch (Exception e) {
	   		 Log.error("Continue button on Home page is not found");
	   		 throw(e);
	   	 }
	   	 return element;
	}
	*
	*
	*/
	
	
	public static WebElement PersonalDetailsEdit_button() {
		
	   	 element = null;
	   	 
	   	 try {
	   		 
	   		 element= driver.findElement(By.xpath("//a[@id='personal_details']"));
	   		 Log.info("Personal Details Edit button is found on my-profile page");
	   		 
	   	 }catch (Exception e){
	   		 
	   		 Log.error("Personal Details Edit button is not found on my-profile page");
	   		 throw(e);
	   		 
	   	 }
	   	 return element;
	}
	
	
	public static WebElement ProfessionalDetails_tab() {
		
	   	 element = null;
	   	 
	   	 try {
	   		 
	   		 element= driver.findElement(By.xpath("//a[@aria-controls='professionalDetails']"));
	   		 Log.info("Professionl Details tab is found on the ../onboarding/personaldetails page");
	   		 
	   	 }catch (Exception e){
	   		 
	   		 Log.error("Professionl Details tab is not found on the ../onboarding/personaldetails page");
	   		 throw(e);
	   		 
	   	 }
	   	 return element;
	}
	

	 public static WebElement CurrentJobLevel_dropdown() {
		
		element = null;

		try {
			
			element= driver.findElement(By.name("currentjob"));
			Log.info("Current Job Level dropdown button is found on the ../onboardng/professionaldetails page");
			
		}catch (Exception e){
			
			Log.error("pCurrent Job Level dropdown button is not found on the ../onboardng/professionaldetails page");
			throw(e);
			
		}
		return element;
	}
	
	
	public static WebElement Industry_dropdown() {
		
	   	 element = null;
	   	
	   	 try {
	   		 
	   		 element= driver.findElement(By.name("currentIndustry"));
	   		 Log.info("Industry dropdown is found on the ../onboardng/professionaldetails page");
	   		 
	   	 }catch (Exception e) {
	   		 
	   		 Log.error("Industry dropdown is not found on the ../onboardng/professionaldetails page");
	   		 throw(e);
	   		 
	   	 }
	   	 return element;
	}
	
	
	public static WebElement Skills_textbox() {
		
	   	 element = null;
	   	
	   	 try {
	   		 
	   		 element= driver.findElement(By.name("userSkill"));
	   		 Log.info("Skills textbox is found on the ../onboardng/professionaldetails page");
	   		 
	   	 }catch (Exception e) {
	   		 
	   		 Log.error("Skills textbox is not found on the ../onboardng/professionaldetails page");
	   		 throw(e);
	   		 
	   	 }
	   	 return element;
	}
	
	
	public static WebElement CompanyName_textbox() {
		
	   	 element = null;
	   	
	   	 try {
	   		 
	   		 element= driver.findElement(By.name("companyName"));
	   		 Log.info("Company Name textbox is found on the ../onboardng/professionaldetails page");
	   		 
	   	 }catch (Exception e) {
	   		 
	   		 Log.error("Company Name textbox is not found on the ../onboardng/professionaldetails page");
	   		 throw(e);
	   		 
	   	 }
	   	 return element;
	}
	
	/*Commented out. Not Used.
	 *The following method was handled with the method CurrentJobLevel_dropdown above with a simpler xpath.
	
		 public static WebElement current_job() {
		
	   	 element = null;
	   	 
	   	 try {
	   		 element= driver.findElement(By.xpath("//*[@id=\"professional_detail\"]/app-professional-detail/div[1]/div/form/div[1]/div/div/div/div[5]//select"));
	   		 Log.info("current job dropdown button is found on the Edit profile");
	   	 }catch (Exception e) {
	   		 Log.error("current job dropdown button is not found on the Edit profile");
	   		 throw(e);
	   	 }
	   	 return element;
	}
	*
	*
	*/
	
	/*Commented out. Not Used.
	 *No longer a part of the Edureka ./onboardng/professionaldetails page.

	public static WebElement employement_type() {
		
	   	 element = null;
	   	 
	   	 try{
	   		 element = driver.findElement(By.xpath("//*[@id=\"professional_detail\"]/app-professional-detail/div[1]/div/form/div[1]/div/div/div/div[7]//select"));
	   		 Log.info("emplyement Type dropdown button is found on the Edit profile");
	   	 }catch (Exception e){
	   		 Log.error("emplyement Type dropdown button is not found on the Edit profile");
	   		 throw(e);
	   	 }
	   	 return element;
	}
	*
	*
	*/
	
	
	/*Commented out. Not Used.
	 *No longer a part of the Edureka ./onboardng/professionaldetails page.
	
	public static WebElement ctc() {
		
	   	 element = null;
	   	 
	   	 try {
	   		 element = driver.findElement(By.xpath("//*[@id=\"professional_detail\"]/app-professional-detail/div[1]/div/form/div[1]/div/div/div/div[2]//select"));
	   		 Log.info("ctc dropdown button is found on the Edit profile");
	   	 }catch (Exception e) {
	   		 Log.error("ctc dropdown button is not found on the Edit profile");
	   		 throw(e);
	   	 }
	   	 return element;
	}
	*
	*
	*/
	
	/*Commented out. Not used.
	 *This method makes no sense that was provided in the framework zip file.
	 *It appears to be copy/pasted here for some other page dealing with payment.

	public static WebElement edit_profile() {
		
	   	 element = null;
   	 
	   	 try {
	   		 element= driver.findElement(By.xpath("//*[@id=\"cddccard\"]/div[2]/button"));
	   		 Log.info("Continue button is found on the Check Out Page");
	   	 }catch (Exception e) {
	   		 Log.error("Continue button on Check Out page is not found");
	   		 throw(e);
	   	 }
	   	 return element;
	}
	*
	*
	*/

}
