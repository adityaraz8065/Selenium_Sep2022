package testscripts;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import pages.ObjectRepository;

public class PageFactoryDemo 
{
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		d.get("https://demo.cyclos.org/ui/home");
		ObjectRepository loginpage=new ObjectRepository(d);
		loginpage.fillLogin("demo", "1234");
		Thread.sleep(2000);
		loginpage.linkLogout.click();
	}
	@BeforeMethod
	public void setUp()
	{
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		d.manage().deleteAllCookies();
		  
	}
	@AfterMethod
	public void tearDown()
	{
	d.quit();	
	}
	
	
}
