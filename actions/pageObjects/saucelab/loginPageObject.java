package pageObjects.saucelab;

import org.openqa.selenium.WebDriver;

import commons.nopCommerce.BasePage;
import pageUIs.saucelab.loginPageUI;

public class loginPageObject extends BasePage {
	WebDriver driver;

	public loginPageObject(WebDriver driver) {

		this.driver = driver;

	}

	public void enterToUsernameTextbox(String username) {

		waitForElementVisible(driver, loginPageUI.USERNAME_TEXTBOX);
		sendKeysToElement(driver, loginPageUI.USERNAME_TEXTBOX, username);
	}

	public void enterToPasswordTextbox(String password) {

		waitForElementVisible(driver, loginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, loginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public homePageObject loginToSystem(String username, String password) {
		enterToUsernameTextbox(username);
		enterToPasswordTextbox(password);
		waitForElementClickable(driver, loginPageUI.LOGIN_BUTTON);
		clickToElement(driver, loginPageUI.LOGIN_BUTTON);
		return PageGenerator.getHomePage(driver);
	}
}
