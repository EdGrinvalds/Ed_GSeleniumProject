package pkgSeleniumCoursePart7.FilesFromTabresh;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridExampleTest {

	public RemoteWebDriver driver;
	public static String appURL = "http://newtours.demoaut.com/";

	@Parameters("System")
	@BeforeTest
	public void openBrowser(String device) throws MalformedURLException {
		if (device.equalsIgnoreCase("pc2")) {
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://192.168.1.55:5555/wd/hub"), cap);

		} else if (device.equalsIgnoreCase("pc1")) {
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://192.168.1.55:5555/wd/hub"), cap);
		}
	}

	@Test
	public void testNewToursLogin() throws InterruptedException {
		//Get the URL of the AUT
		driver.get(appURL);
		// Enter UserID
		driver.findElement(By.name("userName")).sendKeys("tutorial");

		// Enter Password
		driver.findElement(By.name("password")).sendKeys("tutorial");

		// Click on Sign in button
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);

		// Click on Sign off
		driver.findElement(By.linkText("SIGN-OFF")).click();
		Thread.sleep(3000);
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}