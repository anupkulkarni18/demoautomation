package com.automation.testCases;

import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.GroupActions;
import applicationActions.LocationActions;
import applicationActions.LoginActions;
import applicationActions.ReportingActions;
import applicationActions.SupportActions;
import applicationActions.SupportUsersActions;

import org.openqa.selenium.JavascriptExecutor;

import com.automation.base.CustomException;
import com.automation.browser.Browser;
import com.pageObjects.ReportingPage;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;

/**
 * 
 * This class is created to login
 * 
 * @author vrushaleep
 * 
 */
public class LRS_WEB_AddLocation extends
		LRS_WEB_LoginIntoTheAccountAsSuperAdmin {

	@Test(priority = 4)
	public void verifyLocationIsAdded() throws CustomException {

		SeleniumCommon.waitForSeconds(10);
		LocationActions locationActions = new LocationActions();
		locationActions.addLocation("Mumbai-1", "101", "Mumbai", "123-123-1234");
		//System.out.println("============================="+locationActions.checkLocationText("Mumbai-1"));

	}

}
