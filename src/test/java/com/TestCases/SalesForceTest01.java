package com.TestCases;


public class SalesForceTest01 {
	
	
     public static void main(String args[]) throws InterruptedException {
		
		
		String browserName = "chrome";
		//String mainMenu ="Accounts";
		//String subMenu = "New Account";
	
		
		BaseClass.launchApp(browserName);
		BaseClass.login();
		//BaseClass.selectNavigationLink(mainMenu,subMenu);
		BaseClass.selectNavigationLink();
		BaseClass.CreateNewAccount();
		BaseClass.tearDown();
		
	}

}
