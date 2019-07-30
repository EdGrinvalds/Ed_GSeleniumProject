package ppkgzEdSelCertProj.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ppkgzEdSelCertProj.utility.Log;


public class AllCourses_Page extends BaseClass {

	private static WebElement element = null;
	
	public AllCourses_Page(WebDriver driver){
	            	super(driver);
		   }
	
    public static WebElement SearchBar_textfield() throws Exception{
        try{ 
        	 element = driver.findElement(By.xpath("//*[@id='search-inp']"));
             Log.info("Search Field is found");
        }catch (Exception e){
       		 Log.error("Search Field is not found");
       		 throw(e);
       		 }
       	return element;
    }

}
