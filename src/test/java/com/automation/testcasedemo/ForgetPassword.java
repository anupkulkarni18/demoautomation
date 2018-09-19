package com.automation.testcasedemo;

import static org.testng.Assert.assertEquals;

import javax.mail.Message;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

import com.automation.base.CustomException;
import com.automation.base.DataStoreRepository;
import com.automation.browser.Browser;
import com.selenium.common.MailingUtilities;
import com.selenium.common.SeleniumCommon;

import applicationActions.LoginActions;
import applicationActions.LogoutActions;

/*	logout as super admin.
 * 	click on forget password on login page.
 * 	Enter email id. Open email click on reset password link.
 * 	reset password.
 * 	verify password by login into account.
 * 
 * Author: Rohit L
 */
public class ForgetPassword {
	@Test(priority = 1)
	public void forgetPassword() throws Exception {
		LogoutActions loA = new LogoutActions();
		loA.forgetPassword();
		MailingUtilities mu = new MailingUtilities();
		Message email = mu.getEmail(DataStoreRepository.getValue("mailID1"), DataStoreRepository.getValue("pasword1"),
				"Reset your LRS Connect password");
		String emailContent = mu.getTextFromMimeMultipart(((MimeMultipart) email.getContent()));
		int index1 = emailContent.indexOf("connect.lrsus.com.");
		int index2 = emailContent.indexOf("If you did not");
		String mailURL = emailContent.substring(index1 + "connect.lrsus.com.".length(), index2).trim();
		mu.Delete();
		// logout as superadmin and login as user
		SeleniumCommon.waitForSeconds(2);
		Browser.getDriver().get(mailURL);
		Browser.refresh();
		SeleniumCommon.waitForSeconds(2);
		// Adding Password
		LoginActions linA = new LoginActions();
		linA.resetPassword(DataStoreRepository.getValue("pasword1"));
		linA.loginLRSApp(DataStoreRepository.getValue("mailID1"), DataStoreRepository.getValue("pasword1"));
		SeleniumCommon.waitForSeconds(15);
		assertEquals(Browser.getCurrentURL().contains("tableTracker"), true);
		LogoutActions la = new LogoutActions();
		la.logoutFromLRSApplication();
		SeleniumCommon.waitForSeconds(5);

	}
	@Test(dependsOnMethods={"forgetPassword"})
	public void LoginAsSuperAdmin() throws Exception {
		LoginActions loginuser = new LoginActions();
		loginuser.loginLRSApp(applicationCredentials.UserCredentails.superAdminUsername,
				applicationCredentials.UserCredentails.sueperAdminPassword);
		SeleniumCommon.waitForSeconds(10);

	}

}
