package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsPage {
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextBox;
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBtn;
	
	public CreateContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameTextBox() {
		return lastNameTextBox;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void enterLastName(String orgName)
	{
		lastNameTextBox.sendKeys(orgName);
	}

}
