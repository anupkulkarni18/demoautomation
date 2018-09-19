package com.pageObjects;

import selenium.Element;
import selenium.LocatorType;

/**
 * This class contains all the elements of login page
 * 
 * @author bharatp
 *
 */
public class LoginPage {

	public Element loginUsername = new Element(LocatorType.XPATH, "//input[@id='j_username']");

	public Element loginPassword = new Element(LocatorType.XPATH, "//input[@id='j_password']");
	
	public Element conformforgetPassword = new Element(LocatorType.ID, "j_confirm_password");
	
	public Element forgetPasswordOKbutton =new Element(LocatorType.ID, "btnOkSubmit");
		
	
	public Element loginButton = new Element(LocatorType.XPATH, "//button[contains(.,'Login')]");
	
	public static Element loggedInUserName = new Element(LocatorType.ID, "loggedInuserName");

	public static Element profileOption = new Element(LocatorType.ID, "lrsadminAccountSettingsMenuItem");
	
	public static Element accountRoleName = new Element(LocatorType.ID, "accountSettingRoleName");
	
	public Element lrsAdminAccountsItem = new Element(LocatorType.XPATH, "//*[@id='lrsadminAccountsItem']");
	
	public static Element dropDownMenu = new Element(LocatorType.XPATH, "//ul[@class='dropdown-menu']//li/a");

	public static Element loginUsernameError = new Element(LocatorType.ID, "j_username_error");

	public static Element loginPasswordError  = new Element(LocatorType.ID, "j_password_error");
		
	public  Element changeAccountownerFirstname  = new Element(LocatorType.XPATH, "//input[@name='firstName']");
	
	public Element changeAccountownerLastname  = new Element(LocatorType.XPATH, "//input[@name='lastName']");
	
	public Element password  = new Element(LocatorType.XPATH, "//input[@name='password']");
	
	public Element conformPassword  = new Element(LocatorType.XPATH, "//input[@name='confirmPassword']");
	
	public Element conformButton  = new Element(LocatorType.ID, "btnProfileSubmit");

	
	public static Element errorMsg  = new Element(LocatorType.ID, "//div[@id='errorDiv']");
	
	public String userLogin1  = "//span[contains(text(),\""; 
	
	public String userLogin2  = "\")]"; 
	
	
	
	
	

	
}
