package pkgSeleniumCoursePart5.FilesFromTabresh;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHovering {

	public static void main(String[] args) throws InterruptedException {
		
		//Open browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Page Load
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//Open AUT
		driver.get("https://www.myntra.com/");

		//Search Jackets
		driver.findElement(By.xpath("//*[@class = 'desktop-searchBar']")).sendKeys("Mens Jackets");

		//driver.findElement(By.xpath("//*[@class = 'desktop-searchBar']")).submit();
		
		//Click on Search Button
		driver.findElement(By.xpath("//*[@class=\"desktop-submit\"]")).click();
		
		//Using Actions Class perform Hovering on the Element
		
		Actions act = new Actions(driver);
		
		WebElement mh = driver.findElement(By.xpath("//*[@class = 'desktop-searchBar']//following::img[3]"));
		
		act.moveToElement(mh).perform();
		
		Thread.sleep(7000);
		
		driver.quit();
		
	}

}
