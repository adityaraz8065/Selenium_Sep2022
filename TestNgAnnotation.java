package testscripts;

import org.testng.annotations.*;

public class TestNgAnnotation
{
	@BeforeSuite
	public void meth1()
	{
		System.out.println("Before suite");
	}
	@AfterSuite
	public void meth2()
	{
		System.out.println("After suite");
	}
}
