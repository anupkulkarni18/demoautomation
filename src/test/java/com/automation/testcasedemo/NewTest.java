package com.automation.testcasedemo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.selenium.reporting.ExtentReporterNG;

public class NewTest extends ExtentReporterNG {
  @Test
  public void f() {
  }
  
  @Test
  public void f1() {
	  assertEquals(true, false);
  }
}
