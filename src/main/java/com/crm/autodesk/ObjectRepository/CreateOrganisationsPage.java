package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationsPage {
	
	@FindBy(name = "accountname")
	private WebElement enterOrgNameEdt;
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBtn;
	
	public CreateOrganisationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEnterOrgNameEdt() {
		return enterOrgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void enterOrgName(String orgName) {
		enterOrgNameEdt.sendKeys(orgName);
	}
	
	

}
