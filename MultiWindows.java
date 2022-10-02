package testscripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.Common;

public class MultiWindows  extends Common
{

	@Test
	public void tsetMultipleFrame() throws Exception
	{
		d.get("https://retail.onlinesbi.com/retail/login.htm");
		assertEquals(d.getTitle(),"State Bank of India - Personal Banking");
		d.findElement(By.cssSelector("a > img")).click();
		Thread.sleep(5000);
		//System.out.println("no of window:"+d.getWindowHandles().size());
		ArrayList<String> al=new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window(al.get(1));
		Thread.sleep(3000);
		d.switchTo().window(al.get(0));
		Thread.sleep(3000);
		
	}
	
	
}
