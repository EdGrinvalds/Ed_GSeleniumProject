package pkgSeleniumCoursePart6.FilesFromTabresh;


import org.testng.annotations.Test;

public class Prioritization {

	@Test(priority = 0)
	public void Pune() {
		System.out.println("This is the Test Case 1");
	}

	@Test(priority = 1)
	public void Banglore() {
		System.out.println("This is the Test Case 2");
	}

	@Test(priority = 2)
	public void Mumbai() {
		System.out.println("This is the Test Case 3");
	}

	@Test(priority = 3)
	public void Hyderabad() {
		System.out.println("This is the Test Case 4");
	}
	
	@Test(priority = 4)
	public void Madhurai() {
		System.out.println("This is the Test Case 5");
	}
}
