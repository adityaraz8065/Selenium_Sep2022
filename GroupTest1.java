package testscripts;

import org.testng.annotations.Test;

public class GroupTest1 
{
	@Test(groups="Sanity")
	public void method1()
	{
		System.out.println("@Test in GroupTest1");
	}
	@Test(groups="Regression")
	public void method2()
	{
		System.out.println("@Test in GroupTest1");
	}
	@Test(groups="Sanity")
	public void method3()
	{
		System.out.println("@Test in GroupTest1");
	}
	@Test(groups="Regression")
	public void method4()
	{
		System.out.println("@Test in GroupTest1");
	}
}
