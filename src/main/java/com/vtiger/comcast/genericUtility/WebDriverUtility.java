package com.vtiger.comcast.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * it contains webdriver specific actions
 * @author Rahil
 *
 */
public class WebDriverUtility {
	/**
	 * Implicit wait
	 * @param driver
	 */
	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	/**
	 * wait for page to load before indentifying any assychronized[java scripts actions] element in DOM [HTML-Docuent]
	 * @param driver
	 */
	
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
		
	}
	
	/**
	 * used to wait for element to be clickable in GUI ,& check for specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 */
	
	public void waitForElemenetToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * used to wait for element to be clickable in GUI ,& check for specific element for every 500 milli seconds by giving polling period
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws InterruptedException 
	 */
	public void waitForElementWithCustomTimeout(WebDriver driver, WebElement element, int pollingTime) throws InterruptedException
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * used to switch to any window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext())
		{
			String WID=it.next();
			driver.switchTo().window(WID);
			String currentWindowTitle = driver.getTitle();
			
			if(currentWindowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * used to Switch to Alert Window & click on OK button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
	
	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver, String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value form dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * used to select the value from dropdown using visible text
	 * @param element
	 * @param Text
	 */
	public void select(WebElement element, String Text) {
		Select s=new Select(element);
		s.selectByVisibleText(Text);
	}
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();	
	}
	
	/**
	 * used to right click  on specified element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * used to create javascript executor
	 * @param driver
	 * @param javascript
	 */
	
	public void executeJavaScript(WebDriver driver, String javascript) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeAsyncScript(javascript, null);
	}
	
	/**
	 * wait and click
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			}
			catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * to take screenshot
	 * @param driver
	 * @param screenshotName
	 * @throws IOException
	 */
	public void takeScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenshotName+".PNG");
		Files.copy(src, dest);
	}
	
	public void passEnterKey(WebDriver driver) {
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * to maximize the browser
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

}
