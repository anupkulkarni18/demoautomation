package com.automation.testcasedemo;

import org.testng.annotations.Test;

import com.automation.browser.Browser;
import com.pageObjects.ReportingPage;
import com.selenium.common.TestngVerifications;


/**
 * 
 * This class is created to login 
 * @author rohitL
 *
 *In this test case we verify the support page using super admin. 
 * */

public class LRS_WEB_9192_SupportPage /*extends LRS_WEB_8549*/{
 
	@Test(priority=1)
  public void verifySupportPageThroughSuperAdmin() {
		ReportingPage rp = new ReportingPage();
	  rp.SupportTab.click();
	  Browser.swithToAdjustentTab();
		TestngVerifications.assertExpectedEqualsActualString("https://support.lrsus.com/hc/en-us", Browser.getCurrentURL());
		Browser.SwitchBackToOriginalTab();
	  
  }
}
