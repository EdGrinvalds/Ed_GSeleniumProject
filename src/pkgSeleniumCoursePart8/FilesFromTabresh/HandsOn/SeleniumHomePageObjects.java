package pkgSeleniumCoursePart8.FilesFromTabresh.HandsOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumHomePageObjects {

	public SeleniumHomePageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Download")
	public WebElement clickdonwload;
	
	@FindBy(linkText = "Browser Automation")
	public WebElement clickHome;
	
	@FindBy(linkText = "Projects")
	public WebElement clickProject;
	
	
	public void GoToDonwload() {
		clickdonwload.click();
	}
	
	public void GoToHomePage() {
		clickHome.click();
	}
	
	public void GoToProjectPage() {
		clickProject.click();
	}
}
