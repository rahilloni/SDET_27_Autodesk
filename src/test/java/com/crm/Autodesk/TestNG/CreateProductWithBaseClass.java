package com.crm.Autodesk.TestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.ProductInfoPage;
import com.crm.autodesk.ObjectRepository.createProductPage;
import com.crm.autodesk.ObjectRepository.productPage;
import com.vtiger.comcast.genericUtility.BaseClass;
@Listeners(com.vtiger.comcast.genericUtility.ListenerImplementation.class)
public class CreateProductWithBaseClass extends BaseClass {
	
	@Test(groups = "SmokeTest")
	public void CreateProductWithBaseClass() throws EncryptedDocumentException, IOException {
		
	//get random no 
		int ranNum=jlib.getRandomNumber();
						
	//read data from excel
		String productName=elib.getDataFromExcel("Sheet1", 1, 5)+ranNum;
						
						
	//navigate to organisation module
		HomePage hp=new HomePage(driver);
		hp.getProductsLink().click();

		productPage pp=new productPage(driver);
		pp.getNewProductImg().click();
		
		createProductPage cpp=new createProductPage(driver);
		cpp.getProductNameEdt().sendKeys(productName);
		
		cpp.getSaveBtn().click();
		
		ProductInfoPage pip=new ProductInfoPage(driver);
		String succMsg = pip.getSuccMsg().getText();
		Assert.assertTrue(succMsg.contains(productName));
		System.out.println("Product created");
		
		
		
		
		
		
		
	}

}
