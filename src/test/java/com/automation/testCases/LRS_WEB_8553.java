package com.automation.testCases;

import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.GroupActions;
import applicationActions.ReportingActions;
import applicationActions.SupportActions;
import applicationActions.SupportUsersActions;

import org.openqa.selenium.JavascriptExecutor;

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
public class LRS_WEB_8553 extends LRS_WEB_8549 {

	@Test(priority = 1)
	public void verifyAccountMenuOption() throws CustomException {

		AccountActions accountActions = new AccountActions();

		SeleniumCommon.waitForSeconds(10);
		accountActions.addAccount("Test-01.9", "101", "vrus@synerzip.com");

		SeleniumCommon.waitForSeconds(10);
		TestngVerifications.assertExpectedEqualsActualString("Test-01.9",
				accountActions.verifyAccountIsCreated("Test-01.9"));

		accountActions.verifyViewAccountsOptions();

	}

}
