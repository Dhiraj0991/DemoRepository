package com.testpage.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testpage.base.TestBase;
import com.testpage.utilities.TestUtilities;

public class HomePage extends TestBase {

	@FindBy(id = "inputEmail")
	WebElement Email;

	@FindBy(id = "inputPassword")
	WebElement Password;

	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	WebElement Signin;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public void login(String em, String pwd) {
		Email.sendKeys(em);
		Password.sendKeys(pwd);
		Signin.click();
	}

	@FindBy(xpath = "//button[@id='dropdownMenuButton']")
	List<WebElement> list_items;
	
	
	@FindBy(xpath = "//ul[@class='list-group']//li[2]")
	WebElement listitemstext;
	
	@FindBy(xpath = "//ul[@class='list-group']//li[2]//span")
	WebElement listitemsbadgetext;
	


	public void ListItem() {
		int count= list_items.size();
		Assert.assertEquals(count, 3);
		
		String validateText=listitemstext.getText();
		Assert.assertEquals(validateText, "List Item 2 6");
		
		String validateBadge=listitemsbadgetext.getText();
		Assert.assertEquals(validateBadge, "6");

	}
	@FindBy(xpath = "//button[@id='dropdownMenuButton']")
	static WebElement DropDownItem1;

	@FindBy(xpath = "//button[@id='dropdownMenuButton']")
	WebElement DropDownItem2;


	@FindBy(xpath = "//a[@class='dropdown-item'][3]")
	WebElement DropDownItem3;

	public void DropDown()
	{
		String textString=DropDownItem1.getText();
		Assert.assertEquals(textString,"Option 1");

		DropDownItem2.click();
		DropDownItem3.click();

	}
	
	
	@FindBy(xpath = "(//button[contains(text(),'Button')])[1]")
	WebElement button1;
	
	
	@FindBy(xpath = "(//button[contains(text(),'Button')])[2]")
	WebElement button2;
	
	
	public void Button1()
	{

		Assert.assertEquals(button1.isEnabled(), true);
		
		Assert.assertEquals(button2.isEnabled(), false);
	}
	
	
	
	@FindBy(xpath = "(//button[contains(text(),'Button')])[3]")
	WebElement button3;
	
	
	
	public void Button3()
	{
	
		TestUtilities.dynamicWait(driver, button3, 50000);
		Assert.assertEquals(button3.isEnabled(), true);
	}
	
	
	@FindBy(xpath = "//table[@class='table table-bordered table-dark']//tbody//tr[3]//td[3]")
	WebElement tabletext;
	
	public void Table()
	{
		String validateCellText=tabletext.getText();
		
		Assert.assertEquals(validateCellText, "Ventosanzap");
	}

}

