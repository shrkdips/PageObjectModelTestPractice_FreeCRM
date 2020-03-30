// Auther Name:- Shreyak Sambit Patnaik

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseTest;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.UtilTest;

public class ContactsPageTest extends BaseTest
{
	
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static ContactsPage contactPage;
	public static UtilTest utilTest;
	
	public static String sheetName = "Contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		utilTest = new UtilTest();
		contactPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		utilTest.switchToFrame();
		contactPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority = 1)
	public void verifycontactsLabelTest()
	{
		boolean label = contactPage.verifyContactsLabel();
		Assert.assertTrue(label, "Contacts Page Label is not available on the page");
	}
	
	@Test(priority = 2)
	public void selectContactsByNameTest()
	{
		contactPage.selectContactsByName("Betty Jones");
	}
	
	
	@Test(priority = 3)
	public void selectMultipleContactsTest()
	{
		contactPage.selectContactsByName("Betty Jones");
		contactPage.selectContactsByName("Bruce Wayne");
	}
	
	@DataProvider
	public Object[][] getCRMDataFromExcel()
	{
		Object data[][] = UtilTest.getTestData(sheetName);
		return data;	
	}
	
	@Test(priority = 4, dataProvider = "getCRMDataFromExcel")
	public void fillNewContactsFormTest(String Title, String FirstName, String SurName, String Company)
	{
		homePage.clickOnNewContactsLink();
		//contactPage.fillNewContactsForm("Mr.", "ShrkDips", "PaTw", "Glbs");
		contactPage.fillNewContactsForm(Title, FirstName, SurName, Company);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
