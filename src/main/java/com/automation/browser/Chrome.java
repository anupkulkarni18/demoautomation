package com.automation.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.base.DataStoreRepository;
import com.automation.base.CustomException;

public class Chrome extends Browser {
	@Override
	public WebDriver getBrowser() throws CustomException {
		String currentDir = System.getProperty("user.dir");
		String chromeDriverPath = "F:\\chromedriver.exe";//currentDir + "\\Drivers\\windows\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromeDriverPath );

		driver = new ChromeDriver();
		return driver;
	}

}
