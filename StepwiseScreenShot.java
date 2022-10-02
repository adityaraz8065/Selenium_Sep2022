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

public class StepwiseScreenShot
{
	WebDriver d;
	@Test
	public void testAjax() throws Exception
	{
		// Load web page
		d.get("https://www.veethi.com/places/india_banks-ifsc-codes.html");
		//Verify page title
		assertEquals(d.getTitle(),"Bank IFSC Codes: Find IFSC for Major Banks in India");
		getScreenshot();
		// Select bank
		Select bank=new Select(d.findElement(By.id("selBank")));
		bank.selectByVisibleText("Axis Bank");
		Thread.sleep(500);
		getScreenshot();
		// Select state
		Select state=new Select(d.findElement(By.id("selState")));
		state.selectByVisibleText("Andhra Pradesh");
		Thread.sleep(500);
		getScreenshot();
		// Select city
		Select city=new Select(d.findElement(By.id("selCity")));
		city.selectByVisibleText("Hyderabad");
		Thread.sleep(500);
		getScreenshot();
		// Select branch
		Select branch=new Select(d.findElement(By.id("selBranch")));
		branch.selectByVisibleText("Madhapur");
		getScreenshot();
		Thread.sleep(3000);
	}
	public void getScreenshot()throws Exception
	{
		DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date(3);
		File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("F:\\Selenium_Script2022\\Library\\Sbi Project\\Screenshot\\"+sdf.format(dt)+".png"));
	}
	@BeforeMethod
	public void setUp()
	{
		// Launch the browser
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		  
	}
	@AfterMethod
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}
}
