package com.automation.testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.LoginActions;

import com.automation.base.CustomException;
import com.automation.browser.Browser;
import com.automation.browser.Chrome;

/**
 * Verify user should able to to edit the maximum allowed locations number for
 * "One Cue" Product
 * 
 * @author bharatp
 *
 */
public class LRS_ATC_2453 {
	AccountActions accountActions = new AccountActions();
	@BeforeTest
	public void beforeTest() throws CustomException {
		Browser browser = new Chrome();
		
		browser.openBrowser();
	}

	@Test(priority = 1)
	public void loginAsSuperUser() throws CustomException {
		LoginActions login = new LoginActions();
		login.loginInLRSApplication(applicationCredentials.UserCredentails.superAdminUsername, applicationCredentials.UserCredentails.sueperAdminPassword);
	}

/*	@Test(priority = 2)
	public void searchAccountAndClick() throws CustomException {
		accountActions.searchAccountAndSelect();
	}
//
	@Test(priority = 3)
	public void editOneCuePlan() throws CustomException {
		accountActions.editOneCuePlan();

	}

	@AfterTest
	public void afterTest() throws CustomException {
		browser.closeBrowser();
	}
*/
}
