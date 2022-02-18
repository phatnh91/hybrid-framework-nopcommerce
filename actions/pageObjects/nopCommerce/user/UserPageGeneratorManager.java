package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

public class UserPageGeneratorManager {

	
	
	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);

	}

	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);

	}

	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);

	}

	public static UserCustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {

		return new UserCustomerInfoPageObject(driver);
	}

	public static UserAddressPageObject getAddressesPage(WebDriver driver) {
		
		return new UserAddressPageObject(driver);
	}
	
	public static UserRewardPointPageObject getRewardPointPage(WebDriver driver) {
		
		return new UserRewardPointPageObject(driver);
	}
	
	public static UserPasswordPageObject getPasswordPage(WebDriver driver) {

		return new UserPasswordPageObject(driver);
	}
}
