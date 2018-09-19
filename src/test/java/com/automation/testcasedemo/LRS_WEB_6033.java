package com.automation.testcasedemo;

import org.testng.annotations.Test;

import com.application.constants.AccountConstants;
import com.application.constants.GroupConstants;
import com.automation.base.CustomException;
import com.pageObjects.AccountPage;
import com.selenium.common.SeleniumCommon;

import applicationActions.AccountActions;
import applicationActions.GroupActions;

/**
 * 
 * This class is created to login
 * 
 * @author vrushaleep
 * Verify all the tab of groups and create groups.
 */
public class LRS_WEB_6033{
	GroupActions groupAction = new GroupActions();
	AccountActions actions = new AccountActions();

	/**
	 * 
	 */

	@Test(priority = 3)
	public void testViewAllGroupOptions() {
		SeleniumCommon.waitForSeconds(10);
		groupAction.navigateToViewAllGroupsPage();
		groupAction.verifyViewAccountGroup(GroupConstants.accountGroupName);

	}

	/**
	 * 
	 */

	@Test(priority = 4)
	public void testVerifyGroupIsCreated() {

		groupAction.verifyGroupisCreated(GroupConstants.accountGroupName,
				GroupConstants.description);

	}

	@Test(priority = 5)
	public void testEditGroup() {

		groupAction.editAccountGroup(GroupConstants.accountGroupNameEdited,
				GroupConstants.descriptionEdited);
		groupAction.verifyGroupisCreated(GroupConstants.accountGroupNameEdited,
				GroupConstants.descriptionEdited);

	}
	

}