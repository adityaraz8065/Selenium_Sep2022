package testscripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.Common;

public class FrameDemo extends Common
{

	@Test
	public void testFrame() throws Exception
	{
		d.get("https://jqueryui.com/autocomplete/");
		//verify page title
		assertEquals(d.getTitle(),"Autocomplete | jQuery UI");
		//switch drive focus to frame
		//d.switchTo().frame(d.findElement(By.className("demo-frame")));
		System.out.println("No of frames:"+d.findElements(By.tagName("iframe")).size());
		d.switchTo().frame(0);
		
		d.findElement(By.id("tags")).sendKeys("Selenium");
		//switch driver focus outside frame
		d.switchTo().defaultContent();
		d.findElement(By.linkText("Button")).click();
		Thread.sleep(3000);
	}
	
	
}
