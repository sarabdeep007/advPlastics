package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static ArrayList<String> getExcelData(String sheetName, String colName)
	{
		ArrayList<String> arr = new ArrayList<String>();
		String excelFilePath = System.getProperty("user.dir")+"/src/main/java/Resources/testData.xlsx";
		FileInputStream fileInputStream = null;
		try {
			 fileInputStream = new FileInputStream(excelFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//String expectedSheetName = "TestDataSheet";
		
		int numberOfSheets = workbook.getNumberOfSheets();
		System.out.println("number of sheets: "+ numberOfSheets);
		int targetSheetNumber = 0;
		
		for(int i=0; i<numberOfSheets ; i++)
		{
			if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase(sheetName))
			{
				targetSheetNumber = i;
			}
		}
		
		
		XSSFSheet sheet = workbook.getSheetAt(targetSheetNumber);
		
		Iterator<Row> rowIterator = sheet.rowIterator();
		Row firstRow = rowIterator.next();
		
		Iterator<Cell> cellIterator = firstRow.cellIterator();
		
		int numberofColumns = 0;
		int targetColumnNumber = 0;
		
		while(cellIterator.hasNext())
		{
			Cell cell = cellIterator.next();
			if(cell.getStringCellValue().equalsIgnoreCase(colName))
			{
				targetColumnNumber = numberofColumns;
			}
			
			numberofColumns++;
			
		}
		
		while(rowIterator.hasNext())
		{
			Row row = rowIterator.next();
			arr.add(row.getCell(targetColumnNumber).getStringCellValue());
		}
		
		return arr;
		
	}
	
	public static void main(String[] args)
	{
		ArrayList<String> abc = getExcelData("TestDataSheet", "PageHeadings");
		
		System.out.println(abc);
		
	}

}
