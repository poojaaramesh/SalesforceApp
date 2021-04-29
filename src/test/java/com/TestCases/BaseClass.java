package com.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
     public static WebDriver driver;     
     public static WebDriverWait wait;
	
	
	public static void launchApp(String browserName) {
		
		//launching the browser
		if(browserName.equals("chrome")) {
		//System.setProperty("webdriver.chrome.driver", "//Drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "./Drivers\\\\chromedriver.exe");
	
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {	
			System.setProperty("webdriver.gecko.driver", "./Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
		wait = new WebDriverWait(driver,50);		
		
		//navigating to the url
		driver.get("https://srsconsultinginc2.my.salesforce.com");
		System.out.println("The title is : " + driver.getTitle());
	}
	
	public static void login() {	
		
		WebElement loginUname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		loginUname.sendKeys("gangeyab-b4bn@force.com");
		
		driver.findElement(By.id("password")).sendKeys("Test12345!");
		driver.findElement(By.id("Login")).click();
 
        wait.until(ExpectedConditions.titleIs("Lightning Experience"));
		System.out.println("after login, the title is : " + driver.getTitle());
	}
	
	 public static void selectNavigationLink(String mainMenu, String subMenu) {
		 
	   // driver.findElement(By.xpath("//div[@class='slds-no-print oneAppNavContainer']//span[normalize-space()='\"+mainMenu+\"']"));
        
		 WebElement mm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-no-print oneAppNavContainer']//span[normalize-space()='\"+mainMenu+\"']//ancestor::one-app-nav-bar-item-root//lightning-primitive-icon")));	
		 mm.click();
		 WebElement sm =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'\"+subMenu+\"')]")));
		 sm.click();
		 
		 //wait.until(ExpectedConditions.titleIs(subMenu));
		 System.out.println(driver.getTitle());
		} 
	



	

	public static void selectNavigationLink() {
	
		 wait.until(ExpectedConditions.titleIs("Home | Salesforce"));
		 System.out.println("After succesfully loggin the title is : " + driver.getTitle());

		 WebElement mm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-no-print oneAppNavContainer']//span[normalize-space()='Accounts']//ancestor::one-app-nav-bar-item-root//lightning-primitive-icon")));	
		 mm.click();
		 WebElement sm =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'New Account')]")));
		 //sm.click();
		 
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", sm);
		
				
	}
	
	
	public static void CreateNewAccount() {
		
		
	    wait.until(ExpectedConditions.titleIs("New Account | Salesforce"));
		System.out.println("The title of create new account page is : " +driver.getTitle());
		
		Boolean b = driver.findElement(By.xpath("//span[contains(text(), 'Gangeya Velaga')]")).isDisplayed();
		if(b ==true) {
			System.out.println("Going the right way");
		} else  System.out.println("Wrong !!");
		WebElement a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Account Name')]//ancestor::div[3]//input")));
		a.sendKeys("AccountNameData");
		
		
		driver.findElement(By.xpath("//span[contains(text(),'Type')]/ancestor::div[3]//following-sibling::div//a")).click();
		//WebElement el = driver.findElement(By.id(typeSelect));
		//Select sel = new Select(el);
		//wait.until(ExpectedConditions.elementToBeClickable(el));
		//sel.selectByVisibleText(typeData);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-aura-class=\"uiPopupTarget uiMenuList uiMenuList--default uiMenuList--left uiMenuList--short\"]//div[@class = 'select-options']/ul")));
		List<WebElement> type1= driver.findElements(By.tagName("li"));
		for (WebElement li : type1) {
		if (li.getText().equals("Customer")) {
		     li.click();
		   }
		}
		
		driver.findElement(By.xpath("//span[contains(text(),'Website')]//ancestor::div[3]//input")).sendKeys("www.WebsiteName.com");
		
		driver.findElement(By.xpath("//span[contains(text(),'Description')]//ancestor::div[3]//textarea")).sendKeys("Description is Descirption is Description is Description is Descirption is Description ");
		
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]/ancestor::div[3]//input")).sendKeys("123456789");
		
		driver.findElement(By.xpath("//span[contains(text(),'Industry')]/ancestor::div[3]//following-sibling::div//a")).click();
		/*WebElement el1 = driver.findElement(By.id(industrySelect));
		Select sel1 = new Select(el1);
		sel1.selectByVisibleText(industryData);*/
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class ='select-options popupTargetContainer uiPopupTarget uiMenuList uiMenuList--default uiMenuList--left uiMenuList--short ']/div/ul")));
		List<WebElement> industry1= driver.findElements(By.tagName("li"));
		for (WebElement li : industry1) {
		if (li.getText().equals("Agriculture")) {
		     li.click();
		   }
		}
		
		driver.findElement(By.xpath("//span[contains(text(),'Employees')]/ancestor::div[3]//input")).sendKeys("employeesData");
		
		
	    Boolean b1 = driver.findElement(By.xpath("//span[contains(text(),'Address Information')]")).isDisplayed();
	    
	    if(b1==true) {
	    	System.out.println("Now entering the adress information -------");
	    } else System.out.println(" why is it not displayed? :/ ");	
	    
	    //Billing adress
	    driver.findElement(By.xpath("//span[contains(text(),'Billing Street')]//ancestor::div/textarea")).sendKeys("BangaloreStreet2242");
	    
	    driver.findElement(By.xpath("//span[contains(text(),'Billing City')]//ancestor::div/input")).sendKeys("Bangalore");
	    
	    driver.findElement(By.xpath("//span[contains(text(),'Billing State/Province')]//ancestor::div/input")).sendKeys("Karnataka");

	    driver.findElement(By.xpath("//span[contains(text(),'Billing Zip/Postal Code')]//ancestor::div/input")).sendKeys("560078");
	    
	    driver.findElement(By.xpath("//span[contains(text(),'Billing Country')]//ancestor::div/input")).sendKeys("India");
	    
        
	    //Shipping 
	    driver.findElement(By.xpath("//span[contains(text(),'Shipping Street')]//ancestor::div/textarea")).sendKeys("ChennaiStreet32432");
	    
	    driver.findElement(By.xpath("//span[contains(text(),'Shipping City')]//ancestor::div/input")).sendKeys("Chennai");
	    
	    driver.findElement(By.xpath("//span[contains(text(),'Shipping State/Province')]//ancestor::div/input")).sendKeys("Tamil Nadu");

	    driver.findElement(By.xpath("//span[contains(text(),'Shipping Zip/Postal Code')]//ancestor::div/input")).sendKeys("600097");
	    
	    driver.findElement(By.xpath("//span[contains(text(),'Shipping Country')]//ancestor::div/input")).sendKeys("India");  
	    
	    
	    driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();
	    
	    
	    System.out.println("The information was saved succesfully");
	
	    
	}
	
	public static void tearDown()  {		
		driver.close();
		
	}
	

}
