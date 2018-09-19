package com.automation.testcasedemo;

import org.testng.annotations.Test;

import com.application.constants.AccountConstants;
import com.application.constants.SettingsConstants;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;

import applicationActions.AccountActions;
import applicationActions.SettingsAction;
/*
 * 
 * Login as admin and verify setting Page tabs and content
 * 
 * */
public class LRS_WEB_6552 extends LRS_WEB_8549 {

	SettingsAction settingsAction = new SettingsAction();

	@Test(priority = 12)
	public void testLoginAsAdmin() {
		AccountActions accountActions = new AccountActions();

		SeleniumCommon.waitForSeconds(20);
		accountActions.searchAccountAndSelect1(AccountConstants.accountName);
		SeleniumCommon.waitForSeconds(5);
		accountActions.loginIntoAccountAsSuperAdmin();

		TestngVerifications.assertExpectedEqualsActualString(
				AccountConstants.accountName, accountActions.getAccountName());
		SeleniumCommon.waitForSeconds(10);
	}

	@Test(priority = 13)
	public void testSettingPage() {

		settingsAction
				.checkSettingPage(SettingsConstants.targetDeliveryTimeBefore);

	}

	@Test(priority = 14)
	public void testChangeTargetDeliveryTime() {

		settingsAction
				.changeTargetDeliveryTime(SettingsConstants.targetDeliveryTimeAfter);

	}

	@Test(priority = 15)
	public void testCancelTargetDeliveryTime() {

		settingsAction.cancelTargetDeliveryTimeChange();
		settingsAction
				.checkSettingPage(SettingsConstants.targetDeliveryTimeBefore);

	}

	@Test(priority = 15)
	public void testSaveTargetDeliveryTime() {

		settingsAction
				.changeTargetDeliveryTime(SettingsConstants.targetDeliveryTimeAfter);
		settingsAction.saveTargetDeliveryTimeChange();
		settingsAction
				.checkSettingPage(SettingsConstants.targetDeliveryTimeAfter);

	}

	@Test(priority = 15)
	public void testSetTargetDeliveryTimeToOriginal() {

		settingsAction
				.changeTargetDeliveryTime(SettingsConstants.targetDeliveryTimeBefore);
		settingsAction.saveTargetDeliveryTimeChange();
		settingsAction
				.checkSettingPage(SettingsConstants.targetDeliveryTimeBefore);

	}

}
