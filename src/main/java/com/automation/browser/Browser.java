package com.automation.browser;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import com.automation.base.CustomException;
import com.automation.base.DataStoreRepository;

import selenium.Element;
import selenium.LocatorType;

public abstract class Browser {
	private static String browserType = null;
	private static String enviromentType = null;

	protected static WebDriver driver;
	static ArrayList<String> tabs2;
	private final static Logger LOGGER = Logger.getLogger(Browser.class.getName());

	public final void openBrowser() throws CustomException {

		String webURL = DataStoreRepository.getValue("testsiteBaseURl");
		getBrowser().get(webURL);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		LOGGER.info("Implicit wait applied on the driver for 60 seconds");
		getDriver().manage().window().maximize();
		LOGGER.info("Maximixe the window");
		LOGGER.info("Web application launched: " + webURL);

	}

	public WebDriver getBrowser() throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	public void closeBrowser() throws CustomException {
		if (driver != null) {
			Browser.driver.close();
			LOGGER.info("Close the browser open by selenium webdriver");
		} else
			throw new CustomException("Failed while closing the browser");

	}

	public void quiteBrowser() throws CustomException {
		if (driver != null) {
			Browser.driver.quit();
			LOGGER.info("Quite all the browsers open by selenium webdriver");
		} else {
			throw new CustomException("Failed while quiting the browser");
		}

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String getCurrentURL() {

		String URL = driver.getCurrentUrl();
		return URL;
	}

	public static String getPageTitle() {
		String Title = driver.getTitle();
		return Title;
	}

	public static void swithToAdjustentTab() {

		tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
	}

	public static void SwitchBackToOriginalTab() {
		driver.close();
		driver.switchTo().window(tabs2.get(0));

	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void openNewTab(LocatorType type, String value) {
		Element e = new Element();
		// String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL+"T");
		e.findElement(type, value).sendKeys(Keys.CONTROL, "t");
	}

	// public static void setDriver(WebDriver driver) {
	// Browsers.driver = driver;
	// }

	public static void initializeBrowser() throws CustomException {
		if(System.getProperty("env")!=null || System.getProperty("browser")!=null )
		{
			enviromentType = System.getProperty("env");
			browserType = System.getProperty("browser");
		}
		else{
			enviromentType = "dev";
			browserType = "chrome";
		}
		
		/*enviromentType = System.getProperty("env");
		browserType =  System.getProperty("browser");
		*/
		if (enviromentType.equals("dev")) {
			DataStoreRepository dataStoreRepository1 = DataStoreRepository.loadRepository("", "devConfig");
		} else if (enviromentType.equals("test")) {
			DataStoreRepository dataStoreRepository1 = DataStoreRepository.loadRepository("", "testConfig");

		} else if (enviromentType.equals("prod")) {
			DataStoreRepository dataStoreRepository1 = DataStoreRepository.loadRepository("", "ProdConfig");

		} else {
			throw new CustomException("Enviroment Type in not valid. Please Enter dev, test or prod.");
			
		}

		Browser.setBrowser();
	}

	private static void setBrowser() throws CustomException {
		Browser browser = null;
		if (browserType.equals("phantomjs")) {
			browser = new Phantom();
		} else if (browserType.equals("chrome")) {
			browser = new Chrome();	
		} else {
		throw new CustomException("Browser Type in not valid. Please Enter dev, test or prod.");
		
	}
		
		browser.openBrowser();
	}

}
