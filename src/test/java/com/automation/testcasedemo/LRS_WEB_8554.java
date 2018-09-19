package com.automation.testcasedemo;

import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.GroupActions;
import applicationActions.LoginActions;
import applicationActions.LogoutActions;
import applicationActions.ReportingActions;
import applicationActions.SupportActions;
import applicationActions.SupportUsersActions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.application.constants.AccountConstants;
import com.application.constants.GroupConstants;
import com.application.constants.SupportUserConstants;
import com.automation.base.CustomException;
import com.automation.browser.Browser;
import com.pageObjects.AccountPage;
import com.pageObjects.ReportingPage;
import com.pageObjects.SupportUsersPage;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;

/**
 * 
 * This class is created to login
 * 
 * @author vrushaleep
 * 
 * Verify that user is able to navigate to 'Support User' sub menus
 * 
 */
public class LRS_WEB_8554/* extends LRS_WEB_8549 */{

//	@Test(priority = 1)
//	public void verifyMenuTab() throws CustomException {
//		SeleniumCommon.waitForSeconds(5);
//		supportUserAction.navigateToSupportUsersMenu();
//
//	}


	
	
	@Test(priority = 2)
	public void verifyCreateUserAsCustomerSupportWithgroup() throws CustomException {
		SupportUsersActions supportUserAction = new SupportUsersActions();
		SupportUsersPage sup= new SupportUsersPage();
		supportUserAction.createUser(SupportUserConstants.firstName+"0",
				SupportUserConstants.lastName+"0", "A0"+SupportUserConstants.email,
				SupportUserConstants.password+"0", SupportUserConstants.roleCustomerSupport, GroupConstants.accountGroupName);
		TestngVerifications.assertExpectedEqualsActualString(AccountConstants.email,
				sup.AccountemailId.getText().trim());
		AccountActions aa = new AccountActions();
		aa.verifyViewAccountsOptions();
		aa.verifyViewAccountMenuOptions();
		
		
		LogoutActions la1 = new LogoutActions();
		la1.logoutFromLRSApplication();
		SeleniumCommon.waitForSeconds(2);
		LoginActions loginuser = new LoginActions();
		loginuser.loginLRSApp(applicationCredentials.UserCredentails.superAdminUsername, applicationCredentials.UserCredentails.sueperAdminPassword);
		SeleniumCommon.waitForSeconds(10);
		
		
	}
	
	
	
	@Test(dependsOnMethods={"verifyCreateUserAsCustomerSupportWithgroup"})
	public void verifyCreateUserAsCustomerSupportWithGlobal() throws CustomException {
		SupportUsersPage sup= new SupportUsersPage();
		SupportUsersActions supportUserAction1 = new SupportUsersActions();
		supportUserAction1.createUser(SupportUserConstants.firstName+"1",
				SupportUserConstants.lastName+"1", "A1"+SupportUserConstants.email,
				SupportUserConstants.password+"1", SupportUserConstants.roleCustomerSupport, SupportUserConstants.globalAccess);
		sup.AccountemailId.getElements().size();
		AccountActions aa = new AccountActions();
		aa.verifyViewAccountsOptions();
		aa.verifyViewAccountMenuOptions();
		LogoutActions la1 = new LogoutActions();
		la1.logoutFromLRSApplication();
		SeleniumCommon.waitForSeconds(2);
		LoginActions loginuser = new LoginActions();
		loginuser.loginLRSApp(applicationCredentials.UserCredentails.superAdminUsername, applicationCredentials.UserCredentails.sueperAdminPassword);
		SeleniumCommon.waitForSeconds(10);
		
		
	}
	
	@Test(dependsOnMethods={"verifyCreateUserAsCustomerSupportWithGlobal"})
	public void verifyCreateUserAsSalesSupportWithGlobal() throws CustomException {
		SupportUsersActions supportUserAction2 = new SupportUsersActions();
		SupportUsersPage sup= new SupportUsersPage();
		supportUserAction2.createUser(SupportUserConstants.firstName+"2",
				SupportUserConstants.lastName+"2", "A2"+SupportUserConstants.email,
				SupportUserConstants.password+"2", SupportUserConstants.roleSalesSupport, GroupConstants.accountGroupName);
		TestngVerifications.assertExpectedEqualsActualString(AccountConstants.email,
				sup.AccountemailId.getText().trim());
		AccountActions aa = new AccountActions();
		aa.verifyViewAccountsOptions();
		AccountPage ap = new AccountPage();
		ap.accountTab.click();
		LogoutActions la1 = new LogoutActions();
		la1.logoutFromLRSApplication();
		SeleniumCommon.waitForSeconds(2);
		LoginActions loginuser = new LoginActions();
		loginuser.loginLRSApp(applicationCredentials.UserCredentails.superAdminUsername, applicationCredentials.UserCredentails.sueperAdminPassword);
		SeleniumCommon.waitForSeconds(10);
		
		
	}
	
	@Test(dependsOnMethods={"verifyCreateUserAsSalesSupportWithGlobal"})
	public void verifyViewAllUser() throws CustomException {
		SeleniumCommon.waitForSeconds(5);
		SupportUsersActions supportUserAction = new SupportUsersActions();
		supportUserAction.searchAndSelectUser("A0"+SupportUserConstants.email);
		SeleniumCommon.waitForSeconds(5);
		supportUserAction.verifySearchedUserDeleteUser(SupportUserConstants.firstName+"0"
				+ " " + SupportUserConstants.lastName+"0",
				"A0"+SupportUserConstants.email, SupportUserConstants.roleCustomerSupport,
				SupportUserConstants.deleteButtonText,
				SupportUserConstants.changePassword);
		
		
		supportUserAction.searchAndSelectUser("A1"+SupportUserConstants.email);
		SeleniumCommon.waitForSeconds(5);
		supportUserAction.verifySearchedUserDeleteUser(SupportUserConstants.firstName+"1"
				+ " " + SupportUserConstants.lastName+"1",
				"A1"+SupportUserConstants.email, SupportUserConstants.roleCustomerSupport,
				SupportUserConstants.deleteButtonText,
				SupportUserConstants.changePassword);
		
		supportUserAction.searchAndSelectUser("A2"+SupportUserConstants.email);
		SeleniumCommon.waitForSeconds(5);
		supportUserAction.verifySearchedUserDeleteUser(SupportUserConstants.firstName+"2"
				+ " " + SupportUserConstants.lastName+"2",
				"A2"+SupportUserConstants.email, SupportUserConstants.roleSalesSupport,
				SupportUserConstants.deleteButtonText,
				SupportUserConstants.changePassword);
		
		

	}

}
