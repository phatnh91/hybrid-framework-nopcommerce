package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.nopCommerce.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserPageGeneratorManager;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import report.config.ExtentTestManager;

public class Level_13_Log_Test_NG extends BaseTest {
	private WebDriver driver;
	UserRegisterPageObject registerPage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	String firstName, lastName, existingEmail, invalidEmail, notExistingEmail, validPassword, invalidPassword;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String pageUrl) {
		driver = getBrowserDriver(browserName, pageUrl);
		
		homePage = UserPageGeneratorManager.getHomePage(driver);
		firstName = "Phat";
		lastName = "Nguyen";
		existingEmail = "phatnguyen" + getRandomNumber() + "@qa.team";
		invalidEmail = "phatnguyen" + getRandomNumber() + "qa.team";
		notExistingEmail = "phatnguyen" + getRandomNumber() + "@gmail.team";
		validPassword = "123456";
		invalidPassword = "654321";

		
		

	}

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_01_Register");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - STEP 01: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - STEP 02: Send Key to First Name textbox");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - STEP 03: Send Key to Last Name textbox");
		registerPage.sendKeysToLastNameTextbox(lastName);
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - STEP 04: Send Key to Email textbox");
		registerPage.sendKeysToEmailTextbox(existingEmail);
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - STEP 05: Send Key to Password textbox");
		registerPage.sendKeysToPasswordTextbox(validPassword);
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - STEP 06: Send Key to Confirm Password textbox");
		registerPage.sendKeysToConfirmPasswordTextbox(validPassword);
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - STEP 07: Click to Register button");
		registerPage.clickToRegisterButton();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - STEP 08: Verify registered successsful message");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - STEP 09: Click to Log Out Link");
		homePage = registerPage.clickToLogOutLink();
		
		ExtentTestManager.endTest();
	}

	
	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Login");
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - STEP 01: Click to Log In Link");
		loginPage=homePage.clickToLoginLink();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - STEP 02: Enter a valid email to Email textbox");
		loginPage.inputToEmailTextbox(existingEmail);
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - STEP 03: Enter a valid Password to Password textbox");
		loginPage.inputToPasswordTextbox(validPassword);
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - STEP 04: Click to Log In button");
		loginPage.clickToLoginButton();
		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02_Login - STEP 05: Verify My Account link displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());
		
		ExtentTestManager.endTest();

	}

	@AfterClass
	public void afterClass() {
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Post condition: Close browser ");
		driver.quit();
	}

	

}
