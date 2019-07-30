package ppkgzEdSelCertProj.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ppkgzEdSelCertProj.utility.Log;
import ppkgzEdSelCertProj.utility.WaitForPageLoadComplete;

public class Blogs_Page extends BaseClass {
	
	private static WebElement element;
	
	public Blogs_Page(WebDriver driver) {
		super(driver);

	}
	
	public static WebElement blog_MenuDropDownSelection() {
		

		element = null;
		
       	try{
       		
       		element = driver.findElement(By.xpath("//*[@data-button-name='Community Blog']"));
       		Log.info("Community Blog menu dropdown selection is found");
       		
       	}catch (Exception e){
       		
       		Log.error("Community Blog menu dropdown selection is not found");
       		
       		throw(e);
       		}
       	return element;
        }
	
	public static WebElement blog_DismissRecommendationsDialog() {
		
	   	//Initialize instance for waiting for page to complete loading.
	    WaitForPageLoadComplete waitComplete = new WaitForPageLoadComplete(30);
		
		element = null;
		
       	try{
       		
       		waitComplete.waitForLoad(driver);
       		element = driver.findElement(By.xpath("//button[contains(text(),'No thanks') and @id='wzrk-cancel']")); 
       		Log.info("Recommendation dialog 'No thanks' button is found");
       		
       	}catch (Exception e){
       		
       		Log.error("Recommendation dialog 'No thanks' button is not found");
       		
       		throw(e);
       		}
       	return element;
        }
	
	//Commented out. this element no longer exits on blogs page.
	//public static WebElement search_blog() {
	//	
	//	element = null;
	//	
    // 	try{
    //   		element= driver.findElement(By.xpath("//input[@placeholder=\"Search edureka blogs\"]"));
    //   		Log.info("Search button is found");
    //   	}catch (Exception e){
    //   		Log.error("Search button is not found");
    //   		
    //  		throw(e);
    //   		}
    //   	return element;
    //    }

}
