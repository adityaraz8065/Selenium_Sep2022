package testscripts;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.Common;

public class LoginResult extends Common
{
	
	String excelPath="F:\\Selenium_Script2022\\Library\\Sbi Project\\TestData\\LoginData.xlsx";
	XSSFWorkbook wb;
	XSSFSheet s;
	@Test
	public void testLogin() throws Exception
	{
		// Load web page
		d.get("https://demo.cyclos.org/ui/home");
		// Read data from excel
		FileInputStream fis=new FileInputStream(excelPath);
		wb=new XSSFWorkbook(fis);
		s=wb.getSheet("Sheet1");
		for(int i=1;i<=s.getLastRowNum();i++)
		{
			// Click on Login link
			d.findElement(By.id("login-link")).click();
			// Enter user name
			d.findElement(By.xpath("//input[@type='text']")).clear();
			d.findElement(By.xpath("//input[@type='text']")).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
			String uname=d.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
			// Enter password
			d.findElement(By.xpath("//input[@type='password']")).clear();
			d.findElement(By.xpath("//input[@type='password']")).sendKeys(s.getRow(i).getCell(1).getStringCellValue());
			String password=d.findElement(By.xpath("//input[@type='password']")).getAttribute("value");
			// Click on submit
			d.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
			Thread.sleep(2000);
			
			// Blank user name & blank password
			if(uname.equals("") && password.equals(""))
			{
				assertTrue(d.findElement(By.cssSelector(".principal .invalid-feedback")).getText().contains("This field is required"));
				assertTrue(d.findElement(By.cssSelector(".d-block .invalid-feedback")).getText().contains("This field is required"));
				setCellData(i,2,"Fail",excelPath);
			}
			// Blank user name & Valid/invalid password
			else if(uname.equals("") && !(password.equals("")))
			{
				assertTrue(d.findElement(By.cssSelector(".principal .invalid-feedback")).getText().contains("This field is required"));
				setCellData(i,2,"Fail",excelPath);
			}
			// Blank password & Valid/invalid user name
			else if(!(uname.equals("")) && password.equals(""))
			{
				assertTrue(d.findElement(By.cssSelector(".d-block .invalid-feedback")).getText().contains("This field is required"));
				setCellData(i,2,"Fail",excelPath);
			}
			// Valid user name & valid password
			else if(isElementPresent(d, By.id("logout-trigger")))
			{
				d.findElement(By.id("logout-trigger")).click();
				setCellData(i,2,"Pass",excelPath);
			}
			else
			{
				assertTrue(d.findElement(By.cssSelector(".notification-message")).getText().contains("The given name / password are incorrect."));
				d.findElement(By.xpath("//span[contains(.,'×')]")).click();
				setCellData(i,2,"Fail",excelPath);
			}

			

			Thread.sleep(2000);		
		}

		
	}
	public void setCellData(int rowindex,int colindex,String result,String excelpath) throws Exception
	{
		s.getRow(rowindex).createCell(colindex).setCellValue(result);
		FileOutputStream fos=new FileOutputStream(excelpath);
		wb.write(fos);
	}
	public boolean isElementPresent(WebDriver driver, By locator)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		try
		{
			driver.findElement(locator);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
			    
	}
	

}
