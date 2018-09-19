package com.selenium.reporting;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.base.CustomException;
import com.automation.base.DataStoreRepository;
import com.selenium.common.SeleniumCommon;

public class ExtendReportScreenShot {
	WebDriver driver =null;
	
	public final static Logger LOGGER = Logger.getLogger(ExtendReportScreenShot.class
			.getName());

	public ExtendReportScreenShot() throws CustomException, InterruptedException, IOException {
		// TODO Auto-generated constructor stub
		LOGGER.info("Started extend reportscreen shot constructor");
		
		String extendReportURL = "file:///"+System.getProperty("user.dir") +"//test-output//ExtentReportsTestNG.html";
		
	
		//IDataStoreInMap dataStore = data.CreateDataStoreForFile();

		System.setProperty("webdriver.chrome.driver", DataStoreRepository.getValue("windows_chromeDriverPath"));

		driver = new ChromeDriver();
		driver.get(extendReportURL);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='enableDashboard']/i")).click();
		Thread.sleep(500);
		SeleniumCommon sc = new SeleniumCommon();
		String path =System.getProperty("user.dir")+"\\ScreenShots\\ExtendReportScreenShots\\ExtendReportScreenShots.png";
		
		sc.getFullPageScreenShot(driver, path);
		driver.close();
		
		LOGGER.info("Screen shot of exten reportis properly taken and stored in ScreenShots>ExtendReportScreenShots folder.");
		
		
	}
}

