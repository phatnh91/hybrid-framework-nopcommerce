package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

import commons.nopCommerce.BasePage;
import commons.nopCommerce.GlobalConstants;
import pageUIs.jquery.RegisterPageUI;

public class RegisterPageObject extends BasePage {

	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeysToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);

	}

	public void sendKeysToLastNameTextbox(String lastName) {

		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);

	}

	public void sendKeysToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void sendKeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	public void sendKeysToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickToRegisterButton() {

		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}
	
	public boolean isRegisterSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	
	public void registerAUser() {
		
		sendKeysToFirstNameTextbox(GlobalConstants.FIRST_NAME);
		sendKeysToLastNameTextbox(GlobalConstants.LAST_NAME);
		sendKeysToEmailTextbox(GlobalConstants.EMAIL);
		sendKeysToPasswordTextbox(GlobalConstants.PASSWORD);
		sendKeysToConfirmPasswordTextbox(GlobalConstants.PASSWORD);
		clickToRegisterButton();
	}

}
