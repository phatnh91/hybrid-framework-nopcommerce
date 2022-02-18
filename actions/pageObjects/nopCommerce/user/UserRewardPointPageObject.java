package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.nopCommerce.BasePage;
import pageUIs.nopCommerce.user.UserCustomerInfoPageUI;
import pageUIs.nopCommerce.user.UserHomePageUI;
import pageUIs.nopCommerce.user.UserRewardPointsPageUI;

public class UserRewardPointPageObject extends BasePage {
	private WebDriver driver;
	public UserRewardPointPageObject(WebDriver driver) {
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
	public boolean isRewardPointTitleDisplayed() {
		waitForElementVisible(driver, UserRewardPointsPageUI.REWARD_POINTS_TITLE);
		return isElementDisplayed(driver, UserRewardPointsPageUI.REWARD_POINTS_TITLE);
	}
	

}
