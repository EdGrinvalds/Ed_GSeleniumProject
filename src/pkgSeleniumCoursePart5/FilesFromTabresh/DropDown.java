package pkgSeleniumCoursePart5.FilesFromTabresh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://seleniumautomationpractice.blogspot.com/2017/10/functionisogramigoogleanalyticsobjectri.html");
		
		//Initialize the Select Class and navigate to the dropdown element
		Select oSelect = new Select(driver.findElement(By.name("continents")));
		
		Thread.sleep(5000);
		
		//Select Africa using Visibletext option
		oSelect.selectByVisibleText("Africa");
		Thread.sleep(5000);
		
		//Select South America using Index Value
		oSelect.selectByIndex(4);
		Thread.sleep(5000);
		
		//Select Antartica using Value
		oSelect.selectByValue("g");
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
