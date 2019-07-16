package pkgSeleniumCoursePart8.FilesFromTabresh.withoutPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_001_SignIn {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		// Creating object of HomePage
		HomePage homePage= new HomePage(driver);
		
		// Click on Sign in button
		homePage.clickOnSignInButton();
		
		// Creating an object of LoginPage
		LoginPage loginPage= new LoginPage(driver);
		
		// Sign in
		loginPage.signIn("Abhresh", "pwd123");
		
		//Quit browser
		driver.quit();
		
	}
}