package pkgSeleniumCoursePart5.FilesFromTabresh;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardMouseActions {

	public static void main(String[] args) {

		//Open Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		//Open AUT
		driver.get("https://seleniumautomationpractice.blogspot.com/2017/10/automation-testing-sample_28.html");

		/*Using Actions Class perform Keyboard Operations to Type into the text box
		 * and also perform right click and double click using mouse operations
		 */

		WebElement Name = driver.findElement(By.id("ts_first_name"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(Name)
		.keyDown(Name, Keys.SHIFT)
		.sendKeys(Name, "abhresh")
		.keyUp(Name, Keys.SHIFT)
		.doubleClick(Name)
		.contextClick(Name)		
		.build().perform();
	}

}






