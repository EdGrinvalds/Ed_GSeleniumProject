package ppkgSeleniumCoursePart10.FilesFromTabreah.testCases;

import ppkgSeleniumCoursePart10.FilesFromTabreah.actions.ActionKeywords;
import ppkgSeleniumCoursePart10.FilesFromTabreah.utility.ExcelUtility;

public class Execution {

	public static void main(String[] args) throws Exception {
	
		String path = "F:\\Training\\EdurekaPrograms\\Edureka_24thJune\\src\\module10\\testData\\MyDataEngine.xlsx";
		
		ExcelUtility.setupExcel(path, "Sheet1");
		
		for(int i=0; i<=3; i++) 
		{
			String Keyword = ExcelUtility.getData(i, 1);
			if(Keyword.equals("OpenBrowser")) 
			{
				ActionKeywords.OpenBrowser();
			}
			else if (Keyword.equals("Navigate")) 
			{
				ActionKeywords.Navigate();
			}
			else if(Keyword.equals("ClickGmail")) 
			{
				ActionKeywords.ClickGmail();
			}
		}

	}

}
