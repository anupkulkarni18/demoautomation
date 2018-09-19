package com.automation.testcasedemo;

import org.testng.annotations.Test;

import com.selenium.common.SeleniumCommon;

import applicationActions.LogoutActions;


/**
 * 
 * This class is created to login 
 * @author vrushaleep
 *
 * Logout
 */
public class LRS_WEB_8551/* extends LRS_WEB_8549*/{
	
	
	@Test(priority=12)
	public void logOut(){
		SeleniumCommon.waitForSeconds(10);
		LogoutActions logout = new LogoutActions();
		logout.logoutFromLRSApplication();
		
	}
	
	
	

	
	
	
	

}
