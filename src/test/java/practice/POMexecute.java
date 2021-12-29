package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.ObjectRepository.CreateOrganisationsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrgInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.ObjectRepository.ProductInfoPage;
import com.crm.autodesk.ObjectRepository.createProductPage;
import com.crm.autodesk.ObjectRepository.productPage;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class POMexecute {
	
	public static void main(String[] args) throws IOException {
		
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelUtility elib=new ExcelUtility();
		String orgName = elib.getDataFromExcel("Sheet1", 1, 1);
		
		int ranNum = jlib.getRandomNumber();
		
		//read common data
		String url = flib.getPropertyKeyValue("URL");
		String username = flib.getPropertyKeyValue("USERNAME");
		String password = flib.getPropertyKeyValue("PASSWORD");
		String browser = flib.getPropertyKeyValue("BROWSER");
		
		//launch the browser
		
		WebDriver driver = null;
		
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();
			
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		
		//login to app
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(username, password);
		
		//click on organisations
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		//create organisations
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrgLookUpImg().click();
		
		//
		CreateOrganisationsPage cop=new CreateOrganisationsPage(driver);
		cop.getEnterOrgNameEdt().sendKeys(orgName+ranNum);
		
		cop.getSaveBtn().click();
		
		//validating 
		wlib.waitForPageToLoad(driver);
		OrgInfoPage oip=new OrgInfoPage(driver);
		String actualmsg = oip.getSuccMsg().getText();
		if(actualmsg.contains(orgName))
		{
			System.out.println("Organization created");
		}
		else
		{
			System.out.println("organization not created");
		}
		
		hp.getProductsLink().click();
		
		//productpage
		productPage pg=new productPage(driver);
		pg.getNewProductImg().click();
		
		//createproduct page
		createProductPage cpp=new createProductPage(driver);
		String productName="keyboard"+ranNum;
		cpp.getProductNameEdt().sendKeys(productName);
		cpp.getSaveBtn().click();
		
		//validate product
		ProductInfoPage pig=new ProductInfoPage(driver);
		String Actualmsg = pig.getSuccMsg().getText();
		
		if(Actualmsg.contains(productName))
		{
			System.out.println("Product created successfully");
		}
		else
		{
			System.out.println("Product not created succesfully");
		}
		
		hp.getProductsLink().click();
		
		pg.getSearchForProductEdt().sendKeys(productName);
		
//		pg.selectProductCategory(, 2);
		pg.getSaveBtn().click();
		
		hp.getAdministratorImg().click();
		hp.logout(driver);
		
		
		
	}

}
