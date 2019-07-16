package pkgSeleniumCoursePart4.FilesFromTabresh;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CAlert {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://seleniumautomationpractice.blogspot.com/2018/01/blog-post.html");
		
		driver.findElement(By.id("confirm")).click();
		
		//Confirmation type alert (2 choice button alert, confirm or not, Ok and Cancel for eg.)
		Alert cA = driver.switchTo().alert();
		
		cA.dismiss();


	}

}
