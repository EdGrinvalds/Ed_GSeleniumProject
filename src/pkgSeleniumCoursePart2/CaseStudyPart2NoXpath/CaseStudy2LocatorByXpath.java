package pkgSeleniumCoursePart2.CaseStudyPart2NoXpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CaseStudy2LocatorByXpath {

	public static void main(String[] args) {
		
		//***********
		//
		//SETUP
		//
		//***********
		
		ChromeOptions optionsChrome = new ChromeOptions();
		optionsChrome.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, optionsChrome);
		
		FirefoxOptions optionsFF = new FirefoxOptions();
		optionsFF.addArguments("-private");
	
		
		//***********
		//
		//By.xpath Locator
		//
		//***********
		
		//Launch CHROME browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driverChrome = new ChromeDriver(capabilities);
		
		//Open AUT web page
		driverChrome.get("https://www.edureka.co/");
			
		//Validate search box element is displayed (i.e., can be found) using xpath in several ways...
		
		//1. Using relative xpath across entire path searching for an id element attribute
		boolean bFindElementByXpathElementAttributeValidationForChrome = driverChrome.findElement(By.xpath("//*[@id='search-inp']")).isDisplayed();
		System.out.print("Validation result for search box element By.xpath using an element attribute for Chrome is: " + bFindElementByXpathElementAttributeValidationForChrome + "\n");

		//2. Using relative xpath across entire path searching for an element attribute containing a unique string
		boolean bFindElementByXpathContainsValidationForChrome = driverChrome.findElement(By.xpath("//*[contains(@placeholder, 'r Course, Cat')]")).isDisplayed();
		System.out.print("Validation result for search box element By.xpath using an element attribute containing a string for Chrome is: " + bFindElementByXpathContainsValidationForChrome + "\n");

		//3. Using relative xpath across entire path searching for an element attribute starting with a unique string
		boolean bFindElementByXpathStartsWithValidationForChrome = driverChrome.findElement(By.xpath("//*[starts-with(@placeholder, 'Enter Course')]")).isDisplayed();
		System.out.print("Validation result for search box element By.xpath using an element attribute starting with a string for Chrome is: " + bFindElementByXpathStartsWithValidationForChrome + "\n");
	
		
		//-----
	
		
		//Launch FIREFOX browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driverFireFox = new FirefoxDriver(optionsFF);
		
		//Open AUT web page
		driverFireFox.get("https://www.edureka.co/");
		
		//Validate search box element is displayed (i.e., can be found) using xpath in several ways...
		
		//1. Using relative xpath across entire path searching for an id element attribute
		boolean bFindElementByXpathElementAttributeValidationForFireFox = driverChrome.findElement(By.xpath("//*[@id='search-inp']")).isDisplayed();
		System.out.print("Validation result for search box element By.xpath using an element attribute for FireFox is: " + bFindElementByXpathElementAttributeValidationForFireFox + "\n");

		//2. Using relative xpath across entire path searching for an element attribute containing a unique string
		boolean bFindElementByXpathContainsValidationForFireFox = driverChrome.findElement(By.xpath("//*[contains(@placeholder, 'r Course, Cat')]")).isDisplayed();
		System.out.print("Validation result for search box element By.xpath using an element attribute containing a string for FireFox is: " + bFindElementByXpathContainsValidationForFireFox + "\n");

		//3. Using relative xpath across entire path searching for an element attribute starting with a unique string
		boolean bFindElementByXpathStartsWithValidationForFireFox = driverChrome.findElement(By.xpath("//*[starts-with(@placeholder, 'Enter Course')]")).isDisplayed();
		System.out.print("Validation result for search box element By.xpath using an element attribute starting with a string for FireFox is: " + bFindElementByXpathStartsWithValidationForFireFox + "\n");



		//***********
		//
		//CLEANUP
		//
		//***********
		
		//Exit the all opened browser sessions.
		driverChrome.quit();
		driverFireFox.quit();

	}

}
