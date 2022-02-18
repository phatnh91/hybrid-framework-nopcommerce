package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.nopCommerce.BasePage;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;
	
	public AdminDashboardPageObject(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public boolean isAdminDashboardTitleDisplayed() {
		waitForAllElementVisible(driver, AdminDashboardPageUI.DASHBOARD_TITLE);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_TITLE);
	}
	public AdminLoginPageObject clickToLogoutLink() {
		
		waitForAllElementVisible(driver, AdminDashboardPageUI.LOGOUT_LINK);
		clickToElementByJS(driver, AdminDashboardPageUI.LOGOUT_LINK);
		return AdminPageGeneratorManager.getAdminLoginPage(driver);
	}

}
