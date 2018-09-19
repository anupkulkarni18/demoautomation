package com.automation.testCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import applicationActions.LoginActions;

import com.automation.base.CustomException;
import com.selenium.common.TestngVerifications;

/**
 * 
 * This class is created to login 
 * @author vrushaleep
 *
 */
public class LRS_WEB_8549 extends Login{
	
	List<String> expected = new ArrayList<String>(Arrays.asList("Add Account","View All Accounts","Add User","View All Customer Support Users","Account Owner Summary Report","SMS Usage Report","Table Tracker Order Summary","Add Group","View All Groups","Profile","Sign Out"));

	@Test(priority=1)
	public void loginAsSuperUser() throws CustomException {
		LoginActions login = new LoginActions();
		List<String> actual = login.loginInLRSApplication(
				applicationCredentials.UserCredentails.superAdminUsername,
				applicationCredentials.UserCredentails.sueperAdminPassword);
		
		
		TestngVerifications.assertExpectedEqualsActualString(expected.toString(), actual.toString());
	}
	

	
	
	
	

}
