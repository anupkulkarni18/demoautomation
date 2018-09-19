package com.automation.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.base.CustomException;

public class Firefox extends Browser {

	@Override
	public WebDriver getBrowser() throws CustomException {
		
		return new FirefoxDriver();
		
	}

}
