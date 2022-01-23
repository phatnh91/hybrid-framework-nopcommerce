package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.objects.HomePageObject;
import page.objects.LoginPageObject;
import page.objects.RegisterPageObject;

public class Level_03_Page_Object_02_Login {
	private WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	LoginPageObject loginPage;
	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, existingEmail,invalidEmail, notExistingEmail, validPassword, invalidPassword;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		firstName = "Phat";
		lastName = "Nguyen";
		existingEmail = "phatnguyen" + getRandomNumber() + "@qa.team";
		invalidEmail = "phatnguyen" + getRandomNumber() + "qa.team";
		notExistingEmail = "phatnguyen" + getRandomNumber() + "@gmail.team";
		validPassword = "123456";
		invalidPassword = "654321";
		
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.sendKeysToFirstNameTextbox(firstName);
		registerPage.sendKeysToLastNameTextbox(lastName);
		registerPage.sendKeysToEmailTextbox(existingEmail);
		registerPage.sendKeysToPasswordTextbox(validPassword);
		registerPage.sendKeysToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		registerPage.clickToLogOutLink();
		
		
	}
	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01 - step 01: Click to Login Link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		System.out.println("Login_01 - step 02: Click to Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_01 - step 03: Verify Required Email Message");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
		
		
		
		
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_02 - step 01: Click to Login Link");
		homePage.clickToLoginLink();
		System.out.println("Login_02 - step 02: Input An Invalid Email");
		loginPage.inputToEmailTextbox(invalidEmail);
		System.out.println("Login_02 - step 03: Click to Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_02 - step 04: Verify Wrong Email Message");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}
	
	
	@Test
	public void Login_03_Email_Not_Found() {
		System.out.println("Login_03 - step 01: Click to Login Link");
		homePage.clickToLoginLink();
		System.out.println("Login_03 - step 02: Input a not ExistingEmail");
		loginPage.inputToEmailTextbox(notExistingEmail);
		System.out.println("Login_03 - step 03: Click to Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_03 - step 04: Verify Summary Error Message");
		Assert.assertEquals(loginPage.getSummaryErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		System.out.println("Login_04 - step 01: Click to Login Link");
		homePage.clickToLoginLink();
		System.out.println("Login_04 - step 02: Input an existingEmail");
		loginPage.inputToEmailTextbox(existingEmail);
		System.out.println("Login_04 - step 03: Click to Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_04 - step 04: Verify Summary Error Message");
		Assert.assertEquals(loginPage.getSummaryErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		
		System.out.println("Login_05 - step 01: Click to Login Link");
		homePage.clickToLoginLink();
		System.out.println("Login_05 - step 02: Input a valid Email");
		loginPage.inputToEmailTextbox(existingEmail);
		System.out.println("Login_05 - step 03: Input an invalid Password");
		loginPage.inputToPasswordTextbox(invalidPassword);
		System.out.println("Login_05 - step 04: Click to Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_05 - step 05: Verify Summary Error Message");
		Assert.assertEquals(loginPage.getSummaryErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	
	@Test
	public void Login_06_Valid_Email_And_Password() {
		System.out.println("Login_06 - step 01: Click to Login Link");
		homePage.clickToLoginLink();
		System.out.println("Login_06 - step 02: Input a valid Email");
		loginPage.inputToEmailTextbox(existingEmail);
		System.out.println("Login_06 - step 03: Input a valid Password");
		loginPage.inputToPasswordTextbox(validPassword);
		System.out.println("Login_06 - step 04: Click to Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_06 - step 05: Verify Homepage is Displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}


}
