package testscripts;

import org.testng.annotations.Test;

public class GroupTest2 
{
	@Test(groups="Sanity")
	public void meth1()
	{
		System.out.println("@Test1 in GroupTest2");
	}
	@Test(groups="Sanity")
	public void meth2()
	{
		System.out.println("@Test2 in GroupTest2");
	}
	@Test(groups="Regression")
	public void meth3()
	{
		System.out.println("@Test3 in GroupTest2");
	}
	@Test(groups="Smoke")
	public void meth4()
	{
		System.out.println("@Test4 in GroupTest2");
	}
}
