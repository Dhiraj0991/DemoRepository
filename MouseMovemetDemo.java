package mouseHover;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lib.MouseAction;

public class MouseMovemetDemo extends MouseAction
{

	WebDriver driver;
	@Test
	public void goToAddons() throws Exception
	{
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://executeautomation.com/demosite/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		WebElement automationTools=driver.findElement(By.id("Automation Tools"));
		
		WebElement selenium=driver.findElement(By.id("Selenium"));
		
		WebElement ide=	driver.findElement(By.id("Selenium IDE"));
		Thread.sleep(3000);
		mouse_Hover(driver, automationTools);
		Thread.sleep(3000);
		mouse_Hover(driver, selenium);
		Thread.sleep(3000);
		ide.click();
//		mouse_Hover_Click(driver, selenium,ide);

	}

}
