package com.automation.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.automation.base.CustomException;

public class IE extends Browser {

	@Override
	public WebDriver getBrowser() throws CustomException {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\abc\\Desktop\\Server\\IEDriverServer.exe");
		return new InternetExplorerDriver();
	}

}
