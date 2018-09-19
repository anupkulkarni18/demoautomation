package com.automation.testcasedemo;

import org.testng.annotations.Test;

import com.application.constants.AccountConstants;
import com.automation.base.CustomException;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;

import applicationActions.AccountActions;
import applicationActions.AccountUserActions;

/**
 * 
 * This class is created to login 
 * @author rohitL
 * 
 * In this case we login to the specific account which is mention in AccountConstants page and verify all the sub menu of user and switch back.   
 *
 */
public class LRS_WEB_8690/* extends LRS_WEB_8549 */{
	@Test(priority = 7)
	public void verifyLoginIntoTheAccountAsSuperAdmin() throws CustomException {

		AccountActions accountActions = new AccountActions();

		accountActions.verifyViewAccountMenuOptions();
		SeleniumCommon.waitForSeconds(5);
		accountActions.searchAccountAndSelect(AccountConstants.accountName);
		SeleniumCommon.waitForSeconds(5);
		accountActions.loginIntoAccountAsSuperAdmin();

		TestngVerifications.assertExpectedEqualsActualString(
				AccountConstants.accountName, accountActions.getAccountName());

	}
	@Test(dependsOnMethods = { "verifyLoginIntoTheAccountAsSuperAdmin" },alwaysRun = true)
	public void verifyReportsSubMenu() throws CustomException {
		SeleniumCommon.waitForSeconds(15);
		AccountUserActions RA = new AccountUserActions();
		RA.verifySubMenuReports();
		
		
	}
	@Test(dependsOnMethods = { "verifyReportsSubMenu" },alwaysRun = true)
	public void verifyLocationSubMenu() throws CustomException {
		SeleniumCommon.waitForSeconds(5);
		AccountUserActions RA = new AccountUserActions();
		RA.verifySubMenuLocations();
		
		
	}
	@Test(dependsOnMethods = { "verifyLocationSubMenu" },alwaysRun = true)
	public void verifyUsersSubMenu() throws CustomException {
		SeleniumCommon.waitForSeconds(5);
		AccountUserActions RA = new AccountUserActions();
		RA.verifySubMenuUsers();
		
		
	}
	
	@Test(dependsOnMethods = { "verifyUsersSubMenu" },alwaysRun = true)
	public void verifySettingsSubMenu() throws CustomException {
		SeleniumCommon.waitForSeconds(5);
		AccountUserActions RA = new AccountUserActions();
		RA.verifySubMenuSettings();
		
		
	}
	
	@Test(dependsOnMethods = { "verifySettingsSubMenu" },alwaysRun = true)
	public void verifySupportSubMenu() throws CustomException {
		SeleniumCommon.waitForSeconds(5);
		AccountUserActions RA = new AccountUserActions();
		RA.verifySubMenuSupport();
		
		
	}
	
	@Test(dependsOnMethods = { "verifySupportSubMenu" },alwaysRun = true)
	public void switchBack() throws CustomException {
		SeleniumCommon.waitForSeconds(5);
		AccountUserActions RA = new AccountUserActions();
	//	RA.switchback();
		
		
		
		
	}
	

	
	
	
	
}
