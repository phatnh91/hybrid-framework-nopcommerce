package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.nopCommerce.BasePage;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {

		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_LINK);
		clickToElement(driver, UserRegisterPageUI.REGISTER_LINK);

	}

	public void clickToRegisterButton() {

		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);

	}
	public UserHomePageObject clickToRegisterButtonSuccess() {

		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		return UserPageGeneratorManager.getHomePage(driver);

	}
	
	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);

	}

	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);

	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);

	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);

	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);

	}

	public void sendKeysToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	public void sendKeysToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void sendKeysToEmailTextbox(String email) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXT_BOX);
		sendKeysToElement(driver, UserRegisterPageUI.EMAIL_TEXT_BOX, email);

	}

	public void sendKeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXT_BOX);
		sendKeysToElement(driver, UserRegisterPageUI.PASSWORD_TEXT_BOX, password);

	}

	public void sendKeysToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX);
		sendKeysToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, confirmPassword);

	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);

	}

	public UserHomePageObject clickToLogOutLink() {
		waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return UserPageGeneratorManager.getHomePage(driver);

	}

	public String getErrorMessageAtTheTop() {
		
		waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

}
