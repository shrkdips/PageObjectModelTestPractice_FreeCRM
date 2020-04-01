package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest extends BaseTest
{
	public static LoginPage page;
	public static HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		page = new LoginPage();
	}
	
	
	@Test(priority=1, description = "This is the login title test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description : To verify the login tilte of login page")
	@Story("Story Name: To check login title of the page")
	public void loginPageTitleTest()
	{
		String title = page.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2, description = "This is the CRM Logo")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case description : To verify the Logo is displayed or not")
	@Story("Story Name: To verify the Logo of the Logoin Page")
	public void CRMLogoImageTest()
	{
		boolean logo = page.validateCrmLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3, description = "This is Login test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test case description : To check if login passed or failed")
	@Story("Story Name: To verify if pass or fail")
	public void loginTest()
	{
		homePage = page.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
