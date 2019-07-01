package pkgSeleniumCoursePart2.CaseStudyPart2NoXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaseStudy2LocatorByCssSelectorName {

	public static void main(String[] args) {
		
		
		//***********
		//
		//By.cssSelector Locator
		//
		//***********
		
		//Launch CHROME browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driverChrome = new ChromeDriver();
		
		//Open AUT web page
		driverChrome.get("https://www.edureka.co/");
		
		//Validate search box element is displayed (i.e., can be found)
		boolean bFindElementByCssSelectorValidationForChrome = driverChrome.findElement(By.cssSelector("#search-inp")).isDisplayed();
		System.out.print("Validation result for search box element By.cssSelector for Chrome is: " + bFindElementByCssSelectorValidationForChrome + "\n");
		
		//-----
		
		//Launch FIREFOX browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driverFireFox = new FirefoxDriver();
		
		//Open AUT web page
		driverFireFox.get("https://www.edureka.co/");
		
		//Validate search box element is displayed (i.e., can be found)
		boolean bFindElementByCssSelectorValidationForFireFox = driverFireFox.findElement(By.cssSelector("#search-inp")).isDisplayed();
		System.out.print("Validation result for search box element By.cssSelector for FireFox is: " + bFindElementByCssSelectorValidationForFireFox + "\n");
		

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
