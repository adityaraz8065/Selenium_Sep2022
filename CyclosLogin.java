package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CyclosLogin 
{
	WebDriver d;
     @BeforeMethod
     public void setUp()
     {
    	d=new FirefoxDriver(); 
     }
     @Test
     public void cyclosLoginPage() throws Exception
     {
    	 d.get("https://license.cyclos.org/app/guest/login");
    	 assertEquals(d.getTitle(), "Cyclos4 License Server");
    	 assertTrue(d.findElement(By.xpath("//input[@type='text']")).isDisplayed());
    	 
    
    	//System.out.println("Page title:"+d.getTitle());
    	 
    	 d.findElement(By.xpath("//input[@type='text']")).sendKeys("demo");
    	d.findElement(By .xpath("//input[@type='password']")).sendKeys("1234");
    	d.findElement(By.xpath("//button[@type='submit']")).click();
    	 Thread.sleep(3000);
    	 
     }
     @AfterMethod
     public void tearDown()
     {
    	 d.quit();
     }
}
