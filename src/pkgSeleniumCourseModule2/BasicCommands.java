package pkgSeleniumCourseModule2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicCommands {

	public static void main(String[] args) {
		
		//Launch Chrome browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open web page
		driver.get("https://www.facebook.com");
		
		//Launch Firefox browser
		System.setProperty("webdriver.gecko.driver", "D:\\Training\\Selenium\\Selenium\\drivers\\geckodriver_0.24.exe");
		WebDriver driver1 = new FirefoxDriver();

		//Close & Quit Commands
		driver.close(); //Close only the current active window opened within current instance
		driver.quit();  //Close all the windows opened within current instance

		//Get Commands
		driver.get("<replace with URL>"); 	//Open the URL of the Application Under Test (AUT)
		driver.getCurrentUrl(); 		  	//Take the URL from the Browser and validate
		driver.getTitle();				  	//Fetch the title of the page
		driver.getWindowHandle();    	  	//Gets the alphanumeric identity of the window
				
		//Navigation Commands
		driver.navigate().back();			// Nav to the previous page
		driver.navigate().forward();		// Nav to the next page
		driver.navigate().refresh();		// Refresh the current page
		driver.navigate().to("URL");		// Nav to another URL. Use driver.get for opening initial URL after launching the browser.
				
		//Element Handling Cammands
		driver.findElement(By.id("")).sendKeys("Abhresh");	//Type into a text box
		driver.findElement(By.id("")).click();				//Click on an element
		driver.findElement(By.id("")).clear();				//Erase the data from a text box
		driver.findElement(By.id("")).getText();			//Get the text of that element
	}

}


