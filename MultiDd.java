package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiDd {

	public static void main(String[] args) throws Exception 
	{
		WebDriver d=new FirefoxDriver();
		
		d.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		//Switch Driver focus to frame
		d.switchTo().frame("iframeResult");
		
		Select dd=new Select(d.findElement(By.id("cars")));
		System.out.println(dd.isMultiple());
		for(int i=0;i<dd.getOptions().size();i++)
		{
			dd.selectByIndex(i);
		}
		
		Thread.sleep(2000);
		dd.deselectAll();
		d.quit();

	}

}
