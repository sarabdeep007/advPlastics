//package AmazingProject.Test;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Iterator;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import io.cucumber.java.sl.Ce;
//
//public class Excel2 {
//	
//	public static void main(String args[]) throws 
//IOException
//	{
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/ExcelStuff/Demo1.xlsx");
//		
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		int numOfSheets = workbook.getNumberOfSheets();
//		System.out.println(numOfSheets);
//		
//		for(int i=0; i<numOfSheets;i++)
//		{
//			if(workbook.getSheetAt(i).getSheetName().contains("TestingWorld"))
//			{
//				System.out.println("labb gyi..");
//				
//				XSSFSheet sheet = workbook.getSheetAt(i);
//				
//				
//				
//				Iterator<Row> row = sheet.rowIterator();
//				Row firstRow  = row.next(); 
//				
//				
//				Iterator<Cell> cellsFirstRow = firstRow.cellIterator();
//				int testColumNum = 0;
//				int k=0;
//				while(cellsFirstRow.hasNext())
//				{
//					
//					Cell cell = cellsFirstRow.next();
//					
//					System.out.println(cell.getStringCellValue());
//					if(cell.getStringCellValue().contains("Test Case"))
//					{
//						testColumNum = k;
//					}
//					k++;
//				}
//				
//				System.out.println(testColumNum);
//				System.out.println("ithe");
//				
//				while(row.hasNext())
//					
//				{
//					Row r = row.next();
//					
//					if(r.getCell(testColumNum).getStringCellValue().equalsIgnoreCase("Add Profile"))
//					{
//						System.out.println("andar aan");
//						//<Cell> resultRowCells = r.cellIterator();
//						Iterator<Cell>  cv=r.cellIterator();
//						while(cv.hasNext());
//						{
//							Cell c = cv.next();
//							System.out.println(c.getStringCellValue());
//						}
//					}
//					else
//					{
//						System.out.println("nai labba Purchases");
//						System.out.println(r.getCell(testColumNum).getStringCellValue());
//					}
//					
//				}
//				
//				
//				
//				
//				
//				
//				
//				
//			}
//		}
//		
//	}
//	
//}
