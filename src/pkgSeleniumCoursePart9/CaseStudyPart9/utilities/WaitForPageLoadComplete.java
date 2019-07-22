package pkgSeleniumCoursePart9.CaseStudyPart9.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForPageLoadComplete {
	
	// Executes the return.document.readyState script via the JavaScript Executor for complete status
	// until the web page returns a "complete" status. This helps with timing errors introduced by Ajax updates to the page.
	
	public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait myCustomWait = new WebDriverWait(driver, 30);
        myCustomWait.until(pageLoadCondition);
	}
	
}
