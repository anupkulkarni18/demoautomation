package com.pageObjects;

import selenium.Element;
import selenium.LocatorType;

/**
 * @author anupk
 *
 */
public class SearchPage {
	
	public Element searchResult = new Element(LocatorType.XPATH, "//a[@id=\"\"]");

}
