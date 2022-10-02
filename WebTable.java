package handlingmouseandkeyword;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTable 
{
	WebDriver d;
	private WebElement[] td_collection;
	private int col_num;
	private int row_num;
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
		d.get("https://www.w3schools.com/html/html_tables.asp");
		//Verify page title
		assertEquals(d.getTitle(),"HTML Tables");
		List<WebElement> tr_collection=d.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
		
		
		for(WebElement tdElement : td_collection) // Cols
		{
			if(row_num == 3 && col_num == 3)
             {
          	   assertEquals(tdElement.getText(),"Mexico");
          	   break;
              }
			if(tdElement.getText().equals("UK"))
            {
            	System.out.println("Text Found");
            	break;
            }
		
			col_num++;
		}

		row_num++;
		Thread.sleep(2000);
}
				
	

	@AfterMethod
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}
}
