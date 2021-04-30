package com.TestCases;


public class SalesForceTest01 {
	
	
     public static void main(String args[]) throws InterruptedException {
		
		
		String browserName ="chrome";
	
		
		BaseClass.launchApp(browserName);
		BaseClass.login();
		BaseClass.selectNavigationLink();
		BaseClass.CreateNewAccount();
		//BaseClass.CreateNewAccountwithoutActionClass();
	    BaseClass.tearDown();
		
	}

}
