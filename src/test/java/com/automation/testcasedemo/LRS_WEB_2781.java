package com.automation.testcasedemo;

import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.AccountUserActions;
import applicationActions.GroupActions;
import applicationActions.ReportingActions;
import applicationActions.SupportActions;
import applicationActions.SupportUsersActions;

import org.openqa.selenium.JavascriptExecutor;

import com.application.constants.AccountConstants;
import com.application.constants.AccountUserConstants;
import com.automation.base.CustomException;
import com.automation.browser.Browser;
import com.pageObjects.ReportingPage;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;

/**
 * 
 * This class is created to login
 * 
 * @author vrushaleep
 * 
 * Login to user account as super admin and add user
 * 
 */
public class LRS_WEB_2781 extends LRS_WEB_8549 {

	@Test(priority = 11)
	public void verifyLoginIntoTheAccountAsSuperAdmin() throws CustomException {
		AccountActions accountActions = new AccountActions();
		SeleniumCommon.waitForSeconds(20);
		accountActions.searchAccountAndSelect1(AccountConstants.accountName);
		SeleniumCommon.waitForSeconds(5);
		accountActions.loginIntoAccountAsSuperAdmin();

		TestngVerifications.assertExpectedEqualsActualString(
				AccountConstants.accountName, accountActions.getAccountName());
		SeleniumCommon.waitForSeconds(20);
		AccountUserActions accountUserActions = new AccountUserActions();

		accountUserActions.addUser(AccountUserConstants.email, AccountUserConstants.permissionBy);

	}

}
