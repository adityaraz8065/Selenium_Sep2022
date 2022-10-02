package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class QRCodeVrification 
{
	WebDriver d;
	@BeforeTest
	public void setUp()
	{
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		d.manage().deleteAllCookies();
	}
	@Test
		public void demoQRCodeVrification () throws Exception
		{
			d.get("https://demo.cyclos.org/ui/banking/qr");
			//d.findElement(By.className("quick-access-item"));
			Thread.sleep(3000);
		}
	@AfterTest
	public void tearDown()
	{
		d.quit();
	}
	
}