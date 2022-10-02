package handlingmouseandkeyword;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserSlider
{
	WebDriver d;
	@BeforeMethod

		public void setUp()
		{
			d=new FirefoxDriver();
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
			d.manage().deleteAllCookies();
		}
	@Test
	public void testSliderDemo() throws Exception 
	{
		d.get("https://www.myntra.com/");
			for(int i=0;i<10;i++)
			{
				((RemoteWebDriver) d).executeScript("window.scrollBy(0,400)");
				Thread.sleep(1000);
				}
				((RemoteWebDriver) d).executeScript("window.scrollTo(0,0)");
				Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}

}
