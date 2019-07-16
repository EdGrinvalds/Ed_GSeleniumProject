package pkgSeleniumCoursePart4.FilesFromTabresh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MDbox {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//*[@class='_2zrpKA _1dBPDZ' and @type='text']")).sendKeys("Edureka");
		
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();

	}

}
