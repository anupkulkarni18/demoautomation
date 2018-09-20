package com.automation.panorama;

import org.testng.annotations.Test;

import com.application.constant.FirstGivingLoginCredential;
import com.automation.browser.Browser;
import com.pageObjects.SignInPage;
import com.selenium.common.TestngVerifications;

import applicationActions.PanoramaFirstGivingActions;
import applicationActions.PanoramaFirstGivingReportsAction;
import applicationActions.PanoramaHomeAction;
import applicationActions.SignInAction;

public class VerifyCardOnFileReportTestCaseNo8 extends LoginPanorama {
	
	@Test
	  public void VerifyCardOnFileReport() throws InterruptedException {
		test=extent.createTest("CardOnFileReport");
		  SignInAction sia =new SignInAction();
			sia.clickOnSignLink();
			sia.clickOnNonProfitAccountLink();
			sia.loginFirstGiving(FirstGivingLoginCredential.username, FirstGivingLoginCredential.password);
			SignInPage sip =new SignInPage();
			sip.allowCookie.click();
			PanoramaHomeAction pha = new PanoramaHomeAction();
			pha.clickOnFirstGivingIcon();
			PanoramaFirstGivingActions pga = new PanoramaFirstGivingActions();
			pga.clickOnFirstGivingReports();
			PanoramaFirstGivingReportsAction pra = new PanoramaFirstGivingReportsAction();
			pra.clickOnFirstGivingCardonfileSummary();
		//	TestngVerifications.assertExpectedEqualsActualBoolean(true, Browser.getCurrentURL().contains("payments"));
			
	  }
	  

}
