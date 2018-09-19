package com.automation.testcasedemo;

import org.testng.annotations.Test;

import com.automation.base.CustomException;
import com.selenium.common.SeleniumCommon;
import applicationActions.AccountOwnerSummaryReportActions;
import applicationActions.ReportingActions;
import applicationActions.SmsUsageReportAction;
import applicationActions.TableTrackerOrderSummaryAction;

/**
 * 
 * This class is created to login 
 * @author rohitL
 *
 * In this Test case we verify Super Admin Reports i.e accountOwnerSummaryReport, smsUsageReportVerification and
 * tableTrackerOrderSummary Report. Wheather all element are properly persent and export button is working Fine.
 * */
public class LRS_WEB_8555/* extends LRS_WEB_8549*/{
	
 
  
	@Test(priority = 2)
	public void accountOwnerSummaryReportVerification() throws CustomException, InterruptedException {
		ReportingActions ra= new ReportingActions();
		  SeleniumCommon.waitForSeconds(10);
		  ra.navigateToReportingUsersMenu();
		AccountOwnerSummaryReportActions ASRA = new AccountOwnerSummaryReportActions();
		ASRA.openAccountSummaryReport();
		ASRA.verifyReportContent();
	}
	
	@Test(priority = 3)
	public void smsUsageReportVerification() throws CustomException, InterruptedException {
		ReportingActions ra= new ReportingActions();
		  SeleniumCommon.waitForSeconds(10);
		  ra.navigateToReportingUsersMenu();
		  SmsUsageReportAction sua = new SmsUsageReportAction();
		  sua.openSmsUsageReport();
		  sua.verifyReportContent();  		
	}
	
	@Test(priority = 4)
	public void tableTrackerOrderSummaryVerification1() throws CustomException, InterruptedException {
		ReportingActions ra= new ReportingActions();
		 ra.navigateToReportingUsersMenu();
		  SeleniumCommon.waitForSeconds(10);
		  TableTrackerOrderSummaryAction ttos= new TableTrackerOrderSummaryAction();
		  ttos.openSmsUsageReport();
		  ttos.verifyReportContent();
	}
	
	
		
	
	
	
	
	
	
	


}
