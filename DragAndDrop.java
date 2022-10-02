package handlingmouseandkeyword;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class DragAndDrop
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
	public void testDragAndDrop() throws Exception
	{
		d.get("https://jqueryui.com/droppable/");
		assertEquals(d.getTitle(),"Droppable | jQuery UI");
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		a.dragAndDrop(d.findElement(By.id("draggable")),d.findElement(By.id("droppable"))).perform();
		Thread.sleep(3000);
		
	}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}

}
