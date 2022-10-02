package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class FbsignUpTestNg 
{
	WebDriver d;
	@BeforeMethod
	public void setUp()
	{
		 d=new FirefoxDriver();
	}
	@Test
	public void FbSignUp() throws Exception
	{
		d.get("https://www.facebook.com/r.php?locale=en_GB");
		d.findElement(By.name("firstname")).sendKeys("Aditya");
		d.findElement(By.name("lastname")).sendKeys("Adi");
		d.findElement(By.xpath("//input[contains(@id,'u_0_g')]")).sendKeys("abcd341@gmail.com");
		d.findElement(By.xpath("//input[contains(@id,'u_0_j')]")).sendKeys("abcd341@gmail.com");
		d.findElement(By.id("password_step_input")).sendKeys("Rja8ydj2@");
		
		Select dd=new Select(d.findElement(By.id("day")));
		dd.selectByIndex(19);
		Select dd1=new Select(d.findElement(By.id("month")));
		dd.selectByValue("5");
		Select dd2=new Select(d.findElement(By.id("year")));
		dd.deselectByVisibleText("1997");
		
		d.findElement(By.xpath("//span[2]/input")).click();
		
		
		d.findElement(By.name("websubmit")).click();
		Thread.sleep(3000);
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
}
