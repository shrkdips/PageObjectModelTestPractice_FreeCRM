package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseTest;

import io.qameta.allure.Step;

public class LoginPage extends BaseTest
{
	//Page Factory - OR (Object Repo)
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath = "//ul[contains(@class,'nav navbar-nav navbar-right')]/descendant::li[2]/a")
	WebElement signUp;
	
	@FindBy(xpath = "//button[@type='button']/following-sibling::a/img")
	WebElement crmLogo;
	
	//Initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	@Step("Getting Login Page Title.....")
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	@Step("Verify Logo In The Page.....")
	public boolean validateCrmLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	@Step("........Login With Username : {0} and  Password : {1}........")
	public HomePage login(String un, String pass)
	{
		username.sendKeys(un);
		password.sendKeys(pass);
		try
		{
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		loginButton.click();
		
		return new HomePage();
	}
	
}
