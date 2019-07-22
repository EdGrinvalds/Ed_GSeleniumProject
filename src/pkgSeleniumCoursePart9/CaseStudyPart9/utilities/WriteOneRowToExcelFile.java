package pkgSeleniumCoursePart9.CaseStudyPart9.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteOneRowToExcelFile {

	// To write data/time and status into one row of an Excel file.
	
	
	//Constructor
	public WriteOneRowToExcelFile() throws Exception { }				
		

	public void dateTimeAndStatus( String filePathWithFileName, String sheetName, String statusText) throws Exception {
		
		// Create an object of type file to open Excel file.
		File excelfile = new File(filePathWithFileName);
		
		// Create an object of FileInputStream to read Excel file to get row/column count values.
		// and eventually write to the excel file via the FileInputStream via the Apache excel file cell setter methods.
		FileInputStream inStream = new FileInputStream(excelfile);
		
		// Assign a local workbook Excel object to an object of class XSSFWorkbook using the FileInputStream to the actual existing
		// Excel file to be able to read and write to the excel file.
		Workbook wb = new XSSFWorkbook(inStream);
		
		// Assign a local sheet Excel object to the workbook Excel object with the name of an existing sheet of the Excel workbook.
		Sheet sh = wb.getSheet(sheetName);

		// Get number of rows with data in them (having text strings including blank cells "", ie, not null) in the workbook.
		int numrows = sh.getLastRowNum();
		
		// Create a new row in the excel sheet.
		Row newRow = sh.createRow(numrows+1);
		
		// Create a new cell in first column of the new row.
		Cell cellCol0 = newRow.createCell(0);
		
		// Get the system time and date and write it into the first column of the new row.
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		cellCol0.setCellValue(formatter.format(date));
		
		// Write the status text passed into this method to the second column (B) in the new row.
		Cell cellCol1 = newRow.createCell(1);
		cellCol1.setCellValue(statusText);
		
		// Center status in cell.
		CellStyle cellStyle = newRow.getSheet().getWorkbook().createCellStyle();
	    cellStyle.setAlignment(HorizontalAlignment.CENTER); 
	    cellCol1.setCellStyle(cellStyle);

		// Close the input stream.
		inStream.close();  
	    
	    // Create an object of FileOutputStream class to write data into actual excel file.
	    FileOutputStream outStream = new FileOutputStream(filePathWithFileName);

	    // Write data in the ocal wb object to the actual excel file.
	    wb.write(outStream);
	    
	    // Close workbook.
	    wb.close();

	    // Close output stream.
	    outStream.close();
	    
	}
	
}
