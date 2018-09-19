package com.automation.testcasedemo;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.base.CustomException;
import com.automation.browser.Browser;
import com.automation.browser.Chrome;
import com.automation.browser.Phantom;

public abstract class Login {

	Browser browser;

	@BeforeTest
	public void beforeTest() throws CustomException {
	//browser = new Chrome();
	//browser = new Phantom();
//	browser.openBrowser();
	Browser.initializeBrowser();
	}

	@Test
	public abstract void login() throws CustomException;

	/*@AfterTest
	public void afterTest() throws CustomException {
		browser.closeBrowser();
	}
*/
}
