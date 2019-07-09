package pkgSeleniumCoursePart4.CaseStudyPart4;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	

public class CaseStudy4 {

	public static void main(String[] args) throws InterruptedException {
 		
		//***********
		//
		//SETUP
		//
		//***********
		//
		//Setup so Chrome launches incognito so browser history is not maintained producing autocomplete 
		//urls for navigations which may cause false positives test results.
		ChromeOptions optionsChrome = new ChromeOptions();
		optionsChrome.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, optionsChrome);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(capabilities);
		
		//Setup global timeout waits for this Case Study's test script.
		driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS );
		
		
		//********************************************
		//
		//CASE STUDY TEST SCRIPT
		//
		//Test Steps and duplicated here exactly as given in Case Study for Module 4...
		//
		//
		//A person wants to check for the one-way flights from Bengaluru to Lucknow for 5 passengers
		//(3 Adults and 2 children) on Indigo portal for the current date. Automate the same using
		//(https://www.goindigo.in/?linkNav=home_header) portal. The steps are as below.
		//
		//********************************************
		
		//*****
		// 1. Launch the browser with “https://www.goindigo.in/?linkNav=home_header”
		//
		//*****
		
		driver.get("https://www.goindigo.in/?linkNav=home_header");
		
		driver.manage().window().maximize();
		

		//*****
		// 2. Select “One way” in the option
		//	  NOTE1: Since the One Way radio button is clicked when first navigating to the web page,
		//			 included a validation to ensure the button is in the selected (ie, clicked) state.
		//*****
		
		driver.findElement(By.xpath("//*[@id='oneWayTrip']")).click();
		boolean bOneWayVerifyClicked = driver.findElement(By.xpath("//*[@id='oneWayTrip']")).isSelected();
		System.out.println("Clicking on the default selected One Way radio button validation returned an isSelected boolean value of: " + bOneWayVerifyClicked);
		
		//*****
		// 3. Fill all the details specified above
		//
		//*****
		
			// Fill out "From" city text box:
			driver.findElement(By.xpath("//input[@type='text' and @name='or-src']")).click();
			driver.findElement(By.xpath("//input[@type='text' and @name='or-src']")).sendKeys("Bengaluru\n");		
		
			// Fill out "To" city text box:
			WebDriverWait wait1 = new WebDriverWait(driver, 15);
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text' and @name='or-dest']"))).click();
			WebDriverWait wait2 = new WebDriverWait(driver, 15);
			boolean bBookFlightTabDisplayed = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='bookFlightTab']"))).isDisplayed();
			System.out.println("Book flight popup is displayed: " + bBookFlightTabDisplayed);
			driver.findElement(By.xpath("//input[@type='text' and @name='or-dest']")).sendKeys("Lucknow\n");
			
			// Select the "current day":
			//
			// NOTE2: The case study indicate "current day" which is the default selected class '  selected-date ui-datepicker-current-day',
			//        which implies this is the correct date to use for this case study, and will be done here.
			WebDriverWait wait3 = new WebDriverWait(driver, 15);
			boolean bCalendarDisplayed = wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='  ui-datepicker-today']"))).isDisplayed();
			System.out.println("Calendar popup is displayed: " + bCalendarDisplayed);
			driver.findElement(By.xpath("//*[@class='  ui-datepicker-today']//following::a[1]")).click(); 
			 
			// Indicate 3 adults traveling
			driver.findElement(By.xpath("//input[@type='text' and @name='passenger']")).click();
			driver.findElement(By.xpath("//*[@class='counter adult-pax']//following::button[1]")).click();
			driver.findElement(By.xpath("//*[@  class='counter adult-pax']//following::button[1]")).click();
			
			
			//Indicate 2 children traveling
			driver.findElement(By.xpath("//*[@class='counter child-pax']//following::button[1]")).click();
			driver.findElement(By.xpath("//*[@class='counter child-pax']//following::button[1]")).click();	
			
		
		//*****
		// 4. Click on search button
		//
		//*****
			
		driver.findElement(By.xpath("//button[@class='btn btn-primary pax-done']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary block bold ig-search-btn ig-common-cta addLoader']")).click();
		
		//*****
		// 5. Wait for the page to load and list all the flights available
		//	  NOTE3: An implicit wait for page loading call was made above as:
		//				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS );
		//*****
		
		WebDriverWait wait4 = new WebDriverWait(driver, 15);
		List<WebElement> listOfFlights = wait4.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='flightNo']")));
		System.out.println("Total number of flights in the flight list: " + listOfFlights.size());
		
		//***********
		//
		//CLEANUP
		//
		//***********
		
		//Exit the all opened browser sessions.
		driver.quit();

	}
}
