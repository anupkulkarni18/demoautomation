package com.automation.testcasedemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import applicationActions.LoginActions;

import com.automation.base.CustomException;
import com.automation.base.DataStoreRepository;
import com.selenium.common.SeleniumCommon;
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
	public void login() throws CustomException {
		LoginActions login = new LoginActions();
		SeleniumCommon.waitForSeconds(10);
		/*List<String> actual = */login.loginInLRSApplication(
				DataStoreRepository.getValue("superAdminUsername"),
				DataStoreRepository.getValue("sueperAdminPassword"));
		
	//	TestngVerifications.assertExpectedEqualsActualString(expected.toString(), actual.toString());
	}
	

	
	
	
	

}
