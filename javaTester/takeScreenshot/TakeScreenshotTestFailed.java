package takeScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.nopCommerce.BaseTest;
import commons.nopCommerce.GlobalConstants;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserPageGeneratorManager;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class TakeScreenshotTestFailed extends BaseTest {
	private WebDriver driver;
	UserRegisterPageObject registerPage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	String firstName, lastName, existingEmail, invalidEmail, notExistingEmail, validPassword, invalidPassword;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String pageUrl) {
		log.info("Pre- condition: Run "+ browserName + " open: " +pageUrl);
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
	public void TC_01() {
		log.info("User_01_Register - STEP 01: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		log.info("User_01_Register - STEP 02: Send Key to First Name textbox");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		log.info("User_01_Register - STEP 03: Send Key to Last Name textbox");
		registerPage.sendKeysToLastNameTextbox(lastName);
		log.info("User_01_Register - STEP 04: Send Key to Email textbox");
		registerPage.sendKeysToEmailTextbox(existingEmail);
		log.info("User_01_Register - STEP 05: Send Key to Password textbox");
		registerPage.sendKeysToPasswordTextbox(validPassword);
		log.info("User_01_Register - STEP 06: Send Key to Confirm Password textbox");
		registerPage.sendKeysToConfirmPasswordTextbox(validPassword);
		log.info("User_01_Register - STEP 07: Click to Register button");
		registerPage.clickToRegisterButton();
		log.info("User_01_Register - STEP 08: Verify registered successsful message");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		log.info("User_01_Register - STEP 09: Click to Log Out Link");
		homePage = registerPage.clickToLogOutLink();
	}
	
	@Test
	public void TC_02() {
		log.info("User_02_Login - STEP 01: Click to Log In Link");
		loginPage=homePage.clickToLoginLink();
		log.info("User_02_Login - STEP 02: Enter a valid email to Email textbox");
		loginPage.inputToEmailTextbox(existingEmail);
		log.info("User_02_Login - STEP 03: Enter a valid Password to Password textbox");
		loginPage.inputToPasswordTextbox(validPassword);
		log.info("User_02_Login - STEP 04: Click to Log In button");
		loginPage.clickToLoginButton();
		log.info("User_02_Login - STEP 05: Verify My Account link displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());


	}
	public WebDriver getWebDriver() {
		
		return this.driver;
		
	}
	

	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		
		driver.quit();
	}


}
