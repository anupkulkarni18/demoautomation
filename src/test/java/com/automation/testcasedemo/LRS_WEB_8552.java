package com.automation.testcasedemo;

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
 * In this test case we verify all the menu of home page of super admin.
 */
public class LRS_WEB_8552  {

	@Test
	public void verifyAccountMenuOption() throws CustomException {

		//super.loginAsSuperUser();
		SeleniumCommon.waitForSeconds(10);
		AccountActions accountActions = new AccountActions();
		accountActions.verifyAddAccountAndViewAccountsOptions();

	}

	@Test(dependsOnMethods={"verifyAccountMenuOption"}, alwaysRun=true)
	public void verifySupportUserOption() throws CustomException {

		SupportUsersActions supportUsersActions = new SupportUsersActions();
		supportUsersActions.navigateToSupportUsersMenu();

	}

	@Test(dependsOnMethods={"verifySupportUserOption"}, alwaysRun=true)
	public void verifyReportingOption() throws CustomException {

		ReportingActions reportingActions = new ReportingActions();
		SeleniumCommon.waitForSeconds(2);
		reportingActions.navigateToReportingUsersMenu();

	}

	@Test(dependsOnMethods={"verifyReportingOption"}, alwaysRun=true)
	public void verifyGroupsOption() throws CustomException {

		GroupActions groupActions = new GroupActions();
		groupActions.verifyGroupsOptions();

	}

	@Test(dependsOnMethods={"verifyGroupsOption"}, alwaysRun=true)
	public void verifySupportOption() throws CustomException {
	
		SupportActions support = new SupportActions();
		support.verifySupport();

	}
}
