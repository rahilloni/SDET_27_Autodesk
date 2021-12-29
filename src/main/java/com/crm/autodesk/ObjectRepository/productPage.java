package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class productPage extends WebDriverUtility  {
	//create new product button	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement newProductImg;
	
	//seacrh for product text field
	@FindBy(name = "search_text")
	private WebElement searchForProductEdt;
	
	//select product category dropdown
	@FindBy(name = "bas_searchfield")
	private WebElement selectProductCategory;
	
	//save product button
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public productPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}

	public WebElement getNewProductImg() {
		return newProductImg;
	}

	public WebElement getSearchForProductEdt() {
		return searchForProductEdt;
	}

	public WebElement getSelectProductCategory() {
		return selectProductCategory;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	
	public void selectProductCategory(WebElement selectProductCategory, int index) {
		
		select(selectProductCategory, index);		
		//WebDriverUtility wlib=new WebDriverUtility();
		//wlib.select(selectProductCategory, Product Name);
		
	}

}
