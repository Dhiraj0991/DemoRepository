package parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassOne
{

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method - ClassOne || "+Thread.currentThread().getId());
	}
	
	@Test
	public void name1()
	{
		System.out.println("Test1 || "+Thread.currentThread().getId());
	}
	
	@Test
	public void name2()
	{
		System.out.println("Test2 || "+Thread.currentThread().getId());
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method --ClassOne || "+Thread.currentThread().getId());
	}
}
