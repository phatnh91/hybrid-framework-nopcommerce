package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.nopCommerce.BasePage;
import pageUIs.nopCommerce.user.UserChangePasswordPageUI;
import pageUIs.nopCommerce.user.UserCustomerInfoPageUI;
import pageUIs.nopCommerce.user.UserHomePageUI;

public class UserPasswordPageObject extends BasePage {
	private WebDriver driver;
	public UserPasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public UserRegisterPageObject clickToRegisterLink() {
		
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return UserPageGeneratorManager.getRegisterPage(driver);
		
	}
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return UserPageGeneratorManager.getLoginPage(driver);
	}
	public boolean isPasswordTitleDisplayed() {
		waitForElementVisible(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_TITLE);
		return isElementDisplayed(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_TITLE);
	}


}
