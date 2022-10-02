package handlingmouseandkeyword;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class CurrentAcount
{
	WebDriver d;
	@BeforeMethod
	public void setUp()
	{
		d=new FirefoxDriver();
		d.manage().window().maximize();
		//d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		d.manage().deleteAllCookies();
	}
	@Test
	public void testCurrentAcount() throws Exception
	{
		d.get("https://demo.cyclos.org/ui/home");
		//assertEquals(d.getTitle(),"State Bank of India");
		//Actions a=new Actions(d);
		//a.moveToElement(d.findElement(By.className("menu-text"))).perform();
		//d.findElement(By.className("menu-text")).click();
		Thread.sleep(3000);
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
	
	
}
