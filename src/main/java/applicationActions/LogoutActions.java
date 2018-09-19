package applicationActions;

import com.automation.base.CustomException;
import com.automation.base.DataStoreRepository;
import com.pageObjects.LoginPage;
import com.pageObjects.LogoutPage;
import com.selenium.common.SeleniumCommon;

/**
 * This class will contains all the admin functions
 * 
 * @author bharatp
 * 
 */
public class LogoutActions {

	/**
	 * Login as Super Admin
	 * 
	 * @param userName
	 * @param password
	 */
	public void logoutFromLRSApplication() {
		SeleniumCommon.waitForSeconds(5);
		LogoutPage lp = new LogoutPage();
		lp.caret.click();
		SeleniumCommon.waitForSeconds(2);
		lp.signOut.click();
	}

	public void forgetPassword() throws CustomException {
		LogoutPage lp = new LogoutPage();
		lp.forgetPassword.click();
		SeleniumCommon.waitForSeconds(2);
		LoginPage linp = new LoginPage();
		linp.loginUsername.setText(DataStoreRepository.getValue("mailID1"));
		lp.resetPasswordButton.click();
		SeleniumCommon.waitForSeconds(2);
		lp.againLogin.click();
	}
}
