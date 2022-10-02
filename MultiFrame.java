package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.Common;

public class MultiFrame extends Common
{
	
	@Test
	public void tsetMultipleFrame() throws Exception
	{
		d.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		System.out.println("no of frame:"+d.findElements(By.tagName("iframe")).size());
		//switch driver focus to frame1
		d.switchTo().frame(0);
		d.findElement(By.linkText("org.openqa.selenium")).click();
		Thread.sleep(3000);
		//switch driver focus outside the frame
		d.switchTo().defaultContent();
		//switch driver focus on frame 2
		d.switchTo().frame(1);
		d.findElement(By.linkText("Alert")).click();
		Thread.sleep(300);
		d.switchTo().defaultContent();
		d.switchTo().frame(2);
		d.findElement(By.linkText("accept")).click();
		Thread.sleep(3000);
		d.switchTo().defaultContent();
		//switch drive focus on first frame
		d.switchTo().frame(0);
		d.findElement(By.linkText("org.openqa.selenium.bidi")).click();
		Thread.sleep(300);
		
	}
	
}
