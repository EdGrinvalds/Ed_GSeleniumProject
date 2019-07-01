package pkgSeleniumCoursePart2.CaseStudyPart2NoXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CaseStudy2LocatorByName {
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
		//By.name Locator
		//
		//***********
	
		//Launch CHROME browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driverChrome = new ChromeDriver();
		
		//Open AUT web page
		driverChrome.get("https://www.edureka.co/");
		
		//Validate search box element is displayed (i.e., can be found)
		boolean bFindElementByNameValidationForChrome = driverChrome.findElement(By.name("user_v1[query]")).isDisplayed();
		System.out.print("Validation result for search box element By.name for Chrome is: " + bFindElementByNameValidationForChrome + "\n");
		
		//-----
		
		//Launch FIREFOX browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driverFireFox = new FirefoxDriver();
		
		//Open AUT web page
		driverFireFox.get("https://www.edureka.co/");
		
		//Validate search box element is displayed (i.e., can be found)
		boolean bFindElementByNameValidationForFireFox = driverFireFox.findElement(By.name("user_v1[query]")).isDisplayed();
		System.out.print("Validation result for search box element By.name for FireFox is: " + bFindElementByNameValidationForFireFox + "\n");
		
		
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
