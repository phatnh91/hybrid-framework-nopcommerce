package com.guru99.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.guru99.BaseTest;
import pageObject.guru99.LoginPageObject;
import pageObject.guru99.MyDashboardPageObject;
import pageObject.guru99.PageGeneratorManager;
import pageObject.guru99.RegisterPageObject;

public class Level_01_Register extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		
		driver = getBrowserDriver(browser);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstName = "Automation";
		lastName = "FC";
		middleName = "23";
		validEmail = "automationfc" +getRandomNumber() + "@qa.team";
		password  = "123456";
		
	}
	
	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - Step 1: Click to Account Label");
		homePage.clickToAccountLabel();
		System.out.println("Register_01 - Step 2: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		System.out.println("Register_01 - Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_01 - Step 4: Verify Error Messages");
		
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "This is a required field.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "This is a required field.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "This is a required field.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "This is a required field.");
		
	}
	
	@Test
	public void Register_02_Invalid_Email_1() {
		System.out.println("Register_02 - Step 1: Click to Account Label");
		registerPage.clickToAccountLabel();
		System.out.println("Register_02 - Step 2: Click to Register Link");
		registerPage.clickToRegisterLink();
		System.out.println("Register_02 - Step 3: Input First Name");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		System.out.println("Register_02 - Step 4: Input Middle Name");
		registerPage.sendKeysToMiddleNameTextbox(middleName);
		System.out.println("Register_02 - Step 5: Input Last Name");
		registerPage.sendKeysToLastNameTextbox(lastName);
		System.out.println("Register_02 - Step 6: Input an invalid Email");
		registerPage.sendKeysToEmailTextbox("automation@qacom");
		System.out.println("Register_02 - Step 7: Input password");
		registerPage.sendKeysToPasswordTextbox(password);
		System.out.println("Register_02 - Step 8: Input confirmation password");
		registerPage.sendKeysToConfirmPasswordTextbox(password);
		System.out.println("Register_02 - Step 9: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register_02 - Step 10: Verify Email Validate Message");
		Assert.assertEquals(registerPage.getEmailValidateMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
		
		
	}
	
	@Test
	public void Register_03_Invalid_Email_2() {
		
		System.out.println("Register_03 - Step 1: Click to Account Label");
		registerPage.clickToAccountLabel();
		System.out.println("Register_03 - Step 2: Click to Register Link");
		registerPage.clickToRegisterLink();
		System.out.println("Register_03 - Step 3: Input First Name");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		System.out.println("Register_03 - Step 4: Input Middle Name");
		registerPage.sendKeysToMiddleNameTextbox(middleName);
		System.out.println("Register_03 - Step 5: Input Last Name");
		registerPage.sendKeysToLastNameTextbox(lastName);
		System.out.println("Register_03 - Step 6: Input an invalid Email");
		String invalidEmail = "automation";
		registerPage.sendKeysToEmailTextbox(invalidEmail);
		System.out.println("Register_03 - Step 7: Input password");
		registerPage.sendKeysToPasswordTextbox(password);
		System.out.println("Register_03 - Step 8: Input confirmation password");
		registerPage.sendKeysToConfirmPasswordTextbox(password);
		System.out.println("Register_03 - Step 9: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register_03 - Step 10: Verify Email Validate Message");
		Assert.assertEquals(registerPage.getEmailValidationMessage(), "Please include an '@' in the email address. '"+invalidEmail+"' is missing an '@'.");
		
		
	}
	
	@Test
	public void Register_04_Password_Less_Than_6_Chars() {
		
		System.out.println("Register_04 - Step 1: Click to Account Label");
		registerPage.clickToAccountLabel();
		System.out.println("Register_04 - Step 2: Click to Register Link");
		registerPage.clickToRegisterLink();
		System.out.println("Register_04 - Step 3: Input First Name");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		System.out.println("Register_04 - Step 4: Input Middle Name");
		registerPage.sendKeysToMiddleNameTextbox(middleName);
		System.out.println("Register_04 - Step 5: Input Last Name");
		registerPage.sendKeysToLastNameTextbox(lastName);
		System.out.println("Register_04 - Step 6: Input a valid Email");
		registerPage.sendKeysToEmailTextbox(validEmail);
		System.out.println("Register_04 - Step 7: Input a password less then 6 chars");
		registerPage.sendKeysToPasswordTextbox("123");
		System.out.println("Register_04 - Step 8: Input confirmation password");
		registerPage.sendKeysToConfirmPasswordTextbox("123");
		System.out.println("Register_04 - Step 9: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register_04 - Step 10: Verify Password Validate Message");
		Assert.assertEquals(registerPage.getPasswordValidationMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
		
		
	}
	
	@Test
	public void Register_05_Confirm_Password_Does_Not_Match_With_Password() {
		
		System.out.println("Register_05 - Step 1: Click to Account Label");
		registerPage.clickToAccountLabel();
		System.out.println("Register_05 - Step 2: Click to Register Link");
		registerPage.clickToRegisterLink();
		System.out.println("Register_05 - Step 3: Input First Name");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		System.out.println("Register_05 - Step 4: Input Middle Name");
		registerPage.sendKeysToMiddleNameTextbox(middleName);
		System.out.println("Register_05 - Step 5: Input Last Name");
		registerPage.sendKeysToLastNameTextbox(lastName);
		System.out.println("Register_05 - Step 6: Input a valid Email");
		registerPage.sendKeysToEmailTextbox(validEmail);
		System.out.println("Register_05 - Step 7: Input a password less then 6 chars");
		registerPage.sendKeysToPasswordTextbox(password);
		System.out.println("Register_05 - Step 8: Input confirmation password");
		registerPage.sendKeysToConfirmPasswordTextbox("1237654");
		System.out.println("Register_05 - Step 9: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register_05 - Step 10: Verify Confirm Password Validate Message");
		Assert.assertEquals(registerPage.getConfirmPasswordValidationMessage(), "Please make sure your passwords match.");
		
		
	}
	
	@Test
	public void Register_06_Successful() {
		
		System.out.println("Register_05 - Step 1: Click to Account Label");
		registerPage.clickToAccountLabel();
		System.out.println("Register_05 - Step 2: Click to Register Link");
		registerPage.clickToRegisterLink();
		System.out.println("Register_05 - Step 3: Input First Name");
		registerPage.sendKeysToFirstNameTextbox(firstName);
		System.out.println("Register_05 - Step 4: Input Middle Name");
		registerPage.sendKeysToMiddleNameTextbox(middleName);
		System.out.println("Register_05 - Step 5: Input Last Name");
		registerPage.sendKeysToLastNameTextbox(lastName);
		System.out.println("Register_05 - Step 6: Input a valid Email");
		registerPage.sendKeysToEmailTextbox(validEmail);
		System.out.println("Register_05 - Step 7: Input a password less then 6 chars");
		registerPage.sendKeysToPasswordTextbox(password);
		System.out.println("Register_05 - Step 8: Input confirmation password");
		registerPage.sendKeysToConfirmPasswordTextbox(password);
		System.out.println("Register_05 - Step 9: Click to Register Button");
		myDashboardPage = registerPage.clickToRegisterButtonSuccess();
		
		System.out.println("Register_05 - Step 10: Verify Thank you Message");
		
		Assert.assertEquals(myDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
		
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private pageObject.guru99.HomePageObject homePage;
	private RegisterPageObject registerPage;
	private MyDashboardPageObject myDashboardPage;
	private String firstName, lastName, validEmail,password,middleName;
}
