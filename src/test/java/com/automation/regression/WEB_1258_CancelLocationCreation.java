package com.automation.regression;

import org.testng.annotations.Test;

import applicationActions.LocationActions;
import applicationActions.LoginActions;
import applicationActions.MyProductActions;

import com.application.constants.AccountConstants;
import com.application.constants.LocationConstants;
import com.application.constants.MyProductConstants;
import com.automation.testcasedemo.Login;
import com.selenium.common.SeleniumCommon;

/**
 * This test case verifies user is unable to add location if clicks on cancel
 * button. Below steps performed are: 1. Login with account owner user. Make
 * sure account owner has two products enabled before running this test case.
 * 2.Verify most of the product page information like products. 3. Navigate to
 * Table Tracker product. 4. Add location and provide all location details
 * except customer id. 5. Click on cancel button.
 * 
 * @author vrushaleep
 * 
 */
public class WEB_1258_CancelLocationCreation extends Login {

	/**
	 * This step logged-in with account owner user. Make sure account owner has
	 * two products enabled before running this test case
	 */

	@Test(priority = 1)
	public void login() {
		LoginActions login = new LoginActions();
		SeleniumCommon.waitForSeconds(10);
		login.loginInWithUser(applicationCredentials.UserCredentails.username,
				applicationCredentials.UserCredentails.password,
				AccountConstants.accountHolder);
	}

	/**
	 * This step verifies product page information like products, few text.
	 */
	@Test(priority = 2)
	public void verifyMyProductPage() {

		MyProductActions myProductActions = new MyProductActions();
		myProductActions.verifyMyProductText();

	}

	/**
	 * This step navigates to Table Tracker product.
	 */
	@Test(priority = 3)
	public void navigateToTableTrackerProduct() {
		MyProductActions myProductActions = new MyProductActions();
		myProductActions.navigateToSpecifiedProduct(MyProductConstants.TableTrackerProductName);

	}

	/**
	 * This step adds location details like location name, address and phone
	 * number. It clicks on cancel button and then verifies provided location
	 * name is not present.
	 */

	@Test(priority = 4)
	public void verifyLocationCancellation() {
		SeleniumCommon.waitForSeconds(20);
		LocationActions locationActions = new LocationActions();
		locationActions.addLocation(LocationConstants.locationName, LocationConstants.address, LocationConstants.phoneNumber);
		locationActions.verifyLocationCancellation(LocationConstants.locationName);

	}
}
