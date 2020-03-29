package parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassTwo
{
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method - ClassTwo || "+Thread.currentThread().getId());
	}
	
	@Test
	public void name1()
	{
		System.out.println("Test3 || "+Thread.currentThread().getId());
	}
	
	@Test
	public void name2()
	{
		System.out.println("Test4 || "+Thread.currentThread().getId());
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method --ClassTwo || "+Thread.currentThread().getId());
	}
}
