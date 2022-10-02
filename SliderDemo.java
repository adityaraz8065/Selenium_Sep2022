package handlingmouseandkeyword;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderDemo 
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
		d.get("https://jqueryui.com/slider/");
		assertEquals(d.getTitle(),"Slider | jQuery UI");
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		a.dragAndDropBy(d.findElement(By.xpath("//div[@id='slider']/span")), 300, 0).perform();
		Thread.sleep(3000);
	
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}

}
