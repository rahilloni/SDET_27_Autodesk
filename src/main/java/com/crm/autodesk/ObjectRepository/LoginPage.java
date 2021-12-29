package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.FileUtility;

public class LoginPage  {//step1 create a seperate class for every web page in an application
	
	//step 2 Identify all elements using @findby, findbys and findAll  (Declaration)
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//step 3  Execute all the elements & initialize pageFactory.initElements  [initialization]
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step 4 Declare all the elements as private 
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//step 5 Business logic
	public void loginToApp(String userName, String password)
	{
		usernameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	

}
