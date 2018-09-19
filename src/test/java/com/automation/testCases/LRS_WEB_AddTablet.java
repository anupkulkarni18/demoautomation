package com.automation.testCases;

import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.GatewayActions;
import applicationActions.GroupActions;
import applicationActions.LocationActions;
import applicationActions.LoginActions;
import applicationActions.ReportingActions;
import applicationActions.SupportActions;
import applicationActions.SupportUsersActions;
import applicationActions.TabletActions;

import org.openqa.selenium.JavascriptExecutor;

import com.automation.base.CustomException;
import com.automation.browser.Browser;
import com.pageObjects.GatewayPage;
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
public class LRS_WEB_AddTablet extends LRS_WEB_AddGateway {

	@Test(priority = 6)
	public void verifyTabletIsAdded() throws CustomException {
		SeleniumCommon.waitForSeconds(10);
		TabletActions tabletAction = new TabletActions();
		SeleniumCommon.waitForSeconds(10);
		tabletAction.addTablet();
		tabletAction.verifyTabletIsAdded();
	}

}
