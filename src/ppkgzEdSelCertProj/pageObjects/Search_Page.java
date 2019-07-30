package ppkgzEdSelCertProj.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ppkgzEdSelCertProj.utility.Log;


public class Search_Page extends BaseClass {

	private static WebElement element = null;
	
	public Search_Page(WebDriver driver){
	            	super(driver);
	       }


	public static WebElement SeleniumCertCourseWishList_button() throws Exception{
		try{ 
			element = driver.findElement(By.xpath("//i[@id='d_wishlist-icon-535']"));
			Log.info("Selenium Certification course favorites button is found");
		}catch (Exception e){
			Log.error("Selenium Certification course favorites button is not found");
			throw(e);
		}
		return element;
	}
	
	public static WebElement SearchtxtNoResultsFound_text() throws Exception{
		try{ 
			//"Your search" will appear on the page if search found no matches.
			element = driver.findElement(By.xpath("//h1[@class='searchtxt' and contains(text(),'Your search ')]"));
			Log.info("Search results text is found indicating attempted search returned with no matches. Search failed.");
		}catch (Exception e){
			Log.error("Search results text is not found that indicates attempted search returned with no matches. Thus, indicating search had results.");
			throw(e);
		}
		return element;
	}
	
	
	public static WebElement FavouriteCourseSelenium_text() throws Exception{
		try{ 
			//Text on page as shown in pic in Certification Project Statement, page 5.
			element = driver.findElement(By.xpath("//*[contains(text(),'Selenium 3.0 Certification')]")); 
			Log.info("Selenium course is found");
		}catch (Exception e){
			Log.error("Selenium course is not found");
			throw(e);
		}
		return element;
	}
	
}
