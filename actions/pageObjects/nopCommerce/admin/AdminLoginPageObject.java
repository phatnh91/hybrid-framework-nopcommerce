package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.nopCommerce.BasePage;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage  {
	WebDriver driver;
	public AdminLoginPageObject(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void sendKeysToEmailTextbox(String email) {
		
		waitForAllElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
		
	}
	
	public void sendKeysToPasswordTextbox(String password) {
		
		waitForAllElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		
		sendKeysToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
		
	}
	
	public void clickToLoginButton() {
		
		waitForAllElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
	}
	
	public AdminDashboardPageObject loginAsAdmin(String email, String password) {
		
		sendKeysToEmailTextbox(email);
		sendKeysToPasswordTextbox(password);
		clickToLoginButton();
		return AdminPageGeneratorManager.getAdminDashboardPage(driver);
		
	}
	
	public boolean isAdminLoginPageTitleDisplayed() {
		waitForAllElementVisible(driver, AdminLoginPageUI.LOGIN_PAGE_TITLE);
		return isElementDisplayed(driver, AdminLoginPageUI.LOGIN_PAGE_TITLE);
		
	}

}
