package parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OptionalTest
{
	WebDriver driver;

	@Test
	@Parameters({"url","emailID"})
	public void name(@Optional("")String url, @Optional("")String emailID)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.id("identifierId")).sendKeys(emailID);
	}
}
