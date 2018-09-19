package com.automation.testCases;

import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.AccountUserActions;
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
public class LRS_WEB_CreateAccountUser //extends
		{ //LRS_WEB_LoginIntoTheAccountAsSuperAdmin {

	@Test(priority = 3)
	public void verifyLoginIntoTheAccountAsSuperAdmin() throws CustomException {

		SeleniumCommon.waitForSeconds(20);
		AccountUserActions accountUserActions = new AccountUserActions();

		accountUserActions.addUser("vrusha@gmail.com", "Manager");

	}

}
