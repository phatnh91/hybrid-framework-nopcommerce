package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.nopCommerce.BasePage;
import pageUIs.nopCommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;
	public UserHomePageObject(WebDriver driver) {
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
	
	public UserLoginPageObject clickToLogOutLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGOUT_LINK);
		clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
		return UserPageGeneratorManager.getLoginPage(driver);
	}
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}
	public UserCustomerInfoPageObject clickToMyAccountLink() {

		waitForAllElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return UserPageGeneratorManager.getCustomerInfoPage(driver);
	}

}
