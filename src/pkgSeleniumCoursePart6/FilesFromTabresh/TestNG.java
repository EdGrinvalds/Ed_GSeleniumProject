package pkgSeleniumCoursePart6.FilesFromTabresh;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestNG {

	//Initialize globally available Webdriver
	WebDriver driver;
	
	@BeforeSuite
	public void Setup() {	
	
		//Setup so Chrome launches incognito so browser history is not maintained producing autocomplete 
		//urls for navigations which may cause false positives test results.
		ChromeOptions optionsChrome = new ChromeOptions();
		optionsChrome.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, optionsChrome);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver(capabilities);
		
		//Setup global timeout waits for this Case Study's test script.
		driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS );
		
		//Maximize window
		driver.manage().window().maximize();
	}

	
	@Test(priority = 1)
	public void OpenAUT() {
		driver.get("http://newtours.demoaut.com/");
	}

	
	@Test( priority = 3 , dependsOnMethods = "Login"  )
	public void Logout() throws InterruptedException {
		
		//Initialize explicit waiter
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// Click on Sign off
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("SIGN-OFF"))).click();
	}

	
	@Parameters( {"Username", "Password"} ) 
	@Test(priority = 2, dependsOnMethods = "OpenAUT" )
	public void Login(String UName, String Pwd) throws InterruptedException {
	  //Enter UserID
	  driver.findElement(By.name("userName")).sendKeys(UName);
	  
	  // Enter Password
	  driver.findElement(By.name("password")).sendKeys(Pwd);
	  
	  // Click on Sign in button
	  driver.findElement(By.name("login")).click();
	}
	 
	
	@Test(priority = 4)
	public void CloseBrowser() throws InterruptedException {
		driver.close();
	}

	
	@AfterSuite()
	public void QuitBrowser() throws InterruptedException {
		driver.quit();
	}
	
}
