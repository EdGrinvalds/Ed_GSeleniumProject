package pkgSeleniumCoursePart8.FilesFromTabresh.HandsOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingSearchText {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.bing.com/");
		
		BingHomePageObjects page = new BingHomePageObjects(driver);
		
		page.SearchBing();
		page.LinkSel();

		Thread.sleep(5000);
		
		SeleniumHomePageObjects page2 = new SeleniumHomePageObjects(driver);
		
		page2.GoToDonwload();
		
		Thread.sleep(5000);
		
		page2.GoToHomePage();
	}

}
