package com.pageObjects;

import selenium.Element;
import selenium.LocatorType;

public class SignInPage {
	
	public Element loginID = new Element(LocatorType.XPATH,"//input[@id='loginEmail']");
	
	public Element password = new Element(LocatorType.XPATH,"//input[@id='loginPassword']");
	
	public Element submitButton = new Element(LocatorType.XPATH,"//input[@name='Submit']");
	
	public Element signLink = new Element(LocatorType.XPATH,"//a[text()='Sign in ' and @class='themeLinks ng-scope']");
	
	public Element allowCookie = new Element(LocatorType.XPATH,"//a[text()='Allow Cookies']");
	
	public Element nonProfitAccountLink = new Element(LocatorType.XPATH,"//a[text()='Sign in to your nonprofit account']");
	
	public Element loginUsernameFirstGiving = new Element(LocatorType.XPATH, "//input[@name='email']");

	public Element loginPasswordFirstGiving = new Element(LocatorType.XPATH, "//input[@name='password']");
	
	public Element signInFirstGiving = new Element(LocatorType.XPATH, "//input[@value='Sign In']");

	
	
	
}
