package pkgSeleniumCoursePart2.FilesFromTabresh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.By;

public class Facebook {

	public static void main(String[] args) {
		
		//Launch Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Open AUT web page
		driver.get("https://www.facebook.com/");
		
		//Locators...
		//ID
		//Fails because the id is made dynamic by Facebook web developers. Last letter in id changes.
		//driver.findElement(By.id("u_0_e")).sendKeys("Ed");
		
		//Name
		driver.findElement(By.name("lastname")).sendKeys("Grinvalds");
				
		//ClassName
		//Does not work as expected because first instance of className inputtext is the
		//first occurring field of this class, the "Email or Phone" field at top of the webpage,
		//which is how a search is done by Selenium driver from top -left to bottom-right.
		driver.findElement(By.className("inputtext")).sendKeys("Ed");
		driver.findElement(By.className("inputtext")).sendKeys("Grinvalds");
		
		//Linktext
		//driver.findElement(By.linkText("Create a Page")).click();
		//driver.navigate().back();

		//PartialLinktext
		//driver.findElement(By.linkText("n a")).click();
		//driver.navigate().back();
		
		//Css Locator
		//Not good because any changein the hierarchy structure will cause a subsequent failure.
		driver.findElement(By.cssSelector("#email")).sendKeys("edg@gmail.com");
		
		//TagName
		//Create a list of input tags
		List<WebElement> taglist1 = driver.findElements(By.tagName("Input"));
		List<WebElement> taglist2 = driver.findElements(By.tagName("a"));
		System.out.println(taglist1.size());
		System.out.println(taglist2.size());
		
		//Xpath
		
		//Exit the browser
		driver.quit();
	}

}
