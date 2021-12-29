package com.crm.autodesk.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class createProductPage extends WebDriverUtility {
	
	@FindBy(name = "productname")
	private WebElement productNameEdt;
	
	
	@FindBy(name = "search_text")
	private WebElement searchForProductEdt;
	
	@FindBy(name = "bas_searchfield")
	private WebElement selectProductCategory;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public createProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getSelectProductCategory() {
		return selectProductCategory;
	}

	public WebElement getSearchForProductEdt() {
		return searchForProductEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
		
	}
	
	
	public void getProductCategory()
	{
		WebDriverUtility wib=new WebDriverUtility();
		wib.select(selectProductCategory, "Product Name");
		
	}
	
	



	
	

}
