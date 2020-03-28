package com.testpage.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.testpage.utilities.TestUtilities;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream ("F:\\JAVA\\Selenium\\SeleniumMavenProjects\\ZianAssignment\\src\\main\\java\\com\\testpage\\config\\config.properties");
		prop.load(ip);
		}
	
		catch (FileNotFoundException e) {
		e.printStackTrace();
		}
	
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_79.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}
