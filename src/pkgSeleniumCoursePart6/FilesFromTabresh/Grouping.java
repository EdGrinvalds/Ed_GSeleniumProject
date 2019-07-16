package pkgSeleniumCoursePart6.FilesFromTabresh;

import org.testng.annotations.Test;

public class Grouping {
	
	@Test(groups="HomePage")
	public void TC1()
	{
	System.out.println("HomePageTest1");
	}
	
	@Test(groups="ContactUs")
	public void TC2()
	{
	System.out.println("ContactUs1");
	}

	@Test(groups="ContactUs")
	public void TC3()
	{
	System.out.println("ContactUs2");
	}	
	
	@Test(groups="HomePage")
	public void TC4()
	{
	System.out.println("HomePageTest2");
	}
	
	@Test(groups="Services")
	public void TC5()
	{
	System.out.println("Services1");
	}
	
	@Test(groups="ContactUs")
	public void TC6()
	{
	System.out.println("ContactUs3");
	}
	
	@Test(groups="HomePage")
	public void TC7()
	{
	System.out.println("HomePageTest3");
	}
	
	@Test(groups="Services")
	public void TC8()
	{
	System.out.println("Services2");
	}	
	
	@Test(groups="HomePage")
	public void TC9()
	{
	System.out.println("HomePageTest4");
	}
}