package com.qa.shop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import implicitandExplicitWait.FluentWait;

public class ElementUtil {
	
	private WebDriver driver;
	
public ElementUtil(WebDriver driver) {
	this.driver = driver;
}

/**
 * This method is used to getElement by providng the locator
 * @param locator
 * @return WebElement
 */
public WebElement getElement(By locator) {
	WebElement element = null;
	try {
		element = driver.findElement(locator);
	} catch (Exception e) {
	System.out.println("The locator could not be read: "+ locator);
	}
	return element;
}

public void doClick(By locator) {
	getElement(locator).click();
}

public void doSendKeys(By locator, String Value) {
	getElement(locator).sendKeys(Value);
}

public String doGetText(By locator) {
	return getElement(locator).getText();
}



//		-------------------------Wait Utilities-----------------------------------
		

		
		public void clickWhenReady(int timeout,By locator) {
			WebDriverWait wait = new WebDriverWait(driver,timeout);
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		}
}


