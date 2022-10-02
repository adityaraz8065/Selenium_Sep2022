package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import config.Driver;
import pages.IMBDPage;
import pages.WikiPage;

public class SearchhMovie extends Driver 
{
	String imbdDate;
	String imbdCountry;
	String wikiDate;
	String wikiCountry;
	@Test(priority=1)
	public void testIMBD()
	{
		// Load web page
		d.get(imbdURL);
		IMBDPage imd=new IMBDPage(d);
		// Searching movie
		imd.movieSearch("Pushpa:The Rise");
		// Verify release date
		assertTrue(imd.releaseDate.isDisplayed());
		imbdDate=imd.releaseDate.getText();
		// Verify country
		assertTrue(imd.country.isDisplayed());
		imbdCountry=imd.country.getText();
			
	}
	@Test(priority=2)
	public void testWiki()
	{
		// Load web page
		d.get(wikiURL);
		WikiPage wiki=new WikiPage(d);
		// Searching movie
		wiki.movieSearch("Pushpa:The Rise");
		// Verify release date
		assertTrue(wiki.releaseDate.isDisplayed());
		wikiDate=wiki.releaseDate.getText();
		System.out.println("Release Date:"+wikiDate);
		// Verify country
		assertTrue(wiki.country.isDisplayed());
		wikiCountry=wiki.country.getText();
			
		
	}
	@Test(priority=3)
	public void testValidateMoviewDeatils() throws Exception
	{
		try {
			assertEquals(imbdDate,wikiDate);
			assertEquals(imbdCountry,wikiCountry);
			Thread.sleep(3000);
			}
		catch (Exception e) 
		{
			 System.out.println(e);
			 Assert.fail();
			 
		}
				
	}	
}

	
	
	

