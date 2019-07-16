package pkgSeleniumCoursePart5.FilesFromTabresh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	public static void main(String[] args) throws Exception {
		
		// Open Browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\drivers\\chromedriver_2.46.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//Open AUT
		driver.get("http://jqueryui.com/droppable/");
		
		/*
		 * Initialize 3 WebElements and 
		 * drag Element from A location to B Location using Actions Class
		 */

		WebElement iFrame = driver.findElement(By.tagName("iframe"));
		
		driver.switchTo().frame(iFrame);
		
		WebElement Source = driver.findElement(By.id("draggable"));
		
		WebElement Target = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(Source, Target).perform();
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
