package com.pageObjects;

import selenium.Element;
import selenium.LocatorType;

public class PanoramaFirstGivingReportsPage {
	
	public Element DonationReports = new Element(LocatorType.XPATH, "//h5[text()='Donation Reports']");

	public Element paymentReports = new Element(LocatorType.XPATH, "//h5[text()='Payment Reports']");

	public Element CardonfileSummary = new Element(LocatorType.XPATH, "//h5[text()='Card on file Summary']");

	public Element FundraisingReports = new Element(LocatorType.XPATH, "//h5[text()='Fundraising Reports']");

}
