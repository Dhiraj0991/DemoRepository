package assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ZainAssignment
{
	public static WebDriver driver;
	
	
	public static void dynamicWait(WebDriver driver,WebElement element,long timeout)
	{
		
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
	}
	
	@BeforeTest
	public void setup()
	{
		
		System.setProperty("webdriver.chrome.driver", "chromedriver_79.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String projrctLocation= System.getProperty("user.dir");
		driver.get(projrctLocation+"/NewIndex.html");
		

	}
	
	@Test(priority = 1)
	public void usernamepassword()
	{
		driver.findElement(By.id("inputEmail")).sendKeys("ZAIN.KHAN@GMAIL.COM");
		driver.findElement(By.id("inputPassword")).sendKeys("KHAN");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(priority = 2)
	public void ListItem()
	{
		List<WebElement> list_items=driver.findElements(By.xpath("//ul[@class='list-group']//li"));
		
		int count= list_items.size();
		System.out.println("There are "+ count+"number of items in List Items");
	
		
		String validateText=driver.findElement(By.xpath("//ul[@class='list-group']//li[2]")).getText();
		Assert.assertEquals(validateText, "List Item 2 6");
		
		String validateBadge=driver.findElement(By.xpath("//ul[@class='list-group']//li[2]//span")).getText();
		Assert.assertEquals(validateBadge, "6");
		
	}
	@Test(priority = 3)
	public void DropDown()
	{
		
		
		driver.findElements(By.xpath("//ul[@class='list-group']//li"));
		
		String textString=driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).getText();
		
		Assert.assertEquals(textString,"Option 1");
		
		driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
		
		driver.findElement(By.xpath("//a[@class='dropdown-item'][3]")).click();
			
	}
	
	
	@Test(priority = 4)
	public void ButtonTest1()
	{
		WebElement button1=driver.findElement(By.xpath("(//button[contains(text(),'Button')])[1]"));

		Assert.assertEquals(button1.isEnabled(), true);
		
		WebElement button2=driver.findElement(By.xpath("(//button[contains(text(),'Button')])[2]"));
		
		Assert.assertEquals(button2.isEnabled(), false);
	}
	
	
	@Test(priority = 5)
	public void ButtonTest2()
	{
//		Thread.sleep(10000);
//		WebElement button3=driver.findElement(By.xpath("(//button[contains(text(),'Button')])[3]"));
//		Assert.assertEquals(button3.isEnabled(), true);
		
		
		WebElement button3 = driver.findElement(By.xpath("(//button[contains(text(),'Button')])[3]"));
		dynamicWait(driver, button3, 50000);
		Assert.assertEquals(button3.isEnabled(), true);
		
	}
	
	@Test(priority = 6)
	public void TableTest1()
	{
		String validateCellText=driver.findElement(By.xpath("//table[@class='table table-bordered table-dark']//tbody//tr[3]//td[3]")).getText();
		
		Assert.assertEquals(validateCellText, "Cognizant");
	}
	
	
	
	
	@Test(priority = 7)
	public void TableTest2()
	{
		WebElement ele =null;
		for(int i=1;i<5;i++)
		{
			for(int j=1;j<5;j++)
			{
				ele = driver.findElement(By.xpath("//*[@id='test-6-div']/div/table/tbody/tr["+i+"]/td["+j+"]"));
				System.out.println(ele.getText());
				if(ele.getText().equals("Cognizant")) {
					Assert.assertTrue(true);
					driver.findElement(By.xpath("//*[@id='test-6-div']/div/table/tbody/tr["+i+"]/td[1]/input")).click();
					break;
				}
			}
			if(ele.getText().equals("Cognizant"))
				break;
		}
		
		
		
	}
	
//	@Test(priority = 7)
//	public void TableTest2()
//	{
//		
//		driver.findElement(By.xpath("//td[contains(text(),'Cognizant')]//preceding-sibling::td/input[@type='checkbox']")).click();
//		
//	}
}
