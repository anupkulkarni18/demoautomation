package com.selenium.common;

import org.testng.Assert;

public class TestngVerifications {
	/**
	 * Verify the two strings
	 * 
	 * @param expectedText
	 * @param actualText
	 */
	public static void assertExpectedEqualsActualString(String expectedText, String actualText) {

		Assert.assertEquals(expectedText, actualText);

	}
	
	public static void assertBoolean(boolean condition) {

		Assert.assertTrue(condition);

	}
	/**
	 * 
	 * @param expectedText
	 * @param actualText
	 */
	public static void assertExpectedEqualsActualBoolean(Boolean expectedText, Boolean actualText) {

		Assert.assertEquals(expectedText, actualText);

	}

}
