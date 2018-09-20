package com.pageObjects;

import selenium.Element;
import selenium.LocatorType;

public class HomePage {
	
	public Element searchText = new Element(LocatorType.XPATH, "//a[@id=\"search_for_box\"]");
	
	public Element searchButton = new Element(LocatorType.XPATH, "//a[@id=\"search_btn_hdr\"]");
	

}
