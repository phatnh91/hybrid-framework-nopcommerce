package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

public class AdminPageGeneratorManager {

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {

		return new AdminLoginPageObject(driver);

	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {

		return new AdminDashboardPageObject(driver);

	}

}
