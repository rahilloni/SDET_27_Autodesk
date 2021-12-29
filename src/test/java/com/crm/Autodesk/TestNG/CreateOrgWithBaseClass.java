package com.crm.Autodesk.TestNG;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateOrganisationsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrgInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.vtiger.comcast.genericUtility.BaseClass;
@Listeners(com.vtiger.comcast.genericUtility.ListenerImplementation.class)
public class CreateOrgWithBaseClass extends BaseClass{
	
	@Test(groups = "SmokeTest")
	public void CreateOrgWithBaseClass() throws EncryptedDocumentException, IOException {
		
		
		//get random no 
		int ranNum=jlib.getRandomNumber();
		
		//read data from excel
		String orgName=elib.getDataFromExcel("Sheet1", 1, 1)+ranNum;
		
		
		//navigate to organisation module
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		
		//click on create organization
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgLookUpImg().click();
		
		CreateOrganisationsPage cop=new CreateOrganisationsPage(driver);
		cop.enterOrgName(orgName);
		
		cop.getSaveBtn().click();
		
		OrgInfoPage oip=new OrgInfoPage(driver);
		String succMsg = oip.getSuccMsg().getText();
		Assert.assertTrue(succMsg.contains(orgName));
		System.out.println("organization created ");
		
		
		
		
		
	
	}
		
}



