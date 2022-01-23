package com.nopcommerce.user;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class User_04_My_Account extends BasePage {
	WebDriver driver;
	String emailAddress = "automationfc.vn1@gmail.com";
	String password = "987653252";
	String newPassword = "263727427";
	String projectPath = System.getProperty("user.dir");

	String gender = "Male";
	String dateOfBirth = "1";
	String monthOfBirth = "9";
	String yearOfBirth = "1991";
	String firstName = "Automation";
	String lastName = "FC";
	String company = "Automation FC";
	String country = "Viet Nam";
	String state = "Other";
	String city = "Da Nang";
	String address1 = "142 Tran Nhan Tong";
	String address2 = "Man Thai, Son Tra";
	String zipCode = "550000";
	String phoneNumber = "0983918891";
	String faxNumber = "0919865491";
	String genderLocator, firstNameLocator, lastNameLocator, emailLocator, companyLocator, dayLocator, monthLocator,
			yearLocator;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

	}

	//@Test
	public void TC_01_Custom_Information() {
		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		genderLocator = "//input[@id='gender-male']";
		firstNameLocator = "//input[@id='FirstName']";
		lastNameLocator = "//input[@id='LastName']";
		dayLocator = "//select[@name='DateOfBirthDay']";
		monthLocator = "//select[@name='DateOfBirthMonth']";
		yearLocator = "//select[@name='DateOfBirthYear']";
		emailLocator = "//input[@id='Email']";
		companyLocator = "//input[@id='Company']";

		sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeysToElement(driver, "//input[@id='Password']", password);
		waitForElementClickable(driver, "//form[@method='post']//button[@type='submit']");
		clickToElement(driver, "//form[@method='post']//button[@type='submit']");
		waitForElementVisible(driver, "//div[@class='header-links']//a[text()='My account']");
		clickToElement(driver, "//div[@class='header-links']//a[text()='My account']");

		clickToElement(driver, "//input[@id='gender-male']");
		sendKeysToElement(driver, "//input[@id='FirstName']", firstName);
		sendKeysToElement(driver, "//input[@id='LastName']", lastName);
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", dateOfBirth);
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", monthOfBirth);
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", yearOfBirth);
		sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeysToElement(driver, "//input[@id='Company']", company);
		clickToElement(driver, "//button[@id='save-info-button']");

		Assert.assertTrue(isElementSelected(driver, genderLocator));
		Assert.assertEquals(getElementAttribute(driver, firstNameLocator, "value"), firstName);
		Assert.assertEquals(getElementAttribute(driver, lastNameLocator, "value"), lastName);
		Assert.assertEquals(getFirstSelectedItemDefaultDropdown(driver, dayLocator), dateOfBirth);
		Assert.assertEquals(getFirstSelectedItemDefaultDropdown(driver, monthLocator),getNameMonthOfBirth(monthOfBirth));
		Assert.assertEquals(getFirstSelectedItemDefaultDropdown(driver, yearLocator), yearOfBirth);
		Assert.assertEquals(getElementAttribute(driver, emailLocator, "value"), emailAddress);
		Assert.assertEquals(getElementAttribute(driver, companyLocator, "value"), company);

	}
	
	//@Test
	public void TC_02_Add_And_Verify_Addresses() {
		
		clickToElement(driver, "//div[@class='listbox']//a[text()='Addresses']");
		waitForElementClickable(driver, "//button[text()='Add new']");
		clickToElement(driver, "//button[text()='Add new']");
		sendKeysToElement(driver, "//input[@id='Address_FirstName']", firstName);
		sendKeysToElement(driver, "//input[@id='Address_LastName']", lastName);
		sendKeysToElement(driver, "//input[@id='Address_Email']", emailAddress);
		sendKeysToElement(driver, "//input[@id='Address_Company']", company);
		selectItemInDefaultDropdown(driver, "//select[@id='Address_CountryId']", "82");
		sendKeysToElement(driver, "//input[@id='Address_City']", city);
		sendKeysToElement(driver, "//input[@id='Address_Address1']", address1);
		sendKeysToElement(driver, "//input[@id='Address_Address2']", address2);
		sendKeysToElement(driver, "//input[@id='Address_ZipPostalCode']", zipCode);
		sendKeysToElement(driver, "//input[@id='Address_PhoneNumber']", phoneNumber);
		sendKeysToElement(driver, "//input[@id='Address_FaxNumber']", faxNumber);
		
		clickToElement(driver, "//button[text()='Save']");
		waitForElementPresence(driver, "//h1[text()='My account - Addresses']");
		Assert.assertEquals(getElementText(driver, "//li[@class='name']"), firstName + " " + lastName);
		Assert.assertEquals(getElementText(driver, "//li[@class='email']").replace("Email: ", ""), emailAddress);
		Assert.assertEquals(getElementText(driver, "//li[@class='phone']").replace("Phone number: ", ""), phoneNumber);
		Assert.assertEquals(getElementText(driver, "//li[@class='fax']").replace("Fax number: ", ""), faxNumber);
		Assert.assertEquals(getElementText(driver, "//li[@class='company']"), company);
		Assert.assertEquals(getElementText(driver, "//li[@class='address1']"), address1);
		Assert.assertEquals(getElementText(driver, "//li[@class='address2']"), address2);
		Assert.assertEquals(getElementText(driver, "//li[@class='city-state-zip']"), city + ", " +zipCode);
		Assert.assertEquals(getElementText(driver, "//li[@class='country']"), country);
		
		
	}
	@Test
	public void TC_03_Change_Password() {
		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");
		sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeysToElement(driver, "//input[@id='Password']", password);
		waitForElementClickable(driver, "//form[@method='post']//button[@type='submit']");
		clickToElement(driver, "//form[@method='post']//button[@type='submit']");
		waitForElementVisible(driver, "//div[@class='header-links']//a[text()='My account']");
		clickToElement(driver, "//div[@class='header-links']//a[text()='My account']");
		waitForElementClickable(driver, "//a[text()='Change password']");
		clickToElement(driver, "//a[text()='Change password']");
		
		sendKeysToElement(driver, "//input[@id='OldPassword']", password);
		sendKeysToElement(driver, "//input[@id='NewPassword']", newPassword);
		sendKeysToElement(driver, "//input[@id='ConfirmNewPassword']", newPassword);
		clickToElement(driver, "//button[text()='Change password']");
		Assert.assertTrue(isElementDisplayed(driver, "//div[@class='bar-notification success']/p[text()='Password was changed']"));
		
		waitForElementClickable(driver, "//a[@class='ico-logout']");
		clickToElementByJS(driver, "//a[@class='ico-logout']");
		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");
		sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
		sendKeysToElement(driver, "//input[@id='Password']", password);
		clickToElement(driver, "//form[@method='post']//button[@type='submit']");
		Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
		sendKeysToElement(driver, "//input[@id='Password']", newPassword);
		clickToElement(driver, "//form[@method='post']//button[@type='submit']");
		Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
		waitForElementVisible(driver, "//div[@class='header-links']//a[text()='My account']");
		Assert.assertTrue(isElementDisplayed(driver, "//div[@class='header-links']//a[text()='My account']"));
	}
	
	@Test
	public void TC_04_Product_Review() {
		
		clickToElement(driver, "//img[@alt='Picture of Build your own computer']");
		waitForElementClickable(driver, "//a[text()='Add your review']");
		clickToElement(driver, "//a[text()='Add your review']");
		String reviewTitle = getRandomNumber() + "review";
		String reviewContent = "The CPC is strong but it's too loud sometimes";
		Integer ratingValue = 4;
		sendKeysToElement(driver, "//input[@class='review-title']", reviewTitle);
		sendKeysToElement(driver, "//textarea[@class='review-text']",reviewContent );
		clickToElement(driver, "//div[@class='rating-options']/input[@value="+ratingValue+"]");
		clickToElement(driver, "//button[@name='add-review']");
		
		List<WebElement> productReviews = getListWebElement(driver, "//div[@class='product-review-item']//div[@class='review-title']");
		List<WebElement> productRating = getListWebElement(driver, "//div[@class='rating']/div");
		List<WebElement> productReviewContent = getListWebElement(driver, "//div[@class='review-content']//div[@class='text-body']");
		Assert.assertTrue(productReviews.get(0).getText().equals(reviewTitle));
		productRating.get(0).getAttribute("style").contains(getRatingPercent(ratingValue));
		Assert.assertTrue(productReviewContent.get(0).getText().equals(reviewContent));
		
	}
	public String getNameMonthOfBirth(String monthName) {
		monthName = monthOfBirth;
		
		switch (monthOfBirth) {
		case "1":
			monthName = "January";
			break;
			
		case "2":
			monthName = "February";
			break;
		case "3":
			monthName = "March";
			break;
			
		case "4":
			monthName = "April";
			break;
		case "5":
			monthName = "May";
			break;
			
		case "6":
			monthName = "June";
			break;
		case "7":
			monthName = "July";
			break;
			
		case "8":
			monthName = "August";
			break;
		case "9":
			monthName = "September";
			break;
			
		case "10":
			monthName = "October";
			break;
		case "11":
			monthName = "November";
			break;
			
		case "12":
			monthName = "December";
			break;

			//return;
		}
		return monthName;
	}
	
	public String getRatingPercent(int ratingValue) {
		String ratingPercent=null;
		
		switch (ratingValue) {
		case 1:
			ratingPercent = "20%";
			break;
			
		case 2:
			ratingPercent = "40%";
			break;
		case 3:
			ratingPercent = "60%";
			break;
			
		case 4:
			ratingPercent = "80%";
			break;
		case 5:
			ratingPercent = "100%";
			break;
			
		}
		return ratingPercent;
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
