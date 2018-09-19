package com.automation.testCases;

import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.GroupActions;
import applicationActions.ReportingActions;
import applicationActions.SupportActions;
import applicationActions.SupportUsersActions;

import com.automation.base.CustomException;
import com.pageObjects.ReportingPage;
import com.selenium.common.SeleniumCommon;

/**
 * 
 * This class is created to login
 * 
 * @author vrushaleep
 * 
 */
public class LRS_WEB_8552 extends LRS_WEB_8549 {

	@Test(priority = 1)
	public void verifyAccountMenuOption() throws CustomException {

		AccountActions accountActions = new AccountActions();
		accountActions.verifyAddAccountAndViewAccountsOptions();

	}

	@Test(priority = 2)
	public void verifySupportUserOption() throws CustomException {
		SupportUsersActions supportUsersActions = new SupportUsersActions();
		supportUsersActions.navigateToSupportUsersMenu();

	}

	@Test(priority = 3)
	public void verifyReportingOption() throws CustomException {

		SeleniumCommon.waitForSeconds(10);
		ReportingActions reportingActions = new ReportingActions();
		reportingActions.navigateToReportingUsersMenu();

	}

	@Test(priority = 4)
	public void verifyGroupsOption() throws CustomException {
		SeleniumCommon.waitForSeconds(10);
		GroupActions groupActions = new GroupActions();
		groupActions.verifyGroupsOptions();

	}

	@Test(priority = 5)
	public void verifySupportOption() throws CustomException {
		SeleniumCommon.waitForSeconds(10);
		SupportActions support = new SupportActions();
		support.verifySupport();

	}
}
