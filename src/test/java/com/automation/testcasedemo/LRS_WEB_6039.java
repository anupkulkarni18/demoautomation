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
 * 
 * 
 * @author vrushaleep
 * Delete group and verify delete group is present or not.
 */
public class LRS_WEB_6039/* extends LRS_WEB_8549 */{
	GroupActions groupAction = new GroupActions();
	AccountActions actions = new AccountActions();

	@Test(priority = 6)
	public void testDeleteNewlyCreatedGroup() {
		SeleniumCommon.waitForSeconds(30);
		groupAction.navigateToViewAllGroupsPage();
		groupAction
				.verifyViewAccountGroup(GroupConstants.accountGroupNameEdited);
		groupAction
				.deleteGroupFromAccount(GroupConstants.accountGroupNameEdited);

	}

	@Test(priority = 7)
	public void testVerifyNewlyDeletedGroupIsNotAvailableInAccount()
			throws CustomException {
		SeleniumCommon.waitForSeconds(20);
		groupAction.navigateToViewAllGroupsPage();
		groupAction
				.verifyViewAccountGroup(GroupConstants.accountGroupNameEdited);
		groupAction.verifyGroupNameisNotPresentText();

	}

}
