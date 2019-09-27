package com.loblaws.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class commonPO {
	
	@FindBy(xpath="//span[contains(text(), 'My Shop')]")
	public
	WebElement lnkMyShop;
	
	@FindBy(xpath="//a[@class= 'quick-shop-anonymous-content__login-button' and contains(@href, '/account/login?redirect=/quickshop?navid=quick-shop&navid=My-Shop')]/span")
	public
	WebElement btnSignIn;
	
	@FindBy(xpath="//span[contains(text(), 'Create a ')]")
	public
	WebElement lnkCreatePCId;
	
	@FindBy(xpath="//*[@id='termsAndConditions' ]")
	public
	WebElement lnkTermsCond;
	
	@FindBy(name="email")
	public
	WebElement txtEmail;
	
	@FindBy(name="newPassword")
	public
	WebElement txtPassword;
	
	@FindBy(xpath="//form[@id='create-account']/fieldset/button")
	public
	WebElement btnCreatePCId;
	
	@FindBy(xpath="//h2[contains(text(), 'Complete Your Profile')]")
	public
	WebElement headerProfile;
}
