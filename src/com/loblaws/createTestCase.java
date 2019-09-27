package com.loblaws;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.loblaws.RuntimeConfigs;
import com.loblaws.utility.WebDriverInstance;
import com.loblaws.utility.commonFunctions;
import com.loblaws.utility.commonPO;

public class createTestCase {
	
	private static WebDriver driver = null;
	private static commonPO LBpage = null;
	
	static{
		try {
			driver = WebDriverInstance.getWebDriverInstace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LBpage = PageFactory.initElements(driver, commonPO.class);
	}
	
	public static String createNewID() {
		
		try {
			driver.get(RuntimeConfigs.getconfigValue("app.url"));
			commonFunctions.waitForPageLoaded(driver);
			
			LBpage.lnkMyShop.click();
			commonFunctions.waitForPageLoaded(driver);
			
			LBpage.btnSignIn.click();
			commonFunctions.waitForPageLoaded(driver);
			
			LBpage.lnkCreatePCId.click();
			commonFunctions.waitForPageLoaded(driver);
			
			LBpage.txtEmail.sendKeys(commonFunctions.getRandomName()+"@gmail.com");
			Thread.sleep(1000);
			commonFunctions.waitForPageLoaded(driver);
			String labelVal = LBpage.txtEmail.getAttribute("aria-invalid");
			
			if (labelVal != null) {
				System.out.println("Email Id is Invalid. Please try again");
				return "FAIL";
			}
			
			LBpage.txtPassword.sendKeys("Password321+");
			Thread.sleep(1000);
			commonFunctions.waitForPageLoaded(driver);
			
			if (LBpage.txtPassword.getAttribute("aria-invalid") != null) {
				System.out.println("Password is Invalid. Please try again");
				return "FAIL";
			}
			
			LBpage.lnkTermsCond.click();
			commonFunctions.waitForPageLoaded(driver);
			
			LBpage.btnCreatePCId.click();
			commonFunctions.waitForPageLoaded(driver);
			
			if (commonFunctions.isElementPresent_WE(driver, LBpage.headerProfile, "Header").equals("PASS")) {
				System.out.println("New Account Creation is successful");
				return "PASS";
			}else {
				System.out.println("New Account Creation FAILED");
				return "FAIL";
			}
		}catch(NoSuchElementException e1) {
			System.out.println("Specified element doesn't exist. Please verify");
			return "FAIL";
		}catch(Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
	}
}
