package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.UtilTest;

public class HomePageTest extends BaseTest
{
	public static UtilTest utilTest;
	public static LoginPage page;
	public static HomePage homePage;
	public static ContactsPage contactPage;
	public static DealsPage dealsPage;
	public static TasksPage taskPage;
	
	public HomePageTest()
	{
		super();
	}
	
	// Test Cases should be independent to each other.
	// before each test case -- launch the browser and login
	// @Test -- execute the test cases
	// after each test case close the browser.
	
	@BeforeMethod
	public void setUp()
	{
		
			initialization();
			page = new LoginPage();
			contactPage = new ContactsPage();
			utilTest = new UtilTest();
			homePage = page.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void homePageTitleTest()
	{
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "HomePage Title Not Matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameLabelTest()
	{
		utilTest.switchToFrame();
		boolean name = homePage.verifyUserNameLabel();
		Assert.assertTrue(name);
	}
	
	@Test(priority=3)
	public void clickOnContactsTest()
	{
		utilTest.switchToFrame();
		contactPage = homePage.clickOnContactsLink();	
	}
	
	@Test(priority=4)
	public void clickOnDealsTest()
	{
		utilTest.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=5)
	public void clickOnTasksTest()
	{
		utilTest.switchToFrame();
		taskPage = homePage.clickOnTasksLink();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
