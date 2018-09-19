package com.automation.testCases;

import org.testng.annotations.Test;

import applicationActions.AccountActions;

import com.automation.base.CustomException;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;

/**
 * 
 * This class is created to login
 * 
 * @author vrushaleep
 * 
 */
public class LRS_WEB_LoginIntoTheAccountAsSuperAdmin extends LRS_WEB_8549 {

	@Test(priority = 2)
	public void verifyLoginIntoTheAccountAsSuperAdmin() throws CustomException {

		AccountActions accountActions = new AccountActions();

		SeleniumCommon.waitForSeconds(20);
		accountActions.searchAccountAndSelect("Test-01.1");
		SeleniumCommon.waitForSeconds(5);
		accountActions.loginIntoAccountAsSuperAdmin();
		
		TestngVerifications.assertExpectedEqualsActualString("Test-01.1", accountActions.getAccountName());

	}

}
