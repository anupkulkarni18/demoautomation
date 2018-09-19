package com.automation.testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.GroupActions;
import applicationActions.LoginActions;

import com.automation.base.CustomException;
import com.automation.browser.Browser;
import com.automation.browser.Chrome;

/**
 * Verify that user is able to navigate to Groups submenu.
 * 
 * @author bharatp
 *
 */
public class LRS_TC_8556 {

	Browser browser;
	LoginActions login;
	AccountActions accountActions;
	GroupActions groupActions;

	@BeforeTest
	public void openLRSWebApplication() throws CustomException {
		browser = new Chrome();
		login = new LoginActions();
		accountActions = new AccountActions();
		groupActions = new GroupActions();

		browser.openBrowser();
	}

	@Test(priority = 1)
	public void loginAsSuperUser() {

		login.loginInLRSApplication(
				applicationCredentials.UserCredentails.superAdminUsername,
				applicationCredentials.UserCredentails.sueperAdminPassword);
	}

	@Test(priority = 2)
	public void verifyAddGroupAndViewAllGroupsOptions() {
		accountActions.nevigateToHomePage();
		groupActions.verifyGroupsOptions();

	}

//	@Test(priority = 3)
//	public void navigateToAddGroupPage() {
//		groupActions.nevigateToAddGroupPage();
//	}
//
//	@Test(priority = 4)
//	public void navigateToViewAllGroupsPage() {
//		groupActions.nevigateToViewAllGroupsPage();
//	}

	@AfterTest
	public void afterTest() throws CustomException {
		browser.closeBrowser();
		login = null;
		accountActions = null;
		groupActions = null;
	}

}
