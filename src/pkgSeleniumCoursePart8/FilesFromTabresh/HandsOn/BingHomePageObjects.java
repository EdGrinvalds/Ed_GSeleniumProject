package pkgSeleniumCoursePart8.FilesFromTabresh.HandsOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingHomePageObjects {

	public BingHomePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name="q")
	public WebElement TxtSearch;
	
	@FindBy(name="go")
	public WebElement btnSearch;
	
	@FindBy(linkText = "Selenium - Web Browser Automation")
	public WebElement ClickLink;
	
	public void SearchBing() {
		TxtSearch.clear();
		TxtSearch.sendKeys("SeleniumHQ");
		btnSearch.submit();

		TxtSearch.clear();
		TxtSearch.sendKeys("Pune");
		btnSearch.click();

		
		TxtSearch.clear();
		TxtSearch.sendKeys("Edureka");
		btnSearch.click();
		
		TxtSearch.clear();
		TxtSearch.sendKeys("SeleniumHQ");
		btnSearch.click();
	}
	
	public void LinkSel() {
		ClickLink.click();
	}
	
}
