package com.automation.panorama;

import org.testng.annotations.Test;

import com.automation.base.CustomException;
import com.automation.browser.Browser;

public class LoginPanorama {
		@Test
		public void beforeTest() throws CustomException {
	Browser.initializeBrowser();
		}

}
