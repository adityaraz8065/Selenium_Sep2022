package testscripts;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataExportPoi 
{
	@Test
	public void testDataExport() throws Exception
	{
		FileOutputStream fos=new FileOutputStream("F:\\Selenium_Script2022\\Library\\Sbi Project\\TestData\\DataExpor.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(); 
		XSSFSheet s=wb.createSheet("Result1");
		XSSFRow r=s.createRow(0);
		r.createCell(0).setCellValue("Selenium");
		r.createCell(1).setCellValue("Appium");
		wb.write(fos);
		
	}
}
