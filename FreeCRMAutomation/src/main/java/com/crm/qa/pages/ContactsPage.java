package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.BaseTest;

public class ContactsPage extends BaseTest
{
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(name = "title")
	WebElement newContactsTitleBox;
	
	@FindBy(name = "first_name")
	WebElement newContactsFirstNameBox;
	
	@FindBy(name = "surname")
	WebElement newContactsLastNameBox;
	
	@FindBy(name = "client_lookup")
	WebElement newContactsCompanyBox;
	
	@FindBy(xpath = "//input[@class='button' and @value='Load From Company']/following-sibling::input[@type='submit'and@value='Save']")
	WebElement newContactsSaveBtn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		 return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']/input[@name='contact_id']")).click();
	}
	
	
	public void fillNewContactsForm(String titleBox, String firstNameBox, String lastNameBox, String companyBox)
	{
		Select select = new Select(newContactsTitleBox);
		select.selectByVisibleText(titleBox);
		
		newContactsFirstNameBox.sendKeys(firstNameBox);
		newContactsLastNameBox.sendKeys(lastNameBox);
		newContactsCompanyBox.sendKeys(companyBox);
		newContactsSaveBtn.click();
		
	}
	
	
	
}