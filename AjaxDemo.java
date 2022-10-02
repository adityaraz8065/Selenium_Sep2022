package testscripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class AjaxDemo
{
	WebDriver d; 
	
	@BeforeMethod
	public void setUp()
	{
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		  
	}
	@Test
	public void testAjax() throws Exception 
	{
		// Load web page
				d.get("https://www.veethi.com/places/india_banks-ifsc-codes.html");
				//Verify page title
				assertEquals(d.getTitle(),"Bank IFSC Codes: Find IFSC for Major Banks in India");
				// Select bank
				Select bank=new Select(d.findElement(By.id("selBank")));
				bank.selectByVisibleText("Axis Bank");
				// Explicit Wait
				//WebDriverWait wait=new WebDriverWait(d,Duration.ofMinutes(2));
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='Andhra Pradesh']")));
				// Wait<WebDriver> wait = new FluentWait<WebDriver>(d)
						   //.withTimeout(Duration.ofSeconds(60))
						   //.pollingEvery(Duration.ofSeconds(8));
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='Andhra Pradesh']")));
				
				//Thread.sleep(10000);
				// Select state
				Select state=new Select(d.findElement(By.id("selState")));
				state.selectByVisibleText("Andhra Pradesh");
				// Select city
				Select city=new Select(d.findElement(By.id("selCity")));
				city.selectByVisibleText("Hyderabad");
				// Select branch
				Select branch=new Select(d.findElement(By.id("selBranch")));
				branch.selectByVisibleText("Madhapur");
				
				Thread.sleep(3000);
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
	
}
