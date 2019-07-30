package ppkgzEdSelCertProj.appModules;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import ppkgzEdSelCertProj.pageObjects.BaseClass;
import ppkgzEdSelCertProj.pageObjects.Blogs_Page;
import ppkgzEdSelCertProj.pageObjects.Home_Page;
import ppkgzEdSelCertProj.utility.WaitForPageLoadComplete;

public class BlogPageNav_Action extends BaseClass {
	
	public BlogPageNav_Action(WebDriver driver) {
		
    	super(driver);
	
	}  
	
	
	public static void Execute() throws Exception {
		
    	//Initialize instance for waiting for page to complete loading.
	    WaitForPageLoadComplete waitComplete = new WaitForPageLoadComplete(30);
		
		waitComplete.waitForLoad(driver);	
		Home_Page.Community_menu_item().click();
		
		waitComplete.waitForLoad(driver);
		Blogs_Page.blog_MenuDropDownSelection().click();
		
		//Switch to tab with blogs
		ArrayList<String> arrWindowshandlesList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(arrWindowshandlesList.get(1));
		
		//Currently Edureka site pops up a Recommendations dialog when the Blogs page is navigated to so it must be dismissed
	    //since all other elements are not interactable until it is dismissed.
		waitComplete.waitForLoad(driver);
		Blogs_Page.blog_DismissRecommendationsDialog().click();
		
	}
}