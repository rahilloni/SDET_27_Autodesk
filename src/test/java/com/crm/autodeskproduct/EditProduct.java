

package com.crm.autodeskproduct;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class EditProduct {
	
	public static void main(String[] args) throws IOException {
		
		FileUtility flib=new FileUtility();
		String url = flib.getPropertyKeyValue("URL");
		String username = flib.getPropertyKeyValue("USERNAME");
		String password = flib.getPropertyKeyValue("PASSWORD");
		String browser = flib.getPropertyKeyValue("BROWSER");
		
		
		ExcelUtility elib=new ExcelUtility();
		String productname = elib.getDataFromExcel("Sheet1", 1, 1);
		
		
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
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		driver.findElement(By.name("productname")).sendKeys(productname);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String succmsg = driver.findElement(By.xpath("//span[contains(text(),'Product Information')]")).getText();
		
		if(succmsg.contains("Product Information"))
		{
			System.out.println("Product successfully created");
		}
		else {
			System.out.println("product not created");
		}
		
		driver.findElement(By.linkText("Products")).click();
		
		driver.findElement(By.name("search_text")).sendKeys(productname);
		
		WebElement productbox = driver.findElement(By.id("bas_searchfield"));
		
		Select s=new Select(productbox);
		s.selectByVisibleText("Product Name");
		
		driver.findElement(By.xpath("(//input[@value=' Search Now '])[1]")).click();
		driver.findElement(By.xpath("//input[@name='selectall']")).click();
		driver.findElement(By.xpath("//input[@value='Mass Edit']")).click();
		
		String successmsg = driver.findElement(By.xpath("//td[text()='Mass Edit - Records Fields']")).getText();
	
		if (successmsg.contains("Mass Edit - Records Fields"))
		{
			System.out.println("Mass Edit page is displayed");
		}
		else
		{
			System.out.println("mass edit page is not displayed");
		}
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.mouseHoverOnElement(driver, signout);
		
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		

	}

}
