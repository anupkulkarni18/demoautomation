package com.automation.testcasedemo;

import static org.testng.Assert.assertEquals;

import javax.mail.Message;
import javax.mail.internet.MimeMultipart;
import org.testng.annotations.Test;
import com.automation.base.DataStoreRepository;
import com.automation.browser.Browser;
import com.selenium.common.MailingUtilities;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;
import applicationActions.LoginActions;
import applicationActions.LogoutActions;

/*
 * Activate the Account
 * Login into account
 * verify it and logout
 * 
 * */

public class AccountActivationAndVerification {
	@Test
	public void LogoutFromSuperAdmin() throws Exception {
		LogoutActions la1 = new LogoutActions();
		la1.logoutFromLRSApplication();
		
		
	}
	
	
	
	@Test(dependsOnMethods={"LogoutFromSuperAdmin"}, alwaysRun=true)
	public void ActivateAccount() throws Exception {
		//DataStoreRepository DataStoreRepository = DataStoreRepository.loadRepository("", "config");
		// Verify Account Owner Email Id in mail.
		MailingUtilities mu = new MailingUtilities();
		System.out.println("Repo extract mail id is "+DataStoreRepository.getValue("mailID1"));
		Message email = mu.getEmail(DataStoreRepository.getValue("mailID1"), DataStoreRepository.getValue("pasword1"),
				"Please activate your LRS Account");
		String emailContent = mu.getTextFromMimeMultipart(((MimeMultipart) email.getContent()));
		int index1 = emailContent.indexOf("link:");
		int index2 = emailContent.indexOf("Thanks,");
		String mailURL = emailContent.substring(index1 + 5, index2).trim();
		mu.Delete();
		Browser.getDriver().get(mailURL);
		Browser.refresh();
		SeleniumCommon.waitForSeconds(5);
		// Activate Account
		LoginActions lin = new LoginActions();
		lin.ActivateAccount("Robert", "Watt", DataStoreRepository.getValue("changedPassword"), DataStoreRepository.getValue("changedPassword"));

		SeleniumCommon.waitForSeconds(2);
		Message email1 = mu.getEmail(DataStoreRepository.getValue("mailID1"), DataStoreRepository.getValue("pasword1"), "Welcome to LRS Connect");
		TestngVerifications.assertExpectedEqualsActualString(email1.getSubject().trim(),"Welcome to LRS Connect");
		mu.Delete();
		

	}
	
	
	@Test(dependsOnMethods={"ActivateAccount"}, alwaysRun=true)
	public void verifyAccountByLoginIntoIt() throws Exception {

		LoginActions loginuser = new LoginActions();
		loginuser.loginLRSApp(DataStoreRepository.getValue("mailID1"), DataStoreRepository.getValue("changedPassword"));
		SeleniumCommon.waitForSeconds(15);
		assertEquals(Browser.getCurrentURL().contains("tableTracker"), true);
}
	
	
	@Test(dependsOnMethods={"verifyAccountByLoginIntoIt"}, alwaysRun=true)
	public void logoutAsuser() throws Exception {
	LogoutActions la1 = new LogoutActions();
		la1.logoutFromLRSApplication();
		SeleniumCommon.waitForSeconds(2);
	}
	
		
	
	
}
