package ppkgSeleniumCoursePart10.FilesFromTabreah.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionKeywords {

	static WebDriver driver;
	
	public static void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "F:\\Training\\Installation_stuff\\ExeFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("browser opened succesfully");
	}
	
	public static void Navigate() {
		driver.navigate().to("https://www.google.com");
		System.out.println("AUT opened succesfully");		
	}
	
	public static void ClickGmail() {
		driver.findElement(By.linkText("Gmail")).click();
		System.out.println("Clicked Gmail link succesfully");
	}
}
