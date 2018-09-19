package com.automation.testcasedemo;

import org.testng.annotations.Test;

import applicationActions.AccountActions;

import com.application.constants.AccountConstants;
import com.automation.base.CustomException;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;

/**
 * 
 * This class is created to search and select by account name.
 * 
 * @author vrushaleep
 * 
 * Verify search and select
 */
public class LRS_WEB_8557/* extends LRS_WEB_8549 */{
	AccountActions accountActions = new AccountActions();

	@Test(priority = 6)
	public void verifySearchAndSelectAccount() throws CustomException {

		SeleniumCommon.waitForSeconds(20);
		accountActions.verifyViewAccountMenuOptions();
		accountActions.searchAccountAndSelect(AccountConstants.accountName);
		SeleniumCommon.waitForSeconds(10);
		TestngVerifications.assertExpectedEqualsActualString(
				AccountConstants.accountName, accountActions
						.verifyAccountIsCreated(AccountConstants.accountName));



	}



}
