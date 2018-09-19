
package selenium;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.CustomException;
import com.automation.browser.Browser;
import com.selenium.common.SeleniumCommon;
import com.selenium.common.TestngVerifications;

/**
 * This class contains all the element actions
 * 
 * @author bharatpuri
 * 
 */
public class Element {

	private static Element elementObj = new Element();

	private final static Logger LOGGER = Logger.getLogger(Element.class
			.getName());

	private WebElement element = null;
	private LocatorType locatorType;
	private String locatorValue;
	private List<WebElement> elements = null;

	public Element() {

	}

	public Element(LocatorType type, String value) {
		locatorType = type;
		locatorValue = value;

	}

	public WebElement getDynamicXPath(LocatorType type, String value) {

		return this.findElement(type, value);
	}

	/**
	 * Load the element in element variable
	 */
	private WebElement loadElement() {
		if (element == null) {
			element = elementObj.findElement(locatorType, locatorValue);
		}
		return element;
	}

	public static Element getInstance() {
		return elementObj;
	}

	/**
	 * Load the element in element variable
	 */
	public List<WebElement> getElements() {
		return this.findElements(locatorType, locatorValue);

	}

	/**
	 * Check element is enabled or not
	 * 
	 */
	public boolean isEnabled() {
		if (loadElement().isEnabled()) {
			LOGGER.info("Element found as enabled");
		} else {
			LOGGER.error("Element is not found as enabled");
		}
		return false;

	}

	/**
	 * Check element is displayed or not
	 * 
	 */
	public boolean isDisplayed() {

		if (loadElement().isDisplayed()) {
			LOGGER.info("Element found as displayed");
		} else {
			LOGGER.error("Element is not found as displayed");
		}
		return false;

	}

	/**
	 * Check element is Selected or not
	 * 
	 */
	public boolean isSelected() {

		if (loadElement().isSelected()) {
			LOGGER.info("Element found as selected");
		} else {
			LOGGER.error("Element is not found as selected");
		}

		return false;

	}

	/**
	 * Click on element
	 */
	public void click() {

		if (loadElement().isEnabled()) {
			element.click();
			LOGGER.info("Perform click action on this element");
		} else {
			LOGGER.error("Failed to perform click action on this element");
		}
	}

	/**
	 * Enter text on text element
	 * 
	 * @param text
	 */
	public void setText(String text) {
		if (loadElement().isEnabled()) {
			//loadElement().clear();
			loadElement().sendKeys(text);
			LOGGER.info("Entered text on this element");
		} else {
			LOGGER.error("Failed to enter text on this element");
		}

	}

	/**
	 * Enter number on text element
	 * 
	 * @param text
	 */
	public void setText(int number) {

		if (loadElement().isEnabled()) {
			loadElement().clear();
			loadElement().sendKeys(String.valueOf(number));
			LOGGER.info("Entered text on this element");
		} else {
			LOGGER.error("Failed to enter text on this element");
		}

	}

	/**
	 * Submit on element
	 * 
	 * @throws CustomException
	 */
	public void submit() {
		if (loadElement().isEnabled()) {
			element.submit();
			LOGGER.info("Perform click action on this element");
		} else {
			LOGGER.error("Failed to perform Submit action on this element");
		}
	}

	/**
	 * Get the text from element
	 * 
	 * @return
	 */
	public String getText() {
		String text = null;
		if (loadElement().isEnabled()) {
			text = loadElement().getText();
			LOGGER.info("Get text from element");
		} else {
			LOGGER.error("Failed to get the text on this element");
		}
		return text;
	}

	/**
	 * Clear text form text Box element
	 * 
	 */
	public void clearText() {
		if (loadElement().isEnabled()) {
			loadElement().clear();
			LOGGER.info("Clear text on this locator: " + element);
		} else {
			LOGGER.error("Failed to clear the element text on this element");
		}

	}

	/**
	 * Mouse hover on element
	 * 
	 */
	public void mouseHover() {
		Actions actions = new Actions(Browser.getDriver());
		actions.moveToElement(loadElement()).build().perform();
		SeleniumCommon.waitForSeconds(3);

	}

	public void selectByVisibleText(WebElement element, String selectOption) {

		Select select = new Select(element);

		select.selectByVisibleText(selectOption);
	}

