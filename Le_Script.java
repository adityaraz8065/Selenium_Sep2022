package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Le_Script {

	public static void main(String[] args) throws Exception 
	{
		//Lauch browser
		WebDriver d=new FirefoxDriver();
		
		//Load page
		d.get("https://www.facebook.com/");
		//d.findElement(By.id("email"));                          //By using id
		//d.findElement(By.name("email"));                        //By using name
		//d.findElement(By.linkText("Forgotten password?"));       //By using linktext
		//d.findElement(By.partialLinkText("Forgotten"));           //By using partialLinkText
		d.findElement(By.xpath("//input[@id=\"email\"]"));          //By using xpath
		System.out.println("No of link:"+d.findElement(By.tagName("a")).getSize());
		
		
		Thread.sleep(3000);
		d.quit();
		

	}

}
