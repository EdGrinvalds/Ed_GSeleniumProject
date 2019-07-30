package ppkgzEdSelCertProj.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClass {
	public static WebDriver driver;
	public static boolean bResult;
	
	public  BaseClass(WebDriver driver){
		
		BaseClass.driver = driver;
		BaseClass.bResult = true;
		
	}

}
