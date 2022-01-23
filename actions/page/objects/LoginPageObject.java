package page.objects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver){
		
		this.driver = driver;
		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}

	public String getErrorMessageAtEmailTextbox() {
		
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXT_BOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXT_BOX, email);
		
	}


	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXT_BOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, password);

		
	}

	public String getSummaryErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.SUMMARY_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.SUMMARY_ERROR_MESSAGE);
	}

}
