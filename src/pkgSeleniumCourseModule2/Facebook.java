package pkgSeleniumCourseModule2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	public static void main(String[] args) {
		
		//Launch Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32");
		WebDriver driver = new ChromeDriver();
		
		//Open AUT web page
		driver.get("https://www.facebook.com/");
		
		//Locators...
		//ID
		driver.findElement(By.id("u_0_l")).sendKeys("Ed");
		
		//Name
		driver.findElement(By.name("lastname")).sendKeys("Grinvalds");
				
		//ClassName
		driver.findElement(By.className("inputtext")).sendKeys("Ed");
		driver.findElement(By.className("inputtext")).sendKeys("Grinvalds");
		
		//Linktext
		//PartialLinktext
		//Css Locator
		//TagName
		//Xpath
		

	}

}
