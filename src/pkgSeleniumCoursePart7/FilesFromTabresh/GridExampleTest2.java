package pkgSeleniumCoursePart7.FilesFromTabresh;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridExampleTest2 {

	public RemoteWebDriver driver;
	public static String appURL = "http://www.google.com";

	@Parameters("System")
	@BeforeTest
	public void openBrowser(String device) throws MalformedURLException {
		if (device.equalsIgnoreCase("pc2")) {
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://192.168.1.175:5566/wd/hub"), cap);

		} else if (device.equalsIgnoreCase("pc1")) {
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://192.168.1.4:5555/wd/hub"), cap);
		} 
	}

	@Test
	public void testGooglePageTitle() {
		System.out.println("*** Navigation to Application ***");
		driver.navigate().to(appURL);
		String strPageTitle = driver.getTitle();
		System.out.println("*** Verifying page title ***");
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}