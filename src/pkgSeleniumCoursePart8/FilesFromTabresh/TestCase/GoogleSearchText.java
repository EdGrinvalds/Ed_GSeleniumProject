package pkgSeleniumCoursePart8.FilesFromTabresh.TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pkgSeleniumCoursePart8.FilesFromTabresh.Page.GoogleHomePageObjects;
import pkgSeleniumCoursePart8.FilesFromTabresh.Page.SeleniumHomePageObjects;

public class GoogleSearchText {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Training\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.google.com");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		GoogleHomePageObjects page = new GoogleHomePageObjects(driver);
		
		page.SearchOnGoogle();
		
		page.ClickSel();
		
		SeleniumHomePageObjects page2 = new SeleniumHomePageObjects(driver);
		
		page2.GoToDonwload();
		Thread.sleep(3000);
		page2.GoToProjectPage();
		Thread.sleep(3000);
		page2.GoToHomePage();
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}
