package pkgSeleniumCoursePart5.FilesFromTabresh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://seleniumautomationpractice.blogspot.com/2017/10/functionisogramigoogleanalyticsobjectri.html");

		//Initialize the Select Class and focus on the webelement
		Select oSelect = new Select(driver.findElement(By.name("selenium_commands")));
		
		//Select and Deselect Switch Commands
		oSelect.selectByVisibleText("Switch Commands");
		
		Thread.sleep(5000);
		
		oSelect.deselectByIndex(2);
		
		Thread.sleep(5000);
		
		//To run the loop to select all the options one by one or in one go I need the total count.
		List<WebElement> oList = oSelect.getOptions();
			
		//this will help me to count the options from OList and give me the total options
		int oListTotal = oList.size();
		
		System.out.println(oListTotal);
		
		//Start a loop where I am going to select and Deselect multiple options and then I will come out of the loop
		for(int i=0; i<oListTotal; i++) {
			
			//to get the text of the option available
			String oValue = oList.get(i).getText();
			
			// print the text of the option
			System.out.println(oValue);
			Thread.sleep(5000);
			
			// select option based on index value
			oSelect.selectByIndex(i);
			Thread.sleep(5000);
			
			/*
			 * // deselect option based on index value 
			 * oSelect.deselectByIndex(i);
			 * Thread.sleep(5000);
			 */
		}
		
		//DeSelect all
		oSelect.deselectAll();
		Thread.sleep(5000);
		
		driver.quit();
		
}
}