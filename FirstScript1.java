package testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstScript1 {

	public static void main(String[] args) throws Exception 
	{
		//System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver.exe");
		//lauch browser
		WebDriver d=new FirefoxDriver();
		//load webpage
		d.get("https://retail.onlinesbi.com/retail/login.htm");
		//pause 3sec
		Thread.sleep(3000);
		//close the browser
		d.quit();
	}

}
