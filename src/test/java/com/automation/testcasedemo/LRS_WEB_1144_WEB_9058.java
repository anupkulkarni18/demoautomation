package com.automation.testcasedemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import applicationActions.AccountActions;
import applicationActions.AccountUserActions;
import applicationActions.GatewayActions;
import applicationActions.LocationActions;
import applicationActions.TabletActions;
import com.application.constants.AccountConstants;
import com.application.constants.GeneralConstant;
import com.application.constants.LocationConstants;
import com.automation.base.CustomException;
import com.automation.browser.Browser;
import com.pageObjects.AccountPage;
import com.pageObjects.LocationPage;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;

/**
 * 
 * This class is created to login
 * 
 * @author vrushaleep
 * 
 *         In this Test Case we Add and verify Location, gateway and tablet.
 *         
 *         Steps
 *         1. Login to user through super admin
 *         2. Create a location
 *         3. create a gatway
 *         4. Add tablet
 *         5. upload layout
 *         6. add notes
 *         7. delete location 
 *         8. switch back to superadmin.
 * 
 */
public class LRS_WEB_1144_WEB_9058 {
	TabletActions tabletAction = new TabletActions();
	LocationActions locationActions = new LocationActions();
	GatewayActions gatewayActions = new GatewayActions();

	@Test(priority = 7)
	public void verifyLoginIntoTheAccountAsSuperAdmin() throws CustomException {
		/*
		 * 
		 * AccountActions accountActions = new AccountActions(); AccountPage ap
		 * = new AccountPage(); Browser.refresh();
		 * SeleniumCommon.waitForSeconds(5);
		 * accountActions.verifyViewAccountMenuOptions();
		 * SeleniumCommon.waitForSeconds(2);
		 * accountActions.searchAccountAndSelect(AccountConstants.accountName);
		 * SeleniumCommon.waitForSeconds(5);
		 * accountActions.loginIntoAccountAsSuperAdmin();
		 * 
		 * TestngVerifications.assertExpectedEqualsActualString(
		 * AccountConstants.accountName, accountActions.getAccountName());
		 * 
		 */

	}

	@Test(dependsOnMethods = "verifyLoginIntoTheAccountAsSuperAdmin")
	public void verifyLocationIsAdded() throws CustomException {
		SeleniumCommon.waitForSeconds(5);
		AccountUserActions RA = new AccountUserActions();
		RA.verifySubMenuLocations();
		LocationPage lp = new LocationPage();
		lp.viewAllLocations.click();
		SeleniumCommon.waitForSeconds(5);

		locationActions.addLocation(LocationConstants.locationName, LocationConstants.custId, LocationConstants.address,
				LocationConstants.phoneNumber);
		SeleniumCommon.waitForSeconds(10);
		locationActions.verifyViewAllLocations(LocationConstants.locationName);

	}

	@Test(dependsOnMethods = "verifyLocationIsAdded")
	public void verifyGatewayIsAdded() throws CustomException {
		SeleniumCommon.waitForSeconds(10);

		gatewayActions.addGateway();
		gatewayActions.verifyGatewayIsAdded();

	}

	@Test(dependsOnMethods = "verifyGatewayIsAdded")
	public void verifyTabletIsAdded() throws CustomException {
		SeleniumCommon.waitForSeconds(10);
		tabletAction.addTablet();
		tabletAction.verifyTabletIsAdded();
	}
/*
	@Test(dependsOnMethods = "verifyTabletIsAdded")
	public void uploadLayout() throws CustomException, AWTException {
		LocationPage lp = new LocationPage();
		SeleniumCommon.waitForSeconds(5);
		lp.layoutTab.isDisplayed();
		lp.layoutTab.click();
		SeleniumCommon.waitForSeconds(10);
		// upload 1st image
		lp.uploadImage.click();
		SeleniumCommon.copyStringAndPaste(GeneralConstant.uploadPathofIMG1);
		SeleniumCommon.waitForSeconds(5);

		// upload 2st image
		LocationPage lp1 = new LocationPage();

		lp1.uploadImage.click();
		SeleniumCommon.copyStringAndPaste(GeneralConstant.uploadPathofIMG2);
		SeleniumCommon.waitForSeconds(5);

		// verify uplaoded image
	if ((lp.uploadedimages.getElements().size()) != (4)) {
			CustomException ce = new CustomException("layouts are not properly uploaded");
		}
	}
*/
	@Test(dependsOnMethods = "verifyTabletIsAdded")
	public void verifyNotes() throws CustomException {
		// verify notes are added properly or not
		LocationActions lap = new LocationActions();

		lap.addNotesAndVerify();
	}

	@Test(dependsOnMethods = "verifyNotes")
	public void verifyLocationIsDeleted() throws CustomException {
		tabletAction.deleteLocation();
	}

	@Test(dependsOnMethods = "verifyLocationIsDeleted", alwaysRun = true)
	public void switchBack() throws CustomException {
		SeleniumCommon.waitForSeconds(5);
		AccountUserActions RA = new AccountUserActions();
		RA.switchback();
	}
}