	public void selectByVisibleText(String selectOption) {

		Select select = new Select(loadElement());

		select.selectByVisibleText(selectOption);
	}

	/**
	 * Find element from web page
	 * 
	 * @param type
	 * @param locatorValue
	 * @return ByLocator
	 */
	public WebElement findElement(LocatorType type, String locatorValue) {
		WebElement webElement = null;
		By byLocator = null;
		switch (type) {
		case ID: // Search the element with Id property
			byLocator = By.id(locatorValue);
			break;
		case NAME: // Search the element with Name property
			byLocator = By.name(locatorValue);
			break;
		case CSSSELECTOR: // Search the element with cssSelector property
			byLocator = By.cssSelector(locatorValue);
			break;
		case XPATH: // Search the element with xpath property
			byLocator = By.xpath(locatorValue);
			break;
		case CLASSNAME: // Search the element with className property
			byLocator = By.className(locatorValue);
			break;
		case LINKTEXT: // Search the element with linkText property
			byLocator = By.linkText(locatorValue);
			break;
		case PARTIALLINKTEXT:// Search the element with partialLinkText
			byLocator = By.partialLinkText(locatorValue);
			break;
		case TAGNAME: // Search the element with tagName property
			byLocator = By.tagName(locatorValue);
		default: // Throw exception if any invalid locator is found
			throw new RuntimeException("Failed to find the locator Value"
					+ locatorValue);
		}
		webElement = getElement(byLocator);

		return webElement;
	}

	/**
	 * Find element from web page
	 * 
	 * @param type
	 * @param locatorValue
	 * @return ByLocator
	 */
	public List<WebElement> findElements(LocatorType type, String locatorValue) {
		List<WebElement> webElement = null;
		By byLocator = null;
		switch (type) {
		case ID: // Search the element with Id property
			byLocator = By.id(locatorValue);
			break;
		case NAME: // Search the element with Name property
			byLocator = By.name(locatorValue);
			break;
		case CSSSELECTOR: // Search the element with cssSelector property
			byLocator = By.cssSelector(locatorValue);
			break;
		case XPATH: // Search the element with xpath property
			byLocator = By.xpath(locatorValue);
			break;
		case CLASSNAME: // Search the element with className property
			byLocator = By.className(locatorValue);
			break;
		case LINKTEXT: // Search the element with linkText property
			byLocator = By.linkText(locatorValue);
			break;
		case PARTIALLINKTEXT:// Search the element with partialLinkText
			byLocator = By.partialLinkText(locatorValue);
			break;
		case TAGNAME: // Search the element with tagName property
			byLocator = By.tagName(locatorValue);
		default: // Throw exception if any invalid locator is found
			throw new RuntimeException("Failed to find the locator Value"
					+ locatorValue);
		}
		webElement = getElements(byLocator);

		return webElement;
	}

	/**
	 * Find element when it is displayed on web page
	 * 
	 * @param byLocator
	 * @return webElement
	 */
	public WebElement getElement(By byLocator) {
		WebElement webElement = null;
		int attempts = 0;

		try {

			if (SeleniumCommon.waitForElement()
					.ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(byLocator)) != null) {
				if (Browser.getDriver().findElement(byLocator).isDisplayed()) {
			webElement = Browser.getDriver().findElement(byLocator);
			System.out.println("locator value = " +byLocator);
					LOGGER.info("Element found successfully");
				} else {
					SeleniumCommon.getscreenshot();
					LOGGER.error("Failed Element is not found by " + byLocator);
					throw new NoSuchElementException(
							"Failed Element is not found by " + byLocator);
				}
		}
		} catch (TimeoutException e) {
			LOGGER.error("Failed to find the element and taking the screen shot"
					+ byLocator);
			SeleniumCommon.getscreenshot();
			throw (e);
		} catch (StaleElementReferenceException e) {
			LOGGER.error("stale element exception" + byLocator);

		}

