package com.automation.testCases;

import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.GroupActions;
import applicationActions.ReportingActions;
import applicationActions.SupportActions;
import applicationActions.SupportUsersActions;

import org.openqa.selenium.JavascriptExecutor;

import com.application.constants.AccountConstants;
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
 */
public class LRS_WEB_DeleteAccount{ //extends LRS_WEB_8549 {

	@Test(priority = 1)
	public void verifyAccountDelete() throws CustomException {

		AccountActions accountActions = new AccountActions();
		try {

			SeleniumCommon.waitForSeconds(10);
			accountActions.searchAccountAndSelect(AccountConstants.accountName);
			SeleniumCommon.waitForSeconds(10);
			accountActions.deleteAccount(AccountConstants.accountName);
			TestngVerifications.assertExpectedEqualsActualString("No Accounts found",
					accountActions.verifyAccountIsNotAvailable());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
