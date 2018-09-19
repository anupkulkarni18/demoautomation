package com.automation.panorama;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.base.CustomException;
import com.automation.browser.Browser;

import applicationActions.SignInAction;

public class LoginPanorama {
		@BeforeMethod
		public void beforeTest() throws CustomException, InterruptedException {
	Browser.initializeBrowser();
		}
		
		
		@AfterMethod
		public void Logout() throws CustomException, InterruptedException {
	//		Browser.getDriver().close();
		}
		
		

}
