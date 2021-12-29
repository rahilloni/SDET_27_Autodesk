package com.crm.Autodesk.TestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.vtiger.comcast.genericUtility.BaseClass;
@Listeners(com.vtiger.comcast.genericUtility.ListenerImplementation.class)
public class CreateContactWithBaseClass extends BaseClass {
	
	@Test(groups = "RegressionTest")
	public void CreateContactWithBaseClass() throws EncryptedDocumentException, IOException {
		//get random no 
		int ranNum=jlib.getRandomNumber();
				
		//read data from excel
		String orgName=elib.getDataFromExcel("Sheet1", 1, 1)+ranNum;
				
				
		//navigate to organisation module
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactLookUpImg().click();
		
		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.enterLastName(orgName);
		
		ccp.getSaveBtn().click();
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String succMsg = cip.getSuccMsg().getText();
		
		System.out.println(cip);
		
		Assert.assertTrue(succMsg.contains(orgName));
		System.out.println("contact created");
		
	}

}
