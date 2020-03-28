package com.index.TestPage;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testpage.base.TestBase;
import com.testpage.pages.HomePage;

public class TestPageLogin extends TestBase {
	HomePage HomePage;
	HomePage homepage;
	static WebDriver driver;
	
	public TestPageLogin() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		HomePage = new HomePage();
		}
	
	
	@Test(priority=1)
	public void HomePage() {
	HomePage.login(prop.getProperty("Email"), prop.getProperty("Password"));
		}
	
	
	@Test(priority=2)
	public void ListItemTest() {
		
		HomePage.ListItem();
	}
	
	
		
	@Test(priority=3)
	public void DropDownItemTest() {
		HomePage.DropDown();

	}
	
	@Test(priority = 4)
	public void ButtonTest1()
	{
		HomePage.Button1();
	}
	
	@Test(priority = 5)
	public void ButtonTest2()
	{
		HomePage.Button3();
	}
	
	
	@Test(priority = 6)
	public void TableTest()
	{
		HomePage.Table();
	}
	
}
		
	
	
	
	
	
	
	//@AfterMethod
	//public void teardown() {
		//driver.quit();
	//}


