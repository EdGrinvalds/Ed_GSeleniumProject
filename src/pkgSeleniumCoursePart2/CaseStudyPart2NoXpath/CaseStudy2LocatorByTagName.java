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

public class CaseStudy2LocatorByTagName {

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
		//By.tagName Locator
		//
		//***********
		
		//Launch CHROME browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driverChrome = new ChromeDriver(capabilities);
		
		//Open AUT web page
		driverChrome.get("https://www.edureka.co/");
		
		List<WebElement> taglistChrome = driverChrome.findElements(By.tagName("input"));
		System.out.println("Number of tags total as that of the searchbox in Chrome: " + taglistChrome.size() + "\n");		
		
		//Validate search box element is displayed (i.e., can be found)
		//*** SKIPPED because:
		//*** In this case, tagName is not unique as there are currently 62 elements with a tagname of "input". Further this is likely to change.
		//*** Thus it does not make sense to use tagnme here, and in general tagnames are generally not unique, or guaranteed to stay unqiue.
		//*** So validation of the search box on the Eureka webpae does not make sense, and is skipp here.

		
		//-----
		
		//Launch FIREFOX browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driverFireFox = new FirefoxDriver(optionsFF);
		
		//Open AUT web page
		driverFireFox.get("https://www.edureka.co/");
		
		//Determine uniqueness of the tagname for the searchbox.
		List<WebElement> taglistFireFox = driverChrome.findElements(By.tagName("input"));
		System.out.println("Number of tags total as that of the searchbox in FireFox: " + taglistFireFox.size() + "\n");	
		
		//Validate search box element is displayed (i.e., can be found)
		//*** SKIPPED for same reason as commented above for the Chrome driver.


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
