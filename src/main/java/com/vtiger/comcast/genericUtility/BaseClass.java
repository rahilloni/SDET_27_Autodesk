package com.vtiger.comcast.genericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

public class BaseClass {
	
	public DataBaseUtility dblib=new DataBaseUtility();
	public FileUtility flib=new FileUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"SmokeTest","RegressionTest"})
	public void connectDB() throws SQLException
	{
		dblib.connectToDatabase();
		
	}
	
	@BeforeClass(groups = {"SmokeTest","RegressionTest"})
	public void launchBrowser() throws IOException {
		//read the data
		String url = flib.getPropertyKeyValue("URL");
		String browser = flib.getPropertyKeyValue("BROWSER");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		sdriver=driver;
		wlib.waitForPageToLoad(driver);
		driver.get(url);
	}
	
	@BeforeMethod(groups = {"SmokeTest","RegressionTest"})
	public void LoginToApp() throws IOException {
		String username = flib.getPropertyKeyValue("USERNAME");
		String password = flib.getPropertyKeyValue("PASSWORD");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(username, password);
		System.out.println("========Login Successfull========");
	}
	
	@AfterMethod(groups = {"SmokeTest","RegressionTest"})
	public void logoutOfApp() {
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
		System.out.println("===========logout successfull=========");
	}
	
	@AfterClass(groups = {"SmokeTest","RegressionTest"})
	public void closeBrowser() {
		driver.quit();
		System.out.println("==============Browser closed==============");
	}
	
	@AfterSuite(groups = {"SmokeTest","RegressionTest"})
	public void closeDatabaseConnection() {
		dblib.closeDatabase();
		System.out.println("==========database closed===");
		
	}
	

}
