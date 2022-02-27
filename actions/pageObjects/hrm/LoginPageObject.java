package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.nopCommerce.BasePage;
import pageUIs.hrm.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public DashboardPageObject loginToSystem(String username, String password) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGenerator.getDashboardPage(driver);
	}

}
