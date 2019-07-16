package pkgSeleniumCoursePart9.FilesFromTabresh;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pkgSeleniumCoursePart9.FilesFromTabresh.FormPage;

public class DDT {

	WebDriver driver;
	Workbook wb;
	Sheet sh;
	int norows;
	int nocols;
	
	
	@BeforeTest
	public void OpenBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\edgri\\Desktop\\SeleniumCertificationTraining\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");		driver = new ChromeDriver();
	
		driver.get("https://seleniumautomationpractice.blogspot.com/2017/10/automation-testing-sample_28.html");
	}
	
	
	@DataProvider
	public Object[][] testDataFeed() throws Exception{
		
		//to import the Excel file and fetch the data bytes from the file and pass it to the script
		FileInputStream fis = new FileInputStream("C:\\Users\\edgri\\eclipse-workspace-jee-2019-03\\Ed_GSeleniumProject\\src\\pkgSeleniumCoursePart9\\FilesFromTabresh\\TestData.xlsx");
		
		wb = WorkbookFactory.create(fis);
		
		sh = wb.getSheet("Sheet1");
		
		norows = sh.getLastRowNum();
		//NOTE1:
		//Add 1 to norows immediately after getting the last row but ore important before instantiating the formData 2-dimensional array. Need to have an array that is 10 rows deep.
		norows = norows + 1;
		System.out.println(norows);
		
		nocols = sh.getRow(0).getLastCellNum();
		System.out.println(nocols);
		
		Object[][] formData = new Object[norows][nocols];
		
		for(int row=0; row<norows; row++) 
		{
			System.out.println(row);
			
			for(int col=0; col<nocols; col++) 
			{
				
				//fetch the data from the excel file and capture those bytes of the cell
				formData[row][col] = sh.getRow(row).getCell(col).toString();
				
			}
			
		}
		
		return formData;
	}
	
	@Test(dataProvider = "testDataFeed")
	public void FormFill(String fName, String lName, String add) throws Exception {
		
	FormPage fp = new FormPage(driver);
	fp.FormFill(fName, lName, add);
	
	}
	
	@AfterTest
	public void QuitBrowser() {
		
		driver.quit();
	}
}








