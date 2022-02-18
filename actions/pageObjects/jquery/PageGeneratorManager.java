package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static AdminHomePageObject getAdminHomePage(WebDriver driver) {
		return new AdminHomePageObject(driver);
	}
	
	public static ManageCustomerPageObject getManageCustomerPage(WebDriver driver) {
		
		return new ManageCustomerPageObject(driver);
	}

}
