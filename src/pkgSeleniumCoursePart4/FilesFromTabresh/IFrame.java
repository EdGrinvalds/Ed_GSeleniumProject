package pkgSeleniumCoursePart4.FilesFromTabresh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame {

	public static void main(String[] args) throws InterruptedException {
		// Open browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://seleniumautomationpractice.blogspot.com/2019/07/example-of-html-iframe-alternative.html");
		
		driver.switchTo().frame("ID_Frame1");
		
		driver.findElement(By.name("ts_first_name")).sendKeys("Abhresh");

		driver.findElement(By.name("ts_last_name")).sendKeys("Sugandhi");
		
		driver.switchTo().parentFrame();
		
		WebElement frame = driver.findElement(By.id("ID_Frame2"));
				
		driver.switchTo().frame(frame);

		driver.findElement(By.name("ts_first_name")).sendKeys("Sugandhi");

		driver.findElement(By.name("ts_last_name")).sendKeys("Abhresh");

		Thread.sleep(6000);
		
		//driver.close();
	}

}
