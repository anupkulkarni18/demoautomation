package com.automation.testcasedemo;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.MimeMultipart;
import org.testng.annotations.Test;
import com.application.constants.AccountConstants;
import com.automation.base.DataStoreRepository;
import com.automation.browser.Browser;
import com.selenium.common.MailingUtilities;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;
import applicationActions.AccountActions;
import applicationActions.LoginActions;
import applicationActions.LogoutActions;

/**
 * 
 * This class is created to login
 * 
 * @author rohitL
 *
 *         In this test case we change Account owner and check weather it is
 *         reflected properly on home Page. Revert mail Id back.
 */

public class LRS_WEB_9227/*- extends LRS_WEB_8549 */{
	@Test(priority = 2)
	public void changeAccountOwner() throws Exception {
		
		// change account owner Email ID
		AccountActions aa = new AccountActions();
		SeleniumCommon.waitForSeconds(10);
		aa.verifyViewAccountMenuOptions();
		aa.searchAccountAndSelect(AccountConstants.accountName);
		SeleniumCommon.waitForSeconds(10);
		aa.clickOnChangeAccountOwner();
		SeleniumCommon.waitForSeconds(2);
		
		
		String OlderEmailID = aa.getAccountOwnerEmailID().substring(aa.getAccountOwnerEmailID().indexOf("lrs"), aa.getAccountOwnerEmailID().indexOf("com")+3).trim();
		aa.enterNewEmailAddress(DataStoreRepository.getValue("mailID2"));
		aa.clickOnUpdatedAccountButtonAtChangeAccountOwner();
		aa.clickOnOkButtonAtChangeAccountOwner();
		SeleniumCommon.waitForSeconds(2);
		TestngVerifications.assertExpectedEqualsActualString(DataStoreRepository.getValue("mailID2"),
				aa.getAccountOwnerEmailID().replace("test user", "").trim());

		// Verify Account Owner Email Id in mail.
		MailingUtilities mu = new MailingUtilities();

		Message email = mu.getEmail(DataStoreRepository.getValue("mailID2"), DataStoreRepository.getValue("pasword2"), "Please activate your LRS Account");
		String emailContent = mu.getTextFromMimeMultipart(((MimeMultipart) email.getContent()));
		int index1 = emailContent.indexOf("link:");
		int index2 = emailContent.indexOf("Thanks,");
		String mailURL = emailContent.substring(index1 + 5, index2).trim();
		mu.Delete();
		
		//logout as superadmin and login as user
		SeleniumCommon.waitForSeconds(2);
		LogoutActions la = new LogoutActions();
		la.logoutFromLRSApplication();
		SeleniumCommon.waitForSeconds(2);
		Browser.getDriver().get(mailURL);
		Browser.refresh();
		
		SeleniumCommon.waitForSeconds(5);
		
		//Resetting Password
		LoginActions lin = new LoginActions();		
		lin.ActivateAccount("Robert", "Watt", DataStoreRepository.getValue("pasword2"), DataStoreRepository.getValue("pasword2"));
		
		SeleniumCommon.waitForSeconds(2);
		
		//Checking Welcome Mail
		Message email1 = mu.getEmail(DataStoreRepository.getValue("mailID2"), DataStoreRepository.getValue("pasword2"), "Welcome to LRS Connect");
		TestngVerifications.assertExpectedEqualsActualString(email1.getSubject().trim(),"Welcome to LRS Connect");
		mu.Delete();
		
		// login as user 
		LoginActions loginuser = new LoginActions();
		loginuser.loginLRSApp(DataStoreRepository.getValue("mailID2"), DataStoreRepository.getValue("pasword2"));
		SeleniumCommon.waitForSeconds(10);
		SeleniumCommon.waitForSeconds(2);
		LogoutActions la1 = new LogoutActions();
		la1.logoutFromLRSApplication();
		SeleniumCommon.waitForSeconds(2);
		//Login As super Admin		
		loginuser.loginLRSApp(applicationCredentials.UserCredentails.superAdminUsername, applicationCredentials.UserCredentails.sueperAdminPassword);
		SeleniumCommon.waitForSeconds(10);
		aa.verifyViewAccountMenuOptions();
		aa.searchAccountAndSelect(AccountConstants.accountName);	
		SeleniumCommon.waitForSeconds(5);
		aa.clickOnChangeAccountOwner();
		SeleniumCommon.waitForSeconds(2);
		aa.enterNewEmailAddress(OlderEmailID);
		aa.clickOnUpdatedAccountButtonAtChangeAccountOwner();
		SeleniumCommon.waitForSeconds(2);
		aa.clickOnOkButtonAtChangeAccountOwner();
		TestngVerifications.assertExpectedEqualsActualString(OlderEmailID,
				aa.getAccountOwnerEmailID().substring(aa.getAccountOwnerEmailID().indexOf("lrs"), aa.getAccountOwnerEmailID().indexOf("com")+3).trim());
		
	}
}
