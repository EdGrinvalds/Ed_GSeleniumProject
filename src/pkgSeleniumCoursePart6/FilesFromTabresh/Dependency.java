package pkgSeleniumCoursePart6.FilesFromTabresh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dependency {

	WebDriver driver;

	@Test
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\drivers\\chromedriver_2.46.exe");
		driver = new ChromeDriver();
	}

	@Test(dependsOnMethods = "OpenBrowser")
	public void OpenAUT() {
		driver.get("http://newtours.demoaut.com/");
	}

	@Test(dependsOnMethods = "OpenAUT")
	public void Login() throws InterruptedException {
			
		// Enter UserID
		driver.findElement(By.name("userName")).sendKeys("tutorial");

		// Enter Password
		driver.findElement(By.name("password")).sendKeys("tutorial");

		// Click on Sign in button
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}

	@Test(dependsOnMethods = "Login")
	public void Logout() throws InterruptedException {
		// Click on Sign off
		driver.findElement(By.linkText("SIGN-OFF")).click();
		Thread.sleep(3000);
	}

	@Test(dependsOnMethods = "Logout")
	public void CloseBrowser() {
		driver.close();
	}
}

