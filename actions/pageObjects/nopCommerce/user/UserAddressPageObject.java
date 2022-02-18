package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.nopCommerce.BasePage;
import pageUIs.nopCommerce.user.UserAddressesPageUI;
import pageUIs.nopCommerce.user.UserCustomerInfoPageUI;
import pageUIs.nopCommerce.user.UserHomePageUI;

public class UserAddressPageObject extends BasePage {
	private WebDriver driver;
	public UserAddressPageObject(WebDriver driver) {
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
	public boolean isAddressTitleDisplayed() {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESSES_TITLE);
		return isElementDisplayed(driver, UserAddressesPageUI.ADDRESSES_TITLE);
	}
	

}
