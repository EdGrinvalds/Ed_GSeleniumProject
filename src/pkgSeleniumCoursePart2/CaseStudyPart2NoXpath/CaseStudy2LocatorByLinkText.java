package pkgSeleniumCoursePart2.CaseStudyPart2NoXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CaseStudy2LocatorByLinkText {

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
		//By.linkText Locator
		//
		//***********
		
		//Launch CHROME browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driverChrome = new ChromeDriver(capabilities);
		
		//Open AUT web page
		driverChrome.get("https://www.edureka.co/");
		
		//Validate search box element is displayed (i.e., can be found)
		boolean bFindElementByLinkTextValidationForChrome = driverChrome.findElement(By.linkText("Log In")).isDisplayed();
		System.out.print("Validation result for search box element By.linkText for Chrome is: " + bFindElementByLinkTextValidationForChrome + "\n");
		
		//-----
		
		//Launch FIREFOX browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driverFireFox = new FirefoxDriver(optionsFF);
		
		//Open AUT web page
		driverFireFox.get("https://www.edureka.co/");
		
		//Validate search box element is displayed (i.e., can be found)
		boolean bFindElementByLinkTextValidationForFireFox = driverFireFox.findElement(By.id("search-inp")).isDisplayed();
		System.out.print("Validation result for search box element By.linkText for FireFox is: " + bFindElementByLinkTextValidationForFireFox + "\n");
		

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
