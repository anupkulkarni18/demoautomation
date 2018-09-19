package com.automation.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import com.automation.base.CustomException;
import com.automation.base.DataStoreRepository;


public class Phantom extends Browser {
	@Override
	public WebDriver getBrowser() throws CustomException {

		String os = System.getProperty("os.name").toLowerCase();
		String currentDir = System.getProperty("user.dir");
 driver = null;
		if (os.contains("windows")) {
			String phantomJsPath = currentDir + "\\Drivers\\windows\\phantomjs.exe";
			System.setProperty("phantomjs.binary.path", phantomJsPath);
			this.driver = new PhantomJSDriver();
		
		} else if (os.contains("linux")) {
			String phantomJsPath = currentDir + "/Drivers/Linux/phantomjs";
			System.setProperty("phantomjs.binary.path", phantomJsPath);
			this.driver = new PhantomJSDriver();
			
		}
		
	return driver;

		
		
	}

}
