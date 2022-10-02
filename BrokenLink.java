package testscripts;

import static org.testng.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
public class BrokenLink 
{
	WebDriver d;
	@BeforeMethod
	public void setUp()
	{
		// Launch the browser
		d=new FirefoxDriver();
		
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));
		d.manage().deleteAllCookies();
		d.manage().window().maximize();
	}
	@Test
	public void testLinks() throws Exception
	{
		d.get("https://www.selenium.dev/");
		assertEquals(d.getTitle(),"Selenium");
		List<WebElement> l=d.findElements(By.className("nav-link"));
		System.out.println("No of links:"+l.size());
		for(WebElement e:l)
		{
			try
			{
				
				if(e.getAttribute("href")!=null)
				{
					URL u=new URL(e.getAttribute("href"));
					//e.click();
					HttpURLConnection con=(HttpURLConnection)u.openConnection();
					con.setConnectTimeout(60000);
					con.connect();
					if(con.getResponseCode() == 200)
					{
						System.out.println("Link:"+u+"---> is working fine");
					}
					else
					{
						System.out.println("Link:"+u+"---> is not working");
						
					}
				}
				
			}
			catch(Exception ie)
			{
				System.out.println(ie);
			}
			
		}
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}

}
