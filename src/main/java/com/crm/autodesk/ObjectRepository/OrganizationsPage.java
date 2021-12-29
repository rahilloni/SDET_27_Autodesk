package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchOrgEdt;
	
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement searchOrgbtn;
	
	//step 2
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//getters
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}

	public WebElement getSearchOrgEdt() {
		return searchOrgEdt;
	}

	public WebElement getSearchOrgbtn() {
		return searchOrgbtn;
	}
	
	

}
