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
 * This class is use to create group 
 * 
 * @author vrushaleep
 * 
 */
public class LRS_WEB_8556_WEB_6031{
	GroupActions groupAction = new GroupActions();
	AccountActions actions = new AccountActions();

	/**
	 * 
	 */

	@Test(priority = 1)
	public void testGroupMenuOptions() {
		SeleniumCommon.waitForSeconds(2);
		groupAction.verifyGroupsOptions();
	}

	/**
	 * 
	 */

	@Test(priority = 2)
	public void testAddGroupOptions() {
		SeleniumCommon.waitForSeconds(5);
		groupAction.addNewGroup(GroupConstants.accountGroupName,
				GroupConstants.description);
	}

	/**
	 * 
	 */

	@Test(priority = 3)
	public void testViewAllGroupOptions() {
		SeleniumCommon.waitForSeconds(2);
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

	/**
	 * 
	 Group is verified and selected in create account test case hence commenting this method

	@Test(priority = 5)
	public void testVerifyNewlyCreatedGroupIsAvailableInAccount() {
		SeleniumCommon.waitForSeconds(10);
		actions.verifyViewAccountMenuOptions();
		actions.searchAccountAndSelect(AccountConstants.accountName);
		SeleniumCommon.waitForSeconds(10);
		groupAction
				.verifyGroupNameIsPresentinAccount(GroupConstants.accountGroupName);
		
		SeleniumCommon.waitForSeconds(30);

	}

*/
}