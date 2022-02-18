package pageObject.guru99;

import org.openqa.selenium.WebDriver;

import commons.guru99.BasePage;
import pageUIs.guru99.HomePageUI;
import pageUIs.guru99.RegisterPageUI;

public class RegisterPageObject extends BasePage {

	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {

		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	public MyDashboardPageObject clickToRegisterButtonSuccess() {

		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getMyDashboardPage(driver);
	}

	public String getFirstNameErrorMessage() {

		waitForAllElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getLastNameErrorMessage() {

		waitForAllElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getEmailErrorMessage() {
		
		waitForAllElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getEmailValidateMessage() {

		waitForAllElementVisible(driver, RegisterPageUI.EMAIL_VALIDATE_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_VALIDATE_MESSAGE);
	}

	public String getPasswordErrorMessage() {

		waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getConfirmPasswordErrorMessage() {

		waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public LoginPageObject clickToBackLink() {

		waitForElementClickable(driver, RegisterPageUI.BACK_LINK);
		clickToElement(driver, RegisterPageUI.BACK_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public void sendKeysToFirstNameTextbox(String firstName) {

		waitForAllElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	public void sendKeysToMiddleNameTextbox(String middleName) {

		waitForAllElementVisible(driver, RegisterPageUI.MIDDLE_NAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.MIDDLE_NAME_TEXTBOX, middleName);

	}

	public void sendKeysToLastNameTextbox(String lastName) {

		waitForAllElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void sendKeysToEmailTextbox(String email) {

		waitForAllElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);

	}

	public void sendKeysToPasswordTextbox(String password) {

		waitForAllElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	public void sendKeysToConfirmPasswordTextbox(String password) {

		waitForAllElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);

	}

	public void selectSignUpNewsletterCheckbox() {

		waitForAllElementVisible(driver, RegisterPageUI.SIGN_UP_NEWSLETTER_CHECKBOX);
		clickToElement(driver, RegisterPageUI.SIGN_UP_NEWSLETTER_CHECKBOX);

	}

	public void clickToAccountLabel() {

		waitForElementClickable(driver, HomePageUI.ACCOUNT_LABEL);
		clickToElement(driver, HomePageUI.ACCOUNT_LABEL);

	}

	public RegisterPageObject clickToRegisterLink() {

		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	
	public String getEmailValidationMessage() {
		
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		return getElementValidationMessageByJS(driver,RegisterPageUI.EMAIL_TEXTBOX);
		
	}
	
	public String getPasswordValidationMessage() {
		
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_VALIDATE_MESSAGE);
		return getElementText(driver,RegisterPageUI.PASSWORD_VALIDATE_MESSAGE);
	}
	
	public String getConfirmPasswordValidationMessage() {
		
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_VALIDATE_MESSAGE);
		return getElementText(driver,RegisterPageUI.CONFIRM_PASSWORD_VALIDATE_MESSAGE);
	}
}
