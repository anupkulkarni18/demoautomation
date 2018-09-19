package applicationActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.browser.Browser;
import com.pageObjects.LoginPage;
import com.selenium.common.SeleniumCommon;

import selenium.Element;
import selenium.LocatorType;

/**
 * This class will contains all the admin functions
 * 
 * @author bharatp
 * 
 */
public class LoginActions {

	/**
	 * Login as Super Admin
	 * 
	 * @param userName
	 * @param password
	 */

	Element element = SeleniumCommon.getElementInstance();

	public List<String> loginInLRSApplication(String userName, String password) {
		LoginPage lp = new LoginPage();
		// element.findElement(LocatorType.XPATH,
		// lp.loginUsername).sendKeys(userName);
		lp.loginUsername.setText(userName);
		// element.findElement(LocatorType.XPATH,
		// lp.loginPassword).sendKeys(password);

		lp.loginPassword.setText(password);
		lp.loginButton.click();
		SeleniumCommon.waitForSeconds(5);
//		lp.lrsAdminAccountsItem.click();
		// List<WebElement> list = lp.dropDownMenu.getElements();
		//
		// List<String> actual = new ArrayList<String>();
		//
		// for (int i = 0; i < list.size(); i++) {
		// WebElement element = list.get(i);
		// actual.add(element.getAttribute("innerHTML").trim());
		//
		// }
		return null;
	}

	public boolean loginInWithUser(String userName, String password,
			String accountHolder) {
		LoginPage loginPage = new LoginPage();
		loginPage.loginUsername.clearText();
		loginPage.loginUsername.setText(userName);
		loginPage.loginPassword.clearText();
		loginPage.loginPassword.setText(password);
		loginPage.loginButton.click();
		SeleniumCommon.waitForSeconds(20);
		return Element.getInstance().getDynamicXPath(LocatorType.XPATH,
				loginPage.userLogin1 + accountHolder + loginPage.userLogin2).isDisplayed();

	}

	public void ActivateAccount(String firstName, String lastName,
			String password, String conformPassword) {
		LoginPage lp = new LoginPage();
		lp.changeAccountownerFirstname.setText(firstName);
		lp.changeAccountownerLastname.setText(lastName);
		lp.password.setText(password);
		lp.conformPassword.setText(password);
		lp.conformButton.click();
	}

	public void loginLRSApp(String userName, String password) {
		LoginPage lp = new LoginPage();
		lp.loginUsername.setText(userName);
 		lp.loginPassword.setText(password);
		lp.loginButton.click();
	}

	public void resetPassword(String Password) {
		LoginPage lp = new LoginPage();
		lp.loginPassword.setText(Password);
		lp.conformforgetPassword.setText(Password);
		lp.forgetPasswordOKbutton.click();
	}

}
