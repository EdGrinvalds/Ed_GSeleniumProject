package pkgSeleniumCoursePart4.FilesFromTabresh;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PAlert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://seleniumautomationpractice.blogspot.com/2018/01/blog-post.html");
		
		driver.findElement(By.id("prompt")).click();
		
		//Prompt type alert (asks user for input and usually 2 options to OK the entr(ies) or cancel)
		Alert pA = driver.switchTo().alert();
		
		Thread.sleep(2000);
		//This sendKeys is NOT working for some reason.
		pA.sendKeys("ABhresh SUgandh");
		
		pA.accept();
		
	}

}
