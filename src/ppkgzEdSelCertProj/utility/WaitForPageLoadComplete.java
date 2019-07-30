package ppkgzEdSelCertProj.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForPageLoadComplete {
	
	private int max_secs;

	public WaitForPageLoadComplete (int max_wait_seconds) {
		
		max_secs = max_wait_seconds;
	}
	
	public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait myCustomWait = new WebDriverWait(driver, max_secs);
        myCustomWait.until(pageLoadCondition);
	}
	
}
