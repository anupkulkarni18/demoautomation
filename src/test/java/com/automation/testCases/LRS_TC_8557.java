package com.automation.testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.LoginActions;

import com.automation.base.CustomException;
import com.automation.browser.Browser;
import com.automation.browser.Chrome;

/**
 * Verify user is able to search & select a account from super admin
 * 
 * @author bharatp
 *
 */
public class LRS_TC_8557 {

	Browser browser;
	LoginActions login;
	AccountActions accountActions;

	@BeforeTest
	public void openLRSWebApplication() throws CustomException {
		browser = new Chrome();
		login = new LoginActions();
		accountActions = new AccountActions();

		browser.openBrowser();
	}

	@Test(priority = 1)
	public void loginAsSuperUser() {

		login.loginInLRSApplication(
				applicationCredentials.UserCredentails.superAdminUsername,
				applicationCredentials.UserCredentails.sueperAdminPassword);
	}

	@Test(priority = 2)
	public void verifyAccountsOptions() {
		accountActions.nevigateToHomePage();
		accountActions.verifyAddAccountAndViewAccountsOptions();
	}

	@Test(priority = 3)
	public void searchAccountAndClick() {
		accountActions.searchAccountAndSelect("anup.kulkarni@synerzip.com");
	}

	@AfterTest
	public void afterTest() throws CustomException {
		browser.closeBrowser();
		login = null;
		accountActions = null;
	}

}
