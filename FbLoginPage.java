package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FbLoginPage {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Drivers\\geckodriver.exe");
		//lauch broser
		WebDriver d=new FirefoxDriver();
		//WebDriver d=new ChromeDriver();
		//Load Webpage
		d.get("https://www.facebook.com/");
		
		d.findElement(By.id("email")).sendKeys("aditya");
		d.findElement(By.id("pass")).sendKeys("12456");
		d.findElement(By.name("login")).click();
		Thread.sleep(3000);
		d.quit();
		
	}

}
