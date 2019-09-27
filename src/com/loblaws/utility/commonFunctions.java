package com.loblaws.utility;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonFunctions {
	
	public static void waitForPageLoaded(WebDriver driver1) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					Thread.sleep(2000l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Boolean flg = ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				return flg;
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver1, 500);
		try {
			wait.until(expectation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String isElementPresent_WE(WebDriver driver, WebElement element, String ctrlName) {
		
		boolean flag;
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    System.out.println("Verify the existence of element - "+ctrlName);
	    String returnVal = "FAIL";
	    
	    if (element != null){
	    	 try{
	 	    	flag = element.isDisplayed();	 	    	
	 	    	if (flag){
	 	    		System.out.println("Element Found - TRUE "+ctrlName);
	 	    		returnVal = "PASS";
	 	    	}
	 	    } catch (NoSuchElementException e){
	 	        returnVal = "FAIL";
	 	       System.out.println("Element Found - FALSE "+ctrlName);
	 	    } 
	    }else{
	    	 returnVal = "FAIL";
	    }
	   
	    return returnVal;
	}
	
	public static String getRandomName() {
		final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		final java.util.Random rand = new java.util.Random();

		final Set<String> identifiers = new HashSet<String>();
		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			int length = rand.nextInt(5) + 9;
			for (int i = 0; i < length; i++) {
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
			if (identifiers.contains(builder.toString())) {
				builder = new StringBuilder();
			}
		}
		return builder.toString();

	}

}
