package com.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionClass {

	public static WebElement fetchElement(WebDriver driver, By locator) {
		return driver.findElement(locator);	
	}

	public static void textFieldType(WebElement element, String value) {
		if(isElementDisplayed(element) && isElementEnabled(element)) {
			element.sendKeys(value);		
		}
		
	}
	
	public static void clickOnTheElement(WebElement element) {
		if(isElementDisplayed(element) && isElementEnabled(element)) {
			element.click();		
		}
	}
	
	public static boolean isElementDisplayed(WebElement element) {
		boolean flag = false;
		try {
		if(element.isDisplayed()) {
	      flag = true;
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
	
     public static boolean isElementEnabled(WebElement element) {
    	boolean flag = false;
 		try {
 		if(element.isEnabled()) {
 	      flag = true;
 		}
 		}catch(Exception e) {
 			System.out.println(e.getMessage());
 		}
 		return flag;
	}
     
	public static void waitForPageTitle( WebDriverWait wait , String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch(Exception e) {
			System.out.println("exception occured" + title);
		}
		
	}
	
	public static WebElement waitForElementPresent(WebDriverWait wait, By locator) {
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void JSclick(WebElement element, WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", element);	
	}

	public static void waitForInvisibilityOFElementPresent(WebDriverWait wait, By locator) {
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		
	}

	public static void selectDropdown(WebDriver driver, By locator, String dropdownValue) {
		 List<WebElement> dd= driver.findElements(locator);
			for (WebElement li : dd) {
			if (li.getText().equals(dropdownValue)) {
			     li.click();
			   }
			}
	}
}
