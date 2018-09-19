package com.selenium.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.Element;

import com.automation.browser.Browser;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class SeleniumCommon {
	/**
	 * Wait for element 120 seconds
	 * 
	 * @return
	 */
	public static WebDriverWait waitForElement() {
		return new WebDriverWait(Browser.getDriver(), 300);
	}

	public static FluentWait<WebDriver> waitForElementFluent() {
		return new FluentWait<WebDriver>(Browser.getDriver()).withTimeout(180,
				TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS);

	}

	public static void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getscreenshot() {
		File scrFile = ((TakesScreenshot) Browser.getDriver())
				.getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with name
		// "screen.png"
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
				.format(new Date());
		try {
			FileUtils.copyFile(scrFile, new File(
					"/home/synerzip/workspace/LRS/src/main/resources/FailedScreenShots/screen"
							+ timeStamp + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void pageLoadStatus() {

		JavascriptExecutor js = (JavascriptExecutor) Browser.getDriver();
		String pageLoadStatus = (String) js
				.executeScript("return document.readyState");
		System.out.println("Page Load Status:" + pageLoadStatus);

	}

	/**
	 * Create the ramdom string
	 * 
	 * @return String
	 */
	public static String getRamdomString() {
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING
					.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	public static Element getElementInstance() {

		return Element.getInstance();
	}
	
	/**
	 * Take the screen shot of full page and store in the given locaton
	 * 
	 * @return String
	 * @throws IOException 
	 */
	
	
	public static void getFullPageScreenShot(WebDriver driver, String path ) throws IOException {
	Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
			.takeScreenshot(driver);
	// To save the screenshot in desired location 
	ImageIO.write(screenshot.getImage(), "PNG",
			new File(path));
	
	
	
	}
	
	
	
	/**
	 * Take the screen shot of particular web Element and store in the given locaton
	 * 
	 * @return String
	 * @throws IOException 
	 */
	
	
	public static void getScreenShotOfWebElement(WebDriver driver, WebElement element, String path ) throws IOException {

	Screenshot screenshot1 = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element);
	   //    Screenshot screenshot = new AShot().takeScreenshot(driver,webElement);
	       ImageIO.write(screenshot1.getImage(),"PNG",new File(path));

	
	}
	
	public static String getMonth(int Additionfactor)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, Additionfactor);
		Date date = cal.getTime();
		SimpleDateFormat formatter1 = new SimpleDateFormat("MMMM");
		String MonthName =formatter1.format(date);
		return MonthName;
	}
	
	
	
	public static void copyStringAndPaste(String value) throws AWTException{
	//put path to your image in a clipboard
    StringSelection ss = new StringSelection(value);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    SeleniumCommon.waitForSeconds(5);
    //imitate mouse events like ENTER, CTRL+C, CTRL+V
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    SeleniumCommon.waitForSeconds(5);
}
	
	
	

}