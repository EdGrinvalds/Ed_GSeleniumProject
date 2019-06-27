package pkgSeleniumCourseModule2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicCommands {

	public static void main(String[] args) {
		
		//Launch browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open web page
		driver.get("https://www.facebook.com");
		
		//
	}

}
