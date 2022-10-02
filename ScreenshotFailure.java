package CapturingSceenshot;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class ScreenshotFailure
{
	WebDriver d;
	@Test
	public void testAjax() throws Exception
	{
		try
		{
	
			d.get("https://www.veethi.com/places/india_banks-ifsc-codes.html");
			//Verify page title
			assertEquals(d.getTitle(),"Bank IFSC Codes: Find IFSC for Major Banks in India");
			// Select bank
			Select bank=new Select(d.findElement(By.id("selBank")));
			bank.selectByVisibleText("Axis Bank");
			// Select state
			Select state=new Select(d.findElement(By.id("selState")));
			state.selectByVisibleText("Andhra Pradesh");
			// Select city
			Select city=new Select(d.findElement(By.id("selCity")));
			city.selectByVisibleText("Hyderabad788");
			// Select branch
			Select branch=new Select(d.findElement(By.id("selBranch")));
			branch.selectByVisibleText("Madhapur");
		}
		catch(Exception e)
		{
			DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt = new Date(0);
			File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("F:\\Selenium_Scripts_Jul2022\\ABCBank\\Screenshots\\"+sdf.format(dt)+".png"));
			//Assert.fail();
		}

		
		Thread.sleep(3000);
	}
	@BeforeMethod
	public void setUp()
	{
		// Launch the browser
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		  
	}
	@AfterMethod
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}


}
