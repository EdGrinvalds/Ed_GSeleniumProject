package pkgSeleniumCoursePart3.CaseStudyPart3;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaseStudy3 {

	public static void main(String[] args) throws InterruptedException {
 		
		//***********
		//
		//SETUP
		//
		//***********
		
		//Launch Chrome incognito so browser history is not maintained producing autocomplete urls for
		//navigations which may cause false positives test results.
		ChromeOptions optionsChrome = new ChromeOptions();
		optionsChrome.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, optionsChrome);
		
		
		//***********
		//
		//Test Steps as exactly given in Case Study for Module 3
		//
		//***********
		
		//1. Launch Chrome browser using Selenium Web Driver.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driverChrome = new ChromeDriver(capabilities);
		
		//2. Set the Selenium page load timeout after launching the browser.
		//   This timeout will be applicable to any page load.
		driverChrome.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS );
		
		//3. Navigate to “https://www.edureka.co/”.
		driverChrome.get("https://www.edureka.co/");
		
		//4. Maximize the Browser Window
		driverChrome.manage().window().maximize();
		
		//5. Set implicit wait for all the activities on the browser.
		driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
		//6. Set Selenium script timeout and execute any asynchronous script
		//   (Ex: window.setTimeout(arguments[arguments. Length-1], 500);)
		//   to validate the script timeout.
		driverChrome.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
		
		//7. Search for “Selenium” course in the search box and press “Enter”.
		driverChrome.findElement(By.xpath("//*[@id='search-inp' and @name='user_v1[query]']")).sendKeys("Selenium\n");
		
		//8. Add explicit wait for page to navigate to Selenium course and click on the course.
		WebDriverWait wait = new WebDriverWait(driverChrome, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-gi-action-hover='course hover - Selenium Certification Training ']"))).click();			
		
		//9. Wait for the whole Selenium course page to be loaded and get the title of the page.
		//   NOTE1:The "whole Selenium course page" will be loaded first due to the statement:
		//
		//          driverChrome.manage().timeouts().pageLoadTimeout(arg0, arg1);
		//
		//         earlier in this script code module above.
		//
		//		   Thus, the wait to ensure the element with the title is present (ie,loaded) will be used
		//		   here, and then the title will be gotten from the element.
		//
		//   NOTE2: The "title of the page" is interpreted as the element with tag "title".
		//          There are 2 elements currently on the Selenium course description page with the tag title.
		//          The other title is a different course not even containing the word "Selenium" in it.
		//			Also the first title is also on the tab in the Chrome browser where titles are normally displayed
		//			by the web page author.
		//			Thus, one needs to simply use the Selenium driver's getTitle method.
		//	 NOTE3:	The assignment does not indicate to output the title, but I did so here to theconsole.
		String AppTitle = driverChrome.getTitle();
		
		//10. Validate the page title to be “Selenium 3.0 WebDriver Online Training”
		//    NOTE4: The title as given here is inaccurate.
		//	  Using the following xpath, I found all elements with a tag of "title" (2 total):
		//
		//		//*title
		//
		//	  There were two as explained in Step 9 above and the title is as given in the statement to validate immediately below.
		boolean bResult = AppTitle.equals("Selenium Certification | Selenium Training | Selenium Course - Edureka");
		System.out.println("Validation of matching the title is: " + bResult);
		
		//11. Navigate back to the previous page.
		driverChrome.navigate().back();
		
		//12. Wait for whole page to be loaded and now select “All courses” from the menu option.
		//	  NOTE5: See NOTE1 comment under Step 9.
		//	  NOTE6: "All courses" does not exist on the previous page any longer on the Edureka site.
		//			 It appears as though the menu option has been renamed to "Courses" so this will be used here.
		//			 Also, the "Courses" menu option element has an attribute data-button-name that has a value
		//			 of "All Courses" so this also strongly implies that this is the menu option meant
		//			 here in this assignment.
		driverChrome.findElement(By.linkText("Courses")).click();
		
		//13. Add a fluent wait script to wait for whole page to be loaded under “All course”//Launch CHROME browser.
		//	  NOTE7: Instructor Mr. Abhresh Sugandhi indicated to not do this step 13. during on-line learning session
		//			 on 7/2/19 and confirmed in 7/3/19 session as well.
		//			 But I put it in and it appears to work as expected.
		driverChrome.navigate().back();
		FluentWait<WebDriver> waitFluent = new FluentWait<WebDriver>(driverChrome)
			       .withTimeout(10, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

		waitFluent.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.linkText("Courses"));
				element.click();
				return element;
				}
			});

		//***********
		//
		//CLEANUP
		//
		//***********
		
		//Exit the all opened browser sessions.
		driverChrome.quit();

	}
}
