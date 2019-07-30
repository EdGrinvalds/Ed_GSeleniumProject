package ppkgSeleniumCoursePart10.FilesFromTabreah.utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	static Workbook wb;
	static Sheet sh;
	
	public static void setupExcel(String path, String sheetnum) throws Exception {
		
		FileInputStream fis = new FileInputStream(path);
		
		wb = WorkbookFactory.create(fis);
		
		sh = wb.getSheet(sheetnum);
		
	}
	
	public static String getData(int rownum, int cellnum) {
				
		String data = sh.getRow(rownum).getCell(cellnum).toString();
		
		return data;
		
	}
	
	
}
