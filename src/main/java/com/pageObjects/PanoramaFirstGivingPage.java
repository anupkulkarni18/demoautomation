package com.pageObjects;

import selenium.Element;
import selenium.LocatorType;

public class PanoramaFirstGivingPage {
	
	public Element reports = new Element(LocatorType.XPATH, "//a[contains(text(),'Reports') and @class='nav-link ng-binding']");

}
