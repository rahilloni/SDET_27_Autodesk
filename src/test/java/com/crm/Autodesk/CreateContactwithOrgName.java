package com.crm.Autodesk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class CreateContactwithOrgName {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileUtility flib=new FileUtility();
		String url = flib.getPropertyKeyValue("URL");
		String username = flib.getPropertyKeyValue("USERNAME");
		String password = flib.getPropertyKeyValue("PASSWORD");
		String browser = flib.getPropertyKeyValue("BROWSER");
		
		JavaUtility jlib=new JavaUtility();
		int ranNum=jlib.getRandomNumber();
		
		
		ExcelUtility elib=new ExcelUtility();
		String orgName = elib.getDataFromExcel("Sheet1", 1, 1);
		
		System.out.println(orgName);
		
		
		
		WebDriver driver = null;
		
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();
			
		}
		else if(browser.equals("firefox"))
			{
			driver=new FirefoxDriver();
			}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		
		String organisation=orgName+ranNum;
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organisation);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("Contacts")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Rahil"+ranNum);
		
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		Thread.sleep(3000);
		
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.switchToWindow(driver, "Accounts");
		
		driver.findElement(By.id("search_txt")).sendKeys(orgName+ranNum);
		driver.findElement(By.xpath("//input[@name='search']")).click();	
		driver.findElement(By.linkText(organisation)).click();
		wlib.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@value='  Save  ']"));
		
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseHoverOnElement(driver, signout);
		
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		}	
		
}



