package com.pageObjects;

import selenium.Element;
import selenium.LocatorType;

public class SignInPage {
	
	public Element loginID = new Element(LocatorType.XPATH,"//input[@id='loginEmail']");
	
	public Element password = new Element(LocatorType.XPATH,"//input[@id='loginPassword']");
	
	public Element submitButton = new Element(LocatorType.XPATH,"//input[@name='Submit']");
	
	public Element loggedInUserName = new Element(LocatorType.XPATH,"//*[@id=\"loggedInuserName\"]");
	

}
