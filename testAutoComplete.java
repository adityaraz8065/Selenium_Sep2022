package handlingmouseandkeyword;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testAutoComplete
{
	WebDriver d;
	@BeforeMethod
	public void setUp()
	{
		// Launch the browser
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		d.manage().deleteAllCookies();
		  
	}
		@Test
		public void demoAutoComplete() throws Exception
		{
			d.get("https://jqueryui.com/autocomplete/");
			//Verify page title
			assertEquals(d.getTitle(),"Autocomplete | jQuery UI");
			d.switchTo().frame(0);
			d.findElement(By.id("tags")).sendKeys("a");
			List<WebElement> s=d.findElements(By.className("ui-menu-item-wrapper"));
			System.out.println("no of Suggetions size:"+s.size());
			Thread.sleep(3000);
			for(WebElement e:s)
			{
				
				d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
				if(e.getText().contains("Asp"))
				{
					d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
					break;
				}
				Thread.sleep(3000);
				
			}
}
	@AfterMethod
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}
}
