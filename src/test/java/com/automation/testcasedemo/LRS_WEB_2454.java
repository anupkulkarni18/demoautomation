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
 */
public class LRS_WEB_2454  {
	AccountActions accountActions = new AccountActions();

	@Test(priority = 6)
	public void verifyUserIsAbleToEditLocationField() throws CustomException {
		accountActions.verifyViewAccountMenuOptions();
		accountActions.searchAccountAndSelect(AccountConstants.accountName);
		SeleniumCommon.waitForSeconds(10);
		accountActions.editTableTrackerLocation(AccountConstants.locationLimit);
		accountActions.SwitchToAddAccount();
	}

}
