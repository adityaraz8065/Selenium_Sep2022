package testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstScript2
{

	public static void main(String[] args) throws Exception
	{
		//System.setProperty("webdriver.edge.driver", "F:\\Drivers\\msedgedriver.exe");
		//lauch browser
		WebDriver d=new EdgeDriver();
		//load webpage
		d.get("https://www.facebook.com/");
		//pause 3sec
		Thread.sleep(3000);
		//close the browser
		d.quit();
	}

}
