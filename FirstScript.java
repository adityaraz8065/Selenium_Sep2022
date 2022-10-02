package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstScript 
{

	public static void main(String[] args) throws Exception
	{
		//System.setProperty("webdriver.gecko.driver", "F:\\Drivers\\geckodriver.exe");
		//lauch browser
		WebDriver d=new FirefoxDriver();
		//load webpage
		d.get("https://www.facebook.com/");
		
		
		//pause 3sec
		Thread.sleep(3000);
		//close the browser
		d.quit();
	}

}
