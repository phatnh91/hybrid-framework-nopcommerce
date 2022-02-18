package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.nopCommerce.BaseTest;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminPageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserPageGeneratorManager;
import pageObjects.nopCommerce.user.UserPasswordPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	UserRegisterPageObject registerPage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserAddressPageObject addressPage;
	UserPasswordPageObject passwordPage;
	UserRewardPointPageObject rewardPointPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;

	String firstName, lastName, email, invalidEmail, validPassword, adminPageUrl, adminEmail, adminPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
//		driver = getBrowserDriver(browserName);
		homePage = UserPageGeneratorManager.getHomePage(driver);
		firstName = "Phat";
		lastName = "Nguyen";
		email = "phatnguyen" + getRandomNumber() + "@qa.team";
		validPassword = "123456";
		adminPageUrl = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
		adminEmail = "admin@yourstore.com";
		adminPassword = "admin";

		


	}

	@Test
	public void User_01_Register() {
		System.out.println("User_01 - step 01: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		System.out.println("User_01 - step 02: Input First Name");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		System.out.println("User_01 - step 03: Input Last Name");
		registerPage.sendKeysToLastNameTextbox(lastName);
		System.out.println("User_01 - step 04: Input Email");
		registerPage.sendKeysToEmailTextbox(email);
		System.out.println("User_01 - step 05: Input Password");
		registerPage.sendKeysToPasswordTextbox(validPassword);
		System.out.println("User_01 - step 06: Input Confirm Password");
		registerPage.sendKeysToConfirmPasswordTextbox(validPassword);
		System.out.println("User_01 - step 07: Click Register Button");
		homePage = registerPage.clickToRegisterButtonSuccess();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		System.out.println("User_01 - step 08: Click Log Out Link");
		homePage = registerPage.clickToLogOutLink();

	}

	@Test
	public void User_02_Login() {

		loginPage = homePage.clickToLoginLink();

		homePage = loginPage.loginAsUser(email, validPassword);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void User_03_My_Account() {

		customerInfoPage = homePage.clickToMyAccountLink();
		customerInfoPage.isCustomerInfoPageDisplayed();

	}

	@Test
	public void User_04_Switch_Page() {
		System.out.println("Step 1: Open Address Page");
		addressPage = customerInfoPage.openAddressesPage(driver);
		System.out.println("Step 2: Verify Address Page Title");
		addressPage.isAddressTitleDisplayed();

		System.out.println("Step 3: Open RewardPoint Page");
		rewardPointPage = addressPage.openRewardPointsPage(driver);
		System.out.println("Step 4: Verify RewardPoint Page Title");
		rewardPointPage.isRewardPointTitleDisplayed();

		System.out.println("Step 5: Open Change Password Page");
		passwordPage = rewardPointPage.openPasswordPage(driver);
		System.out.println("Step 6: Verify Change Password Page Title");
		passwordPage.isPasswordTitleDisplayed();

		System.out.println("Step 7: Open Customer Info Page");
		customerInfoPage = passwordPage.openCustomerInfoPage(driver);
		System.out.println("Step 8: Verify Customer Info Page Title");
		customerInfoPage.isCustomerInfoPageDisplayed();

	}

	@Test
	public void User_05_Switch_Role() {

		customerInfoPage.openPageUrl(driver, adminPageUrl);
		adminLoginPage = AdminPageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
		Assert.assertTrue(adminDashboardPage.isAdminDashboardTitleDisplayed());
		
		adminLoginPage = adminDashboardPage.clickToLogoutLink();
		Assert.assertTrue(adminLoginPage.isAdminLoginPageTitleDisplayed());
		

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
