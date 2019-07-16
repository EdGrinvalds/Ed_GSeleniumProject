package pkgSeleniumCoursePart6.FilesFromTabresh;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot1 {

    public static void main(String[] args) throws Exception {

    	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\drivers\\chromedriver_2.46.exe");
    	WebDriver driver = new ChromeDriver();


        try{
            driver.get("http://google.co.in");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            
            driver.findElement(By.xpath("//*[@name='qaaa']")).sendKeys("test");
            System.out.println("Entered data in textfield");    
        }   
        catch (Exception e)
        {   	
       	
       File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(ss, new File("D:\\Training\\Selenium\\Programs\\Edureka_27thMay\\Screenshot\\Screenshot"+System.currentTimeMillis()+".jpg"));                          
       System.out.println("Screenshot is captured for failed testcase");
        	
        	
        	
        }  
    }  
}