package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

import commons.nopCommerce.BasePage;
import commons.nopCommerce.GlobalConstants;
import pageUIs.jquery.AdminHomePageUI;

public class AdminHomePageObject extends BasePage {
	
	private WebDriver driver;
	
	public AdminHomePageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeysToUsernameTextbox(String userName) {
		
		waitForElementVisible(driver, AdminHomePageUI.USERNAME_TEXTBOX);
		sendKeysToElement(driver, AdminHomePageUI.USERNAME_TEXTBOX, userName);
		
	}
	
	public void sendKeysToPasswordTextbox(String password) {
		
		waitForElementVisible(driver, AdminHomePageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, AdminHomePageUI.PASSWORD_TEXTBOX, password);
	}
	
	public ManageCustomerPageObject loginAsAdmin() {
		sendKeysToUsernameTextbox(GlobalConstants.ADMIN_USERNAME);
		sendKeysToPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
		clickToElement(driver, AdminHomePageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getManageCustomerPage(driver);
	}
	
	

}
