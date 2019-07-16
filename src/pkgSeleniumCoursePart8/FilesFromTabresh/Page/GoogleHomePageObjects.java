package pkgSeleniumCoursePart8.FilesFromTabresh.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePageObjects {

	public GoogleHomePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="q")
	public WebElement txtSearch;
	
	@FindBy(xpath = "//*[@type='submit' and @class='Tg7LZd']")
	public WebElement btnSearch;
	
	@FindBy(partialLinkText = "Selenium - Web")
	//@FindBy(xpath = "//h3[text()='Selenium - Web Browser Automation']")
	public WebElement LinkClick;
	
	public void SearchOnGoogle() {
		
		txtSearch.sendKeys("SeleniumHQ");
		txtSearch.submit();
	}
	
	public void ClickSel() {
		LinkClick.click();
	}
}
