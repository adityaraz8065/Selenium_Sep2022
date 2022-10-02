package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class MultiDdTestng 
{
	WebDriver d;
	@BeforeMethod
	public void setUp()
	{
		d=new FirefoxDriver();
		
	}
	@Test
	public void testMultiDd() throws Exception
	{
		d.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		//Switch Driver focus to frame
		d.switchTo().frame("iframeResult");
		Select dd=new Select(d.findElement(By.id("cars")));
		System.out.println(dd.isMultiple());
		for(int i=0;i<dd.getOptions().size();i++)
		{
			dd.selectByIndex(i);
		}
		Thread.sleep(2000);
	}
		@AfterMethod
		public void tearDown()
		{
			d.quit();
		}
	
	
}
