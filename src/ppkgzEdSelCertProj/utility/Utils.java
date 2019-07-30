package ppkgzEdSelCertProj.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pkgSeleniumCoursePart5.CaseStudyPart5.WaitForPageLoadComplete;

public class Utils {
	
	public static WebDriver driver = null;
	//public static WaitForPageLoadComplete waitComplete = null;
		
	public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception {
		
		String sBrowserName;
		
		try{
			sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
			if(sBrowserName.equals("Chrome"))
			{
				//Instantiate Chrome driver.
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe" );
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito --start-maximized");
				driver = new ChromeDriver(options);
				//Next statement not necessary when passing "--start-maximized" parm. in as an option when creating a driver object,
				//but left in here as reference and to ensure window maximized.
				driver.manage().window().maximize();
				Log.info("New driver instantiated maximized and incognito");
				
				
				//Setup global timeout waits for this Case Study's test script.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//- Implicit timeout on all driver actions at 15 seconds.
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
				Log.info("Implicit wait applied to the instantiated driver for 10 seconds");
			    //- Script timeout for any script run at 5 minutes (300 seconds).
				driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
				Log.info("Script timeout wait for completion applied to the instantiated driver for 5 minutes (300 seconds)");
				//- Maximum page load timeout set at 1 minute (60 seconds).
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS );
				Log.info("Maximum page load wait applied to the instantiated driver for 5 minutes total (300 seconds)");
				
				//Open web page that is setup in the utility class's Openbrowser() method.
			    driver.get(Constant.URL);
			    Log.info("Web application launched successfully in browser");
			    
				//Initialize instance of class for waiting for page to complete loading
				//This is a custom wait created since the Selenium provided driver.manage().timeouts().pageLoadTimeout(time, timeUnits)
				//setup above did not always appear to work as expected in certain situations.
				WaitForPageLoadComplete waitComplete = new WaitForPageLoadComplete();
		    
			}
		
		}
		catch (Exception e)
		{
			
			Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		
		}
		return driver;
	}
	
	public static String getTestCaseName(String sTestCase)throws Exception{
		String value = sTestCase;
		try
		{
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");	
			value = value.substring(posi + 1);
			return value;
				}catch (Exception e){
			Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
		}
	}
	
	public static void mouseHoverAction(WebElement mainElement, String subElement){
		
		 Actions action = new Actions(driver);
         action.moveToElement(mainElement).perform();
         if(subElement.equals("Accessories")){
        	 action.moveToElement(driver.findElement(By.linkText("Accessories")));
        	 Log.info("Accessories link is found under Product Category");
         }
         if(subElement.equals("iMacs")){
        	 action.moveToElement(driver.findElement(By.linkText("iMacs")));
        	 Log.info("iMacs link is found under Product Category");
         }
         if(subElement.equals("iPads")){
        	 action.moveToElement(driver.findElement(By.linkText("iPads")));
        	 Log.info("iPads link is found under Product Category");
         }
         if(subElement.equals("iPhones")){
        	 action.moveToElement(driver.findElement(By.linkText("iPhones")));
        	 Log.info("iPhones link is found under Product Category");
         }
         action.click();
         action.perform();
         Log.info("Click action is performed on the selected Product Type");
	 }
	 
	 public static void waitForElement(WebElement element){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 	}
		
	 public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
			try{
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyMMdddd_HH_mm_ss");  
				Date date = new Date();  
				//System.out.println(formatter.format(date));
				String datetime = formatter.format(date);
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName + "-" + datetime + ".jpg"));
				
			} catch (Exception e){
				
				Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
				throw new Exception();
				
			}
			
	 }
	 
}
