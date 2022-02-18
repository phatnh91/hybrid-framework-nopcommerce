package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.nopCommerce.BasePage;
import pageUIs.nopCommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;
	
	
	public UserLoginPageObject(WebDriver driver){
		
		this.driver = driver;
		
	}
	
	

	public void clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		
		
	}

	public String getErrorMessageAtEmailTextbox() {
		
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXT_BOX);
		sendKeysToElement(driver, UserLoginPageUI.EMAIL_TEXT_BOX, email);
		
	}


	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXT_BOX);
		sendKeysToElement(driver, UserLoginPageUI.PASSWORD_TEXT_BOX, password);

		
	}

	public String getSummaryErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.SUMMARY_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.SUMMARY_ERROR_MESSAGE);
	}
	
	public UserHomePageObject loginAsUser(String email, String password) {
		
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		clickToLoginButton();
		return UserPageGeneratorManager.getHomePage(driver);
	}

}
