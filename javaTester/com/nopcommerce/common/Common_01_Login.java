package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.nopCommerce.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserPageGeneratorManager;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Login extends BaseTest {
	private WebDriver driver;
	UserRegisterPageObject registerPage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	static Set<Cookie> loginPageCookie;
	String firstName, lastName, existingEmail, invalidEmail, notExistingEmail, validPassword, invalidPassword;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeSuite(String browserName, String pageUrl) {
		driver = getBrowserDriver(browserName, pageUrl);

		homePage = UserPageGeneratorManager.getHomePage(driver);
		firstName = "Phat";
		lastName = "Nguyen";
		existingEmail = "phatnguyen" + getRandomNumber() + "@qa.team";
		invalidEmail = "phatnguyen" + getRandomNumber() + "qa.team";
		notExistingEmail = "phatnguyen" + getRandomNumber() + "@gmail.team";
		validPassword = "123456";
		invalidPassword = "654321";

		log.info("Common_01 - STEP 01: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		log.info("Common_01 - STEP 02: Send Key to First Name textbox");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		log.info("Common_01 - STEP 03: Send Key to Last Name textbox");
		registerPage.sendKeysToLastNameTextbox(lastName);
		log.info("Common_01 - STEP 04: Send Key to Email textbox");
		registerPage.sendKeysToEmailTextbox(existingEmail);
		log.info("Common_01 - STEP 05: Send Key to Password textbox");
		registerPage.sendKeysToPasswordTextbox(validPassword);
		log.info("Common_01 - STEP 06: Send Key to Confirm Password textbox");
		registerPage.sendKeysToConfirmPasswordTextbox(validPassword);
		log.info("Common_01 - STEP 07: Click to Register button");
		registerPage.clickToRegisterButton();
		log.info("Common_01 - STEP 08: Verify registered successsful message");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		log.info("Common_01 - STEP 09: Click to Log Out Link");
		homePage = registerPage.clickToLogOutLink();

		log.info("Common_01 - STEP 10: Click to Log In Link");
		loginPage = homePage.clickToLoginLink();
		log.info("Common_01 - STEP 11: Enter a valid email to Email textbox");
		loginPage.inputToEmailTextbox(existingEmail);
		log.info("Common_01 - STEP 12: Enter a valid Password to Password textbox");
		loginPage.inputToPasswordTextbox(validPassword);
		log.info("Common_01 - STEP 13: Click to Log In button");
		loginPage.clickToLoginButton();
		log.info("Common_01 - STEP 14: Verify My Account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Common_01 - STEP 15: Get all login page cookies");
		loginPageCookie = homePage.getAllCookies(driver);

		log.info("Post-condition: Close browser ");
		driver.quit();
	}

}
