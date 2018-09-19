package applicationActions;

import com.pageObjects.SignInPage;

public class SignInAction {
	
	public void clickOnSignLink() throws InterruptedException {
		SignInPage sip =new SignInPage();
		sip.allowCookie.click();
		sip.signLink.click();		
	}
	
	public void clickOnNonProfitAccountLink() throws InterruptedException {
		SignInPage sip =new SignInPage();
		sip.nonProfitAccountLink.click();
	}
	public void loginFirstGiving(String userName, String password)
	{
		SignInPage sip =new SignInPage();
		sip.loginUsernameFirstGiving.setText(userName);
		sip.loginPasswordFirstGiving.setText(password);
		sip.signInFirstGiving.click();
	}
	
}
