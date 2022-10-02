package testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FbSignup  {

	public static void main(String[] args) throws Exception
	{
		//WebDriver d=new FirefoxDriver();
		WebDriver d=new FirefoxDriver();
		
		d.get("https://www.facebook.com/r.php?locale=en_GB");
		d.findElement(By.name("firstname")).sendKeys("Aditya");
		d.findElement(By.name("lastname")).sendKeys("Adi");
		d.findElement(By.xpath("//input[contains(@id,'u_0_g')]")).sendKeys("abcd341@gmail.com");
		d.findElement(By.xpath("//input[contains(@id,'u_0_j')]")).sendKeys("abcd341@gmail.com");
		d.findElement(By.id("password_step_input")).sendKeys("Rja8ydj2@");
		
		Select dd=new Select(d.findElement(By.id("day")));
		dd.selectByIndex(19);
		
		Select dd1=new Select(d.findElement(By.id("month")));
		dd1.selectByValue("5");
		
		Select dd2=new Select(d.findElement(By.id("year")));
		dd2.selectByVisibleText("1997");
		
		d.findElement(By.xpath("//span[2]/input")).click();
		Thread.sleep(2000);
		
		d.findElement(By.name("websubmit")).click();
		Thread.sleep(5000);
		
		
		//System.out.println("Get Selectes option:"+dd1.getFirstSelectedOption().getText()); //Get selected option
		//List<WebElement> e=dd1.getOptions();         //Get Aviable options
		//for(WebElement p:e)
		//{
			//System.out.println(p.getText());
		//}
		
		Thread.sleep(3000);
		d.quit();
	}

}
