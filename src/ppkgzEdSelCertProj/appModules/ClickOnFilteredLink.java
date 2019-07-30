package ppkgzEdSelCertProj.appModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ppkgzEdSelCertProj.pageObjects.BaseClass;

public class ClickOnFilteredLink extends BaseClass {

	public ClickOnFilteredLink(WebDriver driver) {
		
		super(driver);
		
	}
	
	public static void withSubstrings ( String filter, String selectSubstring ) throws Exception {
	
		boolean SubstringFound = false;
		String currentEle = null;
		
		List <WebElement> linkOccurence = driver.findElements(By.partialLinkText(filter));
		for(WebElement element : linkOccurence)
		{
			//System.out.println("Link occurrence with text string \"Selenium\" in it: " + element.getText());
			currentEle = element.getText();
			if(currentEle.contains(selectSubstring)) {
				
				SubstringFound = true;
				//String fullStringToClick = currentEle.toString();		
				//driver.findElement(By.linkText(fullStringToClick)).click();
				break;
				
			}
		}
			if( SubstringFound ) {
				
				String fullStringToClick = currentEle.toString();		
				driver.findElement(By.linkText(fullStringToClick)).click();
				
			} else {
				
				throw new Exception("Substring not found: " + selectSubstring);
				
			}
				
	}
	
}
