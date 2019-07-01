package pkgSeleniumCoursePart2.CaseStudyPart2NoXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CaseStudy2LocatorByID {

	public static void main(String[] args) {
			
		
		//***********
		//
		//By.id Locator
		//
		//***********
		
		//Launch CHROME browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driverChrome = new ChromeDriver();
		
		//Open AUT web page
		driverChrome.get("https://www.edureka.co/");
		
		//Validate search box element is displayed (i.e., can be found)
		boolean bFindElementByIDValidationForChrome = driverChrome.findElement(By.id("search-inp")).isDisplayed();
		System.out.print("Validation result for search box element By.id for Chrome is: " + bFindElementByIDValidationForChrome + "\n");
		
		//-----
		
		//Launch FIREFOX browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driverFireFox = new FirefoxDriver();
		
		//Open AUT web page
		driverFireFox.get("https://www.edureka.co/");
		
		//Validate search box element is displayed (i.e., can be found)
		boolean bFindElementByIDValidationForFireFox = driverFireFox.findElement(By.id("search-inp")).isDisplayed();
		System.out.print("Validation result for search box element By.id for FireFox is: " + bFindElementByIDValidationForFireFox + "\n");
		

		//***********
		//
		//Cleanup
		//
		//***********
		
		//Exit the all opened browser sessions.
		driverChrome.quit();
		driverFireFox.quit();

	}

}
