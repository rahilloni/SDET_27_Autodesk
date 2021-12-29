package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	
	@FindBy(className = "dvHeaderText")
	private WebElement succMsg;
	
	public OrgInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSuccMsg() {
		return succMsg;
	}
	
	

}
