package pkgSeleniumCoursePart9.CaseStudyPart9.utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ClickOnFilteredString {

	// Click on Selenium interview questions link by filtering all links with string filter
	// and click on the link that has the selectSubstring in it to select navigating to the link with the substring.
	
	WebDriver driver;
	
	//Constructor
		public ClickOnFilteredString( WebDriver driver ) {
			this.driver=driver;
		}
	
	public void withSubstrings ( String filter, String selectSubstring ) {
	List <WebElement> linkOccurence = driver.findElements(By.partialLinkText("Selenium"));
		for(WebElement element : linkOccurence)
		{
			//System.out.println("Link occurence with text string \"Selenium\" in it: " + element.getText());
			String currentEle = element.getText();
			if(currentEle.contains("interview"))
				driver.findElement(By.partialLinkText("interview")).click();
	
		}
		
	}
	
}
	