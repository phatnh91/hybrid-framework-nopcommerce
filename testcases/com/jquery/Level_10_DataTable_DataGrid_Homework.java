package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.guru99.BaseTest;
import commons.nopCommerce.GlobalConstants;
import pageObjects.jquery.AdminHomePageObject;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.ManageCustomerPageObject;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.RegisterPageObject;

public class Level_10_DataTable_DataGrid_Homework extends BaseTest {

	private WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	AdminHomePageObject adminHomePage;
	ManageCustomerPageObject manageCustomerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlPage) {
		driver = getBrowserDriver(browserName, urlPage);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToAccountHeaderLink();
		registerPage = homePage.clickToRegisterLink();
		registerPage.registerAUser();

	}
	@Test
	public void Table_01() {
		
		registerPage.isRegisterSuccessMessageDisplayed();
		registerPage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE);
		adminHomePage = PageGeneratorManager.getAdminHomePage(driver);
		manageCustomerPage = adminHomePage.loginAsAdmin();
		manageCustomerPage.dismissPopup();
		manageCustomerPage.sendKeysToEmailTextboxHeaderAndSearch(GlobalConstants.EMAIL);
		manageCustomerPage.compareRegisteredEmailDisplayed(GlobalConstants.EMAIL);
	
		
		
		
	}

	

	@AfterClass
	public void afterClass() {
//			driver.quit();
	}

}
