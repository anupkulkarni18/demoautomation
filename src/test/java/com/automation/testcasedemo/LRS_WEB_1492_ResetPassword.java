package com.automation.testcasedemo;

import javax.mail.Message;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.LoginActions;
import applicationActions.LogoutActions;

import com.application.constants.AccountConstants;
import com.automation.base.CustomException;
import com.automation.base.DataStoreRepository;
import com.automation.browser.Browser;
import com.selenium.common.MailingUtilities;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;

/**
 * This class is created to reset password from superadmin account. Steps
 * involved are - 1. Login with super admin user. 2. Search by activated
 * account. 3. Click on Reset Password link. 4. User will receive an email on
 * the mail box provided while creating account. 5. Check all email content. 6.
 * Click on forgetPassword link provided on email. 7. Access that link and
 * provide new password which is supposed to be changed. 8. Login to LRSConnect
 * with the same email and changed password to confirm password is changed.
 * 
 * In order to run this test, user has to change config.properties below fields -
 * maidID1=<Configured email id>
 * pasword1=<Password>
 * 
 * @author vrushaleep
 * 
 */

public class LRS_WEB_1492_ResetPassword extends LRS_WEB_8549 {

	AccountActions actions = new AccountActions();

	/**
	 * This step clicks on Reset Password Link.
	 * 
	 * @throws CustomException
	 * @throws Exception
	 */

	@Test(priority = 2)
	public void clickOnResetPasswordLink() throws CustomException, Exception {
		SeleniumCommon.waitForSeconds(30);
		actions.searchAccountAndSelect1(AccountConstants.accountName);
		SeleniumCommon.waitForSeconds(10);
		actions.clickResetPasswordLink();

	}

	/*
	 * This step checks login to mailbox and check the email with corresponding
	 * subject. It get the email content and specially returns the forget
	 * password link to reset password.
	 */
	@Test(priority = 3)
	public String getMailURL() throws Exception {
		MailingUtilities mailingUtilities = new MailingUtilities();
		Message email = mailingUtilities.getEmail(
				DataStoreRepository.getValue("mailID1"),
				DataStoreRepository.getValue("pasword1"),
				"Reset your LRS Connect password");
		String emailContent = mailingUtilities
				.getTextFromMimeMultipart(((MimeMultipart) email.getContent()));
		int index1 = emailContent.indexOf("connect.lrsus.com.");
		int index2 = emailContent.indexOf("If you did not");
		String mailURL = emailContent.substring(
				index1 + "connect.lrsus.com.".length(), index2).trim();
		mailingUtilities.Delete();
		return mailURL;
	}

	/**
	 * This step logout the superadmin user.
	 */
	@Test(priority = 4)
	public void logOut() {
		// logout as superadmin and login as user
		SeleniumCommon.waitForSeconds(2);
		LogoutActions la = new LogoutActions();
		la.logoutFromLRSApplication();
	}

	/**
	 * This step access the forget password link returned in previous steps.
	 * 
	 * @throws Exception
	 */

	@Test(priority = 5)
	public void accessResetLink() throws Exception {
		SeleniumCommon.waitForSeconds(2);
		Browser.getDriver().get(getMailURL());
		Browser.refresh();
	}

	/**
	 * This step resets the account with new password.
	 */

	@Test(priority = 6)
	public void resetPassword() {

		actions.restPassword(AccountConstants.password);
	}

	/**
	 * This step verified whether password is changed and tried to login with
	 * the email and changed password. If user is able to login successfully
	 * then considering password is changed or reset successfully.
	 */
	@Test(priority = 7)
	public void verifyPasswordIsChanged() {
		LoginActions login = new LoginActions();
		TestngVerifications.assertBoolean(login.loginInWithUser(
				AccountConstants.email, AccountConstants.password,
				AccountConstants.accountHolder));

	}
}