		return webElement;

	}

	/**
	 * Find element when it is displayed on web page
	 * 
	 * @param byLocator
	 * @return webElement
	 */
	public WebElement getElementByFluent(By byLocator) {
		WebElement webElement = null;
		try {
			if (SeleniumCommon.waitForElementFluent()
					.ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(byLocator)) != null) {
				if (Browser.getDriver().findElement(byLocator).isDisplayed()) {
					webElement = Browser.getDriver().findElement(byLocator);
					LOGGER.info("Element found successfully");
				} else {
					SeleniumCommon.getscreenshot();
					LOGGER.error("Failed Element is not found by " + byLocator);
					throw new NoSuchElementException(
							"Failed Element is not found by " + byLocator);
				}
			}
		} catch (TimeoutException e) {
			LOGGER.error("Failed to find the element and taking the screen shot"
					+ byLocator);
			SeleniumCommon.getscreenshot();
			throw (e);
		}
		return webElement;

	}

	/**
	 * Find element when it is displayed on web page
	 * 
	 * @param byLocator
	 * @return webElement
	 */
	@SuppressWarnings("unchecked")
	public List<WebElement> getElements(By byLocator) {
		List<WebElement> webElement = null;
		try {
			if (SeleniumCommon.waitForElement()
					.ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(byLocator)) != null) {
				if (Browser.getDriver().findElement(byLocator).isDisplayed()) {
					webElement = Browser.getDriver().findElements(byLocator);
					LOGGER.info("Element found successfully");
				} else {
					SeleniumCommon.getscreenshot();
					LOGGER.error("Failed Element is not found by " + byLocator);
					throw new NoSuchElementException(
							"Failed Element is not found by " + byLocator);
				}
			}
		} catch (TimeoutException e) {
			LOGGER.error("Failed to find the element and taking the screen shot"
					+ byLocator);
			SeleniumCommon.getscreenshot();
			throw (e);
		}
		return webElement;

	}

	public List<WebElement> getElementsByFluent(By byLocator) {
		List<WebElement> webElement = null;
		int attempts = 0;
		while (attempts < 2) {
			try {
				if (SeleniumCommon
						.waitForElementFluent()
						.ignoring(StaleElementReferenceException.class)
						.until(ExpectedConditions
								.elementToBeClickable(byLocator)) != null) {
					if (Browser.getDriver().findElement(byLocator)
							.isDisplayed()) {
						webElement = Browser.getDriver()
								.findElements(byLocator);
						LOGGER.info("Element found successfully");
					} else {
						SeleniumCommon.getscreenshot();
						LOGGER.error("Failed Element is not found by "
								+ byLocator);
						throw new NoSuchElementException(
								"Failed Element is not found by " + byLocator);
					}
				}
			} catch (TimeoutException e) {
				LOGGER.error("Failed to find the element and taking the screen shot"
						+ byLocator);
				SeleniumCommon.getscreenshot();
				throw (e);
			}
			attempts++;
		}

		return webElement;

	}

	public static JavascriptExecutor getJavaScriptExecutorInstance() {
		return (JavascriptExecutor) Browser.getDriver();

	}
	
	
	public String getInnerTextOfList(int indexValue)
	{
		List<WebElement> Column=findElements(locatorType, locatorValue);
		String innerText = Column.get(indexValue).getAttribute("innerText").toString().trim();
		return innerText;
	}
	
	public void verifyReportContent(String ReportContent) 
	{
	
	
	if (loadElement().isDisplayed()) {
		
		TestngVerifications.assertExpectedEqualsActualString(loadElement().getText(), ReportContent);
		LOGGER.error(loadElement().getText()+" Element is present on curent web page");
		
	} else {
		LOGGER.error("Element is not Displayed.");
	}
	}
	
	public String getAttributeValue()
	{
		WebElement Column=findElement(locatorType, locatorValue);
		String innerText = Column.getAttribute("value").toString().trim();
		return innerText;
	}
	/*
	 * Click on webelement using mopuse hover6
	 * */
	public void mouseHoverClick() {
		Actions actions = new Actions(Browser.getDriver());
		actions.moveToElement(loadElement()).click().build().perform();
		SeleniumCommon.waitForSeconds(3);
	}
	
	/*
	 * Getting the inner text of web element using attributes
	 * */
	public String getInnerText()
	{
		WebElement Column=findElement(locatorType, locatorValue);
		String innerText = Column.getAttribute("innerHTML").toString().trim();
		return innerText;
	}
	
}

