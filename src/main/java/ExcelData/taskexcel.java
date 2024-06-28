package ExcelData;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class taskexcel 

{
	public static void main (String[] args) throws IOException 
	{
		
		// to get into the work book
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// to create sheet
		XSSFSheet sheet = workbook.createSheet("Write data");
		
		// Store the data
		
		Object [][] data = 
			{
				{"Name","Year","City"},
				{"Dhoni","1983","Ranchi"},
				{"Cummins","1990","Melboune"},
				{"Aswin", "1988", "Chennai"}
			};
		  // upload data in sheet
		
		int rowCount=0;
		
		for(Object [] row1 : data) {
			XSSFRow row = sheet.createRow(rowCount++);
			
			int columnCount=0;
			
			for (Object column1 :row1)
			{
			XSSFCell cell = row.createCell(columnCount++);
			
			if(column1 instanceof String ) {
				cell.setCellValue((String) column1);
			} else if (column1 instanceof Integer) 
			{
				cell.setCellValue ((Integer)column1);
			}
			}
		}
		try {
			FileOutputStream output = new FileOutputStream ("C:\\Users\\Jenner\\eclipse-workspace\\ExcelTask\\src\\main\\java\\ExcelData\\Player Details.xlsx");
	        
				workbook.write(output);
			} catch (IOException e) {
			 
				e.printStackTrace();
			}	
		    workbook.close(); 
	} 
	
	}
