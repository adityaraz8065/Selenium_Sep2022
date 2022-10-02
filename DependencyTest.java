package testscripts;

import org.testng.annotations.Test;

public class DependencyTest
{
	@Test
	public void meth1()
	{
		System.out.println("meth1");
		//int n=10/0;
	}
	@Test(dependsOnMethods="meth1")
	public void meth2()
	{
		System.out.println("meth2");
	}
}
