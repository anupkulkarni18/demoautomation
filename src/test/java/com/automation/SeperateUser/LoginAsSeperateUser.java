package com.automation.SeperateUser;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.CustomException;
import com.automation.browser.Browser;
import com.automation.browser.Chrome;
import com.pageObjects.LoginPage;
import com.selenium.reporting.ExtendReportScreenShot;

public class LoginAsSeperateUser {
	Browser browser;
	@BeforeClass
	public void beforeTest() throws CustomException {
		browser = new Chrome();
		browser.openBrowser();
		LoginPage lp = new LoginPage();
		lp.loginUsername.setText(applicationCredentials.UserCredentails.username);
		lp.loginPassword.setText(applicationCredentials.UserCredentails.password);
		lp.loginButton.click();
	}
	
	@AfterClass
	public void afterTest() throws CustomException {
	
		browser.closeBrowser();
		
	}
	
	@AfterSuite
	public void aftersuite() throws CustomException, InterruptedException, IOException {
	
		ExtendReportScreenShot ERSS =new ExtendReportScreenShot();
		
	}
	
  }
