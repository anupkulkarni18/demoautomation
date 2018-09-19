package com.pageObjects;

import selenium.Element;
import selenium.LocatorType;

public class LocationPage {

public static String locationName1;


	public Element addLocationText = new Element(LocatorType.XPATH,
			"//a[contains(text(),'Add a location')]");
	
	public Element locationsTab = new Element(LocatorType.XPATH, "//a[@id=\"home-trigger\"]");
	
	public Element addLocationsTab = new Element(LocatorType.XPATH,"//a[@id=\"addLocation\"]");

	public Element noLocationAssignedText = new Element(
			LocatorType.XPATH,
			"//div[contains(text(),'No location is assigned')]");

	public Element locationName = new Element(LocatorType.XPATH,
			"//input[@name='name']");

	public Element custId = new Element(LocatorType.XPATH,
			"//input[@placeholder='Cust Id']");

	public Element address = new Element(LocatorType.XPATH,
			"//textarea[@placeholder='Address Line']");

	public Element phoneNo = new Element(LocatorType.XPATH,
			"//input[@name='phoneNo']");

	public Element saveButton = new Element(
			LocatorType.XPATH,
			"//button[@class='btn btn-primary saveModelBtn' and @style='display: inline-block;']");

	//public static Element locationText = new Element(LocatorType.XPATH,
	//		"//span[@class='lrsToolTip' and contains(text(),'"+LocationPage.locationName1+"\')]\"");
	
	
	public Element locationText = new Element(LocatorType.XPATH,"//span[@class='lrsToolTip' and contains(text(),'Mumbai')]\"");
	
	public String location1 ="//span[@class=\"lrsToolTip\" and contains(text(),'"; 
	
	public String location2 = "')]";
	
	public Element viewAllLocations = new Element(LocatorType.XPATH,"//a[@id='home']");
	
	public Element locations = new Element(LocatorType.XPATH,"//a[@id='home-trigger']");
	
	public Element searchLocations = new Element(LocatorType.XPATH,"//input[@id=\"mdSearchBox\"]");
	
	public Element searchLocationsIcon = new Element(LocatorType.XPATH,"//span[@class=\"mdSearchWidgetIcon\"]");
	
	public Element addLocationSubMenu = new Element(LocatorType.XPATH,"//li[@id='homeItem']/ul/li[1]/a");
	
	public Element notesTab = new Element(LocatorType.XPATH,"//div[@id='navmenu']/ul/li[5]/a");
	
	public Element appleId = new Element(LocatorType.XPATH,"//input[@name='appleId']");
	
	public Element appleIdPassword = new Element(LocatorType.XPATH,"//input[@name='appleIdPassword']");
	
	public Element pin = new Element(LocatorType.XPATH,"//input[@name='pin']");
	
	public Element wifiPassword = new Element(LocatorType.XPATH,"//input[@name='wifiPassword']");
	
	public Element warrantyExpirationDate = new Element(LocatorType.XPATH,"//input[@name='warrantyExpirationDate']");
	
	public Element notes = new Element(LocatorType.XPATH,"//textarea[@name='notes']");
	
	public Element noteSaveButton = new Element(LocatorType.XPATH,"//button[@class='btn btn-primary saveBtn' and text()='Save']");
	
	public Element layoutTab = new Element(LocatorType.XPATH,"//div[@id='navmenu']/ul/li[4]/a");
	
	public Element cancelButton = new Element(LocatorType.XPATH,"//button[@class=\"btn cancelBtn\" and @style=\"display: inline-block;\"]");
	
	public Element noLocationText = new Element(LocatorType.XPATH,"//div[@class=\"listItemGroupNoItemsNode\"]");

	public Element uploadImage = new Element(LocatorType.XPATH,"//div[@id='uploadImage']");
	
	public Element uploadedimages = new Element(LocatorType.XPATH,"//div[@id='imageMainContainer']");

}
