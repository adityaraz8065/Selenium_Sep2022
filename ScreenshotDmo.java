package CapturingSceenshot;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class ScreenshotDmo 
{
	private static final String FileUtil = null;
	WebDriver d;
	@BeforeMethod
	public void setUp()
	{
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	@Test
	public void testScreenshot() throws Exception
	{
		d.get("https://www.google.com/");
		assertEquals(d.getTitle(),"Google");
		d.findElement(By.linkText("Gmail")).click();
		//d.findElement(By.linkText("Images")).click();
		DateFormat sdf=new SimpleDateFormat("dd-mm-yyyy HH-mm-ss");
		Date dt = new Date(0);
		File screenshotFile=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,new File("F:\\Selenium_Script2022\\Library\\Sbi Project\\Screenshot\\"+sdf.format(dt)+".png"));
		//FileUtils.copyFile(screenshotFile,new File("F:\\Selenium_Script2022\\Library\\Sbi Project\\Screenshot\\Page.png"));
		Thread.sleep(3000);
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
}
