package testscripts;




import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ObjectRepository;

public class HybrideTest 
{
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		d.get("https://demo.cyclos.org/ui/home");
		ObjectRepository loginpage=new ObjectRepository(d);
		ExcelUtils excel=new ExcelUtils("F:\\Selenium_Script2022\\Library\\Sbi Project\\TestData\\LoginData.xlsx","Sheet1");
		
		loginpage.fillLogin(excel.getCellData(1, 0), excel.getCellData(1,1));
		
		Thread.sleep(2000);
		loginpage.linkLogout.click();
	}
	@BeforeMethod
	public void setUp()
	{
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		d.manage().deleteAllCookies();
		  
	}
	@AfterMethod
	public void tearDown()
	{
	d.quit();	
	}
	
	
}


