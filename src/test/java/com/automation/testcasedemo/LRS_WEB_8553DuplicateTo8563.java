package com.automation.testcasedemo;

import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.GroupActions;
import applicationActions.ReportingActions;
import applicationActions.SupportActions;
import applicationActions.SupportUsersActions;

import org.openqa.selenium.JavascriptExecutor;

import com.application.constants.AccountConstants;
import com.application.constants.GroupConstants;
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
 * Verify that test user is able to navigate to 'Account'  sub menus
 */
public class LRS_WEB_8553DuplicateTo8563{
	AccountActions accountActions = new AccountActions();

	@Test(priority = 6)
	public void verifyCreateAccountOption() throws CustomException {

		SeleniumCommon.waitForSeconds(5);
		accountActions.verifyViewAccountsOptions();
		accountActions.addAccount(AccountConstants.accountName,
				AccountConstants.customerId, AccountConstants.email);
		SeleniumCommon.waitForSeconds(10);
		TestngVerifications.assertExpectedEqualsActualString(
				AccountConstants.accountName, accountActions
						.verifyAccountIsCreated(AccountConstants.accountName));

		
		
		
	}
	
	



}
