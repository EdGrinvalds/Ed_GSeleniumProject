package ppkgzEdSelCertProj.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ppkgzEdSelCertProj.utility.Log;
 
public class ProductListing_Page extends BaseClass {
	private static WebElement element;
    public ProductListing_Page(WebDriver driver){
    	super(driver);
    	} 

	public static WebElement Select_product() {
		element = null;
       	try{
       		element= driver.findElement(By.xpath("//*[text()=\"Selenium 3.0 Certification Training\"]"));
       		Log.info("Selenium course is found");
       	}catch (Exception e){
       		Log.error("Selenium course is not found");
       		
       		throw(e);
       		}
       	return element;
        }
	
	}
	 