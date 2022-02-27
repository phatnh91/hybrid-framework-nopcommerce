package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.nopCommerce.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserPageGeneratorManager;

public class Common_02_Get_Login_Page_Cookie extends BaseTest {
	private WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String pageUrl) {
		driver = getBrowserDriver(browserName, pageUrl);

		homePage = UserPageGeneratorManager.getHomePage(driver);

	
	}
	
	@Test
	public void TC_01() {
		
		log.info("Common_02 - STEP 01: Click to Log In Link");
		loginPage = homePage.clickToLoginLink();
		log.info("Common_02 - STEP 02: Set all login page cookie ");
		loginPage.setAllCookies(driver, Common_01_Login.loginPageCookie);
		loginPage.sleepInSecond(5);
		loginPage.refreshCurrentPage(driver);
		homePage = UserPageGeneratorManager.getHomePage(driver);
		log.info("Common_02 - STEP 03: Verify My Account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		
	}
	
	@AfterClass
	public void afterClass() {
		
		log.info("Post-condition: Close browser ");
		driver.quit();
	}

}
