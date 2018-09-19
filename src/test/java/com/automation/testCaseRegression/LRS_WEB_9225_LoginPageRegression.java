package com.automation.testCaseRegression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.base.CustomException;
import com.automation.browser.Browser;
import com.automation.browser.Chrome;
import com.pageObjects.LoginPage;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;

import applicationActions.LoginActions;


/**
 * 
 * This class is created to login 
 * @author rohitL
 *
 * In this Test case we verify regression testing on Login Functionality.
 * */
public class LRS_WEB_9225_LoginPageRegression {
	Browser browser;
	WebDriver driver;

	@BeforeTest
	public void beforeTest() throws CustomException, InterruptedException {
		browser = new Chrome();
		browser.openBrowser();
		Thread.sleep(5000);
	}

	@AfterTest
	public void aftertest() throws CustomException, InterruptedException {
		browser.quiteBrowser();
	}

	@Test(priority = 1)
	public void loginWitBblankEmailID() throws InterruptedException {
LoginPage lp = new LoginPage();
		lp.loginPassword.setText(applicationCredentials.UserCredentails.sueperAdminPassword);
		lp.loginButton.click();
		SeleniumCommon.waitForSeconds(2);
		TestngVerifications.assertExpectedEqualsActualString("Email is required",
				lp.loginUsernameError.getAttributeValue());
		lp.loginUsernameError.mouseHoverClick();
	}

	@Test(priority = 2)
	public void loginWithBlankPassword() throws InterruptedException {
		LoginPage lp = new LoginPage();
		lp.loginUsername.clearText();
		lp.loginUsername.setText(applicationCredentials.UserCredentails.superAdminUsername);
		lp.loginPassword.clearText();
		lp.loginButton.click();
		SeleniumCommon.waitForSeconds(2);
		TestngVerifications.assertExpectedEqualsActualString("Password is required",
				lp.loginPasswordError.getAttributeValue());
		lp.loginPasswordError.mouseHoverClick();

	}

	@Test(priority = 3)
	public void loginWithInvalidID() throws InterruptedException {
		LoginPage lp = new LoginPage();
		Thread.sleep(2000);
		lp.loginUsername.click();
		lp.loginUsername.clearText();
		lp.loginUsername.setText("UserName");
		lp.loginButton.click();
		SeleniumCommon.waitForSeconds(2);
		TestngVerifications.assertExpectedEqualsActualString("Email is invalid",
				lp.loginUsernameError.getAttributeValue());
		lp.loginUsernameError.mouseHoverClick();

	}

	@Test(priority = 4)
	public void userIDandPaswardBothBlank() throws InterruptedException {
		Thread.sleep(2000);
		LoginPage lp = new LoginPage();
		lp.loginUsername.click();
		lp.loginUsername.clearText();
		lp.loginPassword.click();
		lp.loginPassword.clearText();
		lp.loginButton.click();
		SeleniumCommon.waitForSeconds(2);
		TestngVerifications.assertExpectedEqualsActualString("Email is required",
				lp.loginUsernameError.getAttributeValue());
		TestngVerifications.assertExpectedEqualsActualString("Password is required",
				lp.loginPasswordError.getAttributeValue());
		lp.loginUsernameError.mouseHoverClick();
		lp.loginPasswordError.mouseHoverClick();
	}
	
	@Test(priority = 5)
	public void userIDandPaswardBothIncorrect() throws InterruptedException {
		Thread.sleep(2000);
		LoginPage lp = new LoginPage();
		lp.loginUsername.click();
		lp.loginUsername.clearText();
		lp.loginUsername.setText("Robin123@gmail.com");
		lp.loginPassword.click();
		lp.loginPassword.clearText();
		lp.loginPassword.setText("pasword123");
		lp.loginButton.click();
		SeleniumCommon.waitForSeconds(2);		
		TestngVerifications.assertExpectedEqualsActualString("Login failed. Please try again or contact support.",
				Browser.getDriver().findElement(By.xpath("//div[@id='errorDiv']")).getText());
		lp.loginUsername.clearText();
		lp.loginPassword.clearText();
	}

	@Test(priority = 6)
	public void validCredential() throws InterruptedException {
		List<String> expected = new ArrayList<String>(Arrays.asList("Add Account","View All Accounts","Add User","View All Customer Support Users","Account Owner Summary Report","SMS Usage Report","Table Tracker Order Summary","Add Group","View All Groups","Profile","Sign Out"));
		LoginActions login = new LoginActions();
		List<String> actual = login.loginInLRSApplication(
				applicationCredentials.UserCredentails.superAdminUsername,
				applicationCredentials.UserCredentails.sueperAdminPassword);
		
		
		TestngVerifications.assertExpectedEqualsActualString(expected.toString(), actual.toString());
	}
	
	
	
	
	
}
