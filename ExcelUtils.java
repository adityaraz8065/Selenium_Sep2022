package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
	XSSFWorkbook wb;
	XSSFSheet s;
	ExcelUtils(String excelpath,String sheetname) throws Exception
	{
		FileInputStream fis=new FileInputStream(excelpath);
		wb=new XSSFWorkbook(fis); 
		s=wb.getSheet(sheetname);
	}
	public void setCellData(int rowindex,int colindex,String result,String excelpath) throws Exception
	{
		
		s.getRow(rowindex).createCell(colindex).setCellValue(result);
		FileOutputStream fos=new FileOutputStream(excelpath);
		wb.write(fos);
	}
	public String getCellData(int rowindex,int colindex)
	{
		return s.getRow(rowindex).getCell(colindex).getStringCellValue();
	}
}
