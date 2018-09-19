package com.automation.testcasedemo;

import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.GroupActions;
import applicationActions.LoginActions;
import applicationActions.LogoutActions;
import applicationActions.ReportingActions;
import applicationActions.SupportActions;
import applicationActions.SupportUsersActions;

import javax.mail.Message;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.JavascriptExecutor;

import com.application.constants.AccountConstants;
import com.application.constants.GroupConstants;
import com.automation.base.CustomException;
import com.automation.base.DataStoreRepository;

import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;

/**
 * 
 * This class is created to login
 * 
 * @author vrushaleep
 * 
 *1. In this Test case we verify the content of add account page and Add new Account. details are present on AccountConstantes page.
 */
public class LRS_WEB_8563_WEB_9057  {
	AccountActions accountActions = new AccountActions();

	@Test
	public void verifyCancelCreateAccountOption() throws CustomException {

		SeleniumCommon.waitForSeconds(10);
		accountActions.verifyAccountPageOptions();
		accountActions.addAccount(AccountConstants.accountName,
				AccountConstants.customerId, AccountConstants.email,
				AccountConstants.country, AccountConstants.digiCloudAccount,
				AccountConstants.accountTimeZone, AccountConstants.cancel);
		SeleniumCommon.waitForSeconds(10);
		accountActions.verifyViewAccountMenuOptions();
		accountActions.searchAccountAndSelect(AccountConstants.accountName);
		TestngVerifications.assertExpectedEqualsActualString(
				accountActions.verifyAccountIsNotAvailable(),
				"No Accounts found");

	}

	@Test(dependsOnMethods={"verifyCancelCreateAccountOption"})
	public void verifySaveCreateAccountOption() throws CustomException {
		SeleniumCommon.waitForSeconds(10);
		accountActions.addAccountFromPage();
		accountActions.addAccount(AccountConstants.accountName,
				AccountConstants.customerId, DataStoreRepository.getValue("mailID1"),
				AccountConstants.country, AccountConstants.digiCloudAccount,
				AccountConstants.accountTimeZone, AccountConstants.save);
		TestngVerifications.assertExpectedEqualsActualString(
				AccountConstants.accountName, accountActions
						.verifyAccountIsCreated(AccountConstants.accountName));

	}
	
	@Test(dependsOnMethods={"verifySaveCreateAccountOption"})
	public void addGroupInAccount() throws CustomException {
		accountActions.addGroupInAccount(GroupConstants.accountGroupName);
	}	
}
