package com.pageObjects;


import selenium.Element;
import selenium.LocatorType;

/**
 * This class contains all the elements of login page
 * 
 * @author bharatp
 *
 */
public class LogoutPage {

	public Element loggedInUserName = new Element(LocatorType.XPATH,"//*[@id=\"loggedInuserName\"]");
	public Element signOut = new Element(LocatorType.XPATH, "//a[@role='menuitem']");
	
	public Element caret = new Element(LocatorType.XPATH,"//b[@class='caret']/preceding-sibling::span/parent::a/span");

	public Element forgetPassword = new Element(LocatorType.ID,"forgotPassword");

	public Element resetPasswordButton = new Element(LocatorType.ID,"btnForgotSubmit");
	
	public Element againLogin = new Element(LocatorType.XPATH,"//a[@id='login']");
	
	

	

}
