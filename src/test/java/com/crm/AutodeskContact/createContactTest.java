package com.crm.AutodeskContact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createContactTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileInputStream fis= new FileInputStream("./data/vtigerData.properties");
		Properties p= new Properties();
		p.load(fis);
		
		//random num
		Random ran=new Random();
		int ranNum = ran.nextInt();
		
		FileInputStream fis_e=new FileInputStream("./data/vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis_e);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		String orgName = row.getCell(1).getStringCellValue()+ranNum;
		String industry = sheet.getRow(1).getCell(2).getStringCellValue();
		String type = sheet.getRow(1).getCell(3).getStringCellValue();
		String lastname = sheet.getRow(0).getCell(4).getStringCellValue();
//		System.out.println(orgName);
		
		
		
		String url = p.getProperty("URL");
		String username = p.getProperty("USERNAME");
		String password = p.getProperty("PASSWORD");
		String browser = p.getProperty("BROWSER");
		
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
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
//		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		WebElement ind = driver.findElement(By.name("industry"));
		Select s1=new Select(ind);
		s1.selectByVisibleText(industry);
		
		WebElement typ = driver.findElement(By.name("accounttype"));
		Select s2=new Select(typ);
		s2.selectByVisibleText(type);
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]"))));
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='account_name']/../img")).click();
		
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String parentID = it.next();
			String childID = it.next();
			
			driver.switchTo().window(childID);
			
			driver.findElement(By.name("search_text")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			driver.switchTo().window(parentID);
			}
			
			
			
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
			
			
			
			
//			Thread.sleep(3000);
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			
			
		}
	}


