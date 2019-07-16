package pkgSeleniumCoursePart8.FilesFromTabresh.HandsOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSel {

public static WebDriver driver;
	
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");		driver = new ChromeDriver();
		
		driver.get("https://www.seleniumhq.org/");	
		
		SeleniumHomePageObjects homepage = new SeleniumHomePageObjects(driver);
		
		homepage.GoToDonwload();
		
		homepage.GoToHomePage();
		
		homepage.GoToProjectPage();
		
		
	}

}
