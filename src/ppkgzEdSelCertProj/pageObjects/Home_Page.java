package ppkgzEdSelCertProj.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ppkgzEdSelCertProj.utility.Log;


public class Home_Page extends BaseClass {
    	
    private static WebElement element = null;
       
    public Home_Page(WebDriver driver) {
        	super(driver);
    }    
    
    
    public static WebElement SearchBar() throws Exception {
        try{ 
        	 element = driver.findElement(By.xpath(".//*[@id='search-inp']"));
             Log.info("Search Field is found");
        }catch (Exception e) {
       		Log.error("Search Field is not found");
       		throw(e);
       	}
       	return element;
    }
    
    
    public static WebElement Course_menu_item() throws Exception {
        try{ 
        	 element = driver.findElement(By.xpath("//*[@data-button-name='Courses']"));
             Log.info("Courses button is found which will open the 'all-courses' page");
        }catch (Exception e) {
       		Log.error("Courses button is not found which would open the 'all-courses' page");
       		throw(e);
       	}
       	return element;
    }
    
    
    public static WebElement Community_menu_item() throws Exception {
        try{ 
        	 element = driver.findElement(By.xpath("//*[@data-button-name='Community']"));
             Log.info("Community button is found");
        }catch (Exception e) {
       		Log.error("Courses button is not found");
       		throw(e);
       	}
       	return element;
    }
    
    
	public static WebElement Profile_button() {

       	try{
       		element = driver.findElement(By.xpath("//*[@data-button-name='Profile picture']"));
       		Log.info("Profile button is found");
       	}catch (Exception e) {
       		Log.error("Profile button is not found");    		
       		throw(e);
       	}
       	return element;
	}
	
	
	public static WebElement MyWishList_button() {

       	try{
       		element = driver.findElement(By.xpath("//*[@data-button-name='My Wishlist']"));
       		Log.info("My Wishlist in profile menu dropdown selection is found");
       	}catch (Exception e) {
       		Log.error("My Wishlist in profile menu dropdown selection is not found");
       		throw(e);
       	}
       	return element;
	}
	
	
	public static WebElement EnrollButton() throws Exception {
    	
    	try{ 
        	 element = driver.findElement(By.xpath("//*[@id=\"Batches\"]/div/div[2]/div[2]/a/button"));
             Log.info("Enroll button is found");
       }catch (Exception e) {
      		Log.error("Enroll button is not found");
      		throw(e);
      	}
      	return element;
    }
    
    

	
	

      
}
