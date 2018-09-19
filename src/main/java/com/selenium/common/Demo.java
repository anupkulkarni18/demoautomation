package com.selenium.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Demo {
	
	public static void main(String[] args) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		System.out.println(timeStamp);
	}

//	public static String getRamdomString() {
//		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//		int count = 5;
//	StringBuilder builder = new StringBuilder();
//	while (count-- != 0) {
//	int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
//	builder.append(ALPHA_NUMERIC_STRING.charAt(character));
//	}
//	return builder.toString();
//	}
//	
////	public static WebElement findElement(String locator) {
////		  WebElement webElement = null;
////		  By byLocator = null;
////		  String loctor_type = null, locator_value = null;
////		  
////		  try {
////		   
////		   loctor_type = locator.split("=", 2)[0];
////		   locator_value = locator.split("=", 2)[1];
////		 //  Log.info("Locator Type:- " + loctor_type + " Locator Value:-" + locator_value);
////
////		   switch (loctor_type) {
////		   case "id":
////		    byLocator = By.id(locator_value);
////		    break;
////		   case "name":
////		    byLocator = By.name(locator_value);
////		    break;
////		   case "cssSelector":
////		    byLocator = By.cssSelector(locator_value);
////		    break;
////		   case "xpath":
////		    byLocator = By.xpath(locator_value);
////
////		    // JavascriptExecutor je = (JavascriptExecutor) driver;
////		    // je.executeScript("arguments[0].scrollIntoView(true);", webElement);
////		    break;
////		   case "className":
////		    byLocator = By.className(locator_value);
////		    break;
////		   case "linkText":
////		    byLocator = By.linkText(locator_value);
////		    break;
////		   case "partialLinkText":
////		    byLocator = By.partialLinkText(locator_value);
////		    break;
////		   case "tagName":
////		    byLocator = By.tagName(locator_value);
////		    break;
////		   default:
////		    //Log.info("Locator type does not match" + byLocator);
////		   }
////
////		   //Log.info("Locator: " + byLocator);
////		  // Selenium.getPageLoadStatus();
////		   long startTime = System.currentTimeMillis() / 1000;
////
////		 //  waitForElement().until(ExpectedConditions.visibilityOfElementLocated(byLocator));
////
//////		   if (driver.findElement(byLocator).isDisplayed()) {
//////		    webElement = driver.findElement(byLocator);
//////		   // Log.info("Element found:-" + byLocator);
//////
//////		   } else {
//////		    //Log.info("Element not displayed on this web page by " + byLocator);
//////		   }
////
////		   long endTime = System.currentTimeMillis() / 1000;
////		   //Log.getLogger().info("Time:" + (endTime - startTime) + " seconds");
////
////		  } catch (Exception e) {
////		   //Log.info("Locator Type:- " + loctor_type + " Locator Value:-" + locator_value);
////		   //Log.info("No element found on web page by " + byLocator);
////		   //Log.error("Error occured ...");
////		   e.printStackTrace();
////
////		  }
////
////		  return webElement;
////		 }
////
////		 /**
////		  * This method will wait util 60 seconds
////		  * 
////		  * @return
////		  * @throws HandleException
////		  */
//////		 public static Wait<WebDriver> waitForElement() {
//////
//////		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
//////		    .pollingEvery(10, TimeUnit.SECONDS)
//////		    .ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
//////
//////		  return wait;
//////		 }
//
}
