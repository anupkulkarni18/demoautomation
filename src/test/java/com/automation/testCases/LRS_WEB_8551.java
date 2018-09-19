package com.automation.testCases;

import org.testng.annotations.Test;

import applicationActions.LogoutActions;


/**
 * 
 * This class is created to login 
 * @author vrushaleep
 *
 */
public class LRS_WEB_8551 extends LRS_WEB_8549{
	
	
	@Test
	public void logOut(){
		
		LogoutActions logout = new LogoutActions();
		logout.logoutFromLRSApplication();
		
	}
	
	
	

	
	
	
	

}
