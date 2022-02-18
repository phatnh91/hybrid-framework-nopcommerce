package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_03_Page_Object_01_Register {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, emailAddress, password;

	
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		registerPage = new UserRegisterPageObject(driver);
		homePage = new UserHomePageObject(driver);
		driver.get("https://demo.nopcommerce.com/");
		firstName = "Phat";
		lastName = "Nguyen";
		emailAddress = "phatnguyen" + getRandomNumber() + "@qa.team";
		password = "123456";
		
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01: Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();
		System.out.println("Register_01: Step 02 - Click to Register Button");
		registerPage.clickToRegisterButton();
		
		registerPage.getFirstNameErrorMessage();
		registerPage.getLastNameErrorMessage();
		registerPage.getEmailErrorMessage();
		registerPage.getPasswordErrorMessage();
		registerPage.getConfirmPasswordErrorMessage();
		
		System.out.println("Register_01: Step 03 - Verify error messsages");
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		
		System.out.println("Register_02: Step 01 - Click to Register Link");
		registerPage.clickToRegisterLink();
		
		System.out.println("Register_02: Step 03 - Enter an invalid Email");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		registerPage.sendKeysToLastNameTextbox(lastName);
		registerPage.sendKeysToEmailTextbox("abc@3424!#!");
		registerPage.sendKeysToPasswordTextbox(password);
		registerPage.sendKeysToConfirmPasswordTextbox(password);
		System.out.println("Register_02: Step 04 - Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_02: Step 05 - Verify error Email messsage");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");

	}

	@Test
	public void Register_03_Password_Less_Than_6_Chars() {
		System.out.println("Register_03: Step 01 - Click to Register Link");
		registerPage.clickToRegisterLink();
		System.out.println("Register_03: Step 02 - Enter a password less than 6 characters");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		registerPage.sendKeysToLastNameTextbox(lastName);
		registerPage.sendKeysToEmailTextbox(emailAddress);
		registerPage.sendKeysToPasswordTextbox("123");
		registerPage.sendKeysToConfirmPasswordTextbox("123");
		System.out.println("Register_03: Step 03 - Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_03: Step 04 - Verify error Password messsage");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_04_Invalid_Confirm_Password() {
		System.out.println("Register_04: Step 01 - Click to Register Link");
		registerPage.clickToRegisterLink();
		System.out.println("Register_04: Step 02 - Enter an invalid Confirm Password");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		registerPage.sendKeysToLastNameTextbox(lastName);
		registerPage.sendKeysToEmailTextbox(emailAddress);
		registerPage.sendKeysToPasswordTextbox(password);
		registerPage.sendKeysToConfirmPasswordTextbox("654321");
		System.out.println("Register_04: Step 03 - Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_04: Step 04 - Verify error Confirm Password messsage");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(),
				"The password and confirmation password do not match.");

	}

	@Test
	public void Register_05_Success() {
		emailAddress = "automationfc.vn@gmail.com";
		System.out.println("Register_05: Step 01 - Click to Register Link");
		registerPage.clickToRegisterLink();

		System.out.println("Register_05: Step 02 - Enter all valid data");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		registerPage.sendKeysToLastNameTextbox(lastName);
		registerPage.sendKeysToEmailTextbox(emailAddress);
		registerPage.sendKeysToPasswordTextbox(password);
		registerPage.sendKeysToConfirmPasswordTextbox(password);
		System.out.println("Register_05: Step 03 - Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_05: Step 04 - Verify Register success messsage");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void Register_06_Existing_Email() {
		System.out.println("Register_06: Step 01 - Click to Log Out Link");
		registerPage.clickToLogOutLink();
		System.out.println("Register_06: Step 02 - Click to Register Link");
		homePage.clickToRegisterLink();
	
		System.out.println("Register_06: Step 03 - Enter a registed Email");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		registerPage.sendKeysToLastNameTextbox(lastName);
		registerPage.sendKeysToEmailTextbox(emailAddress);
		registerPage.sendKeysToPasswordTextbox(password);
		registerPage.sendKeysToConfirmPasswordTextbox(password);
		System.out.println("Register_06: Step 04 - Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_06: Step 05 - Verify the existing email messsage");
		Assert.assertEquals(registerPage.getErrorMessageAtTheTop(),
				"The specified email already exists");

	}

	

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
