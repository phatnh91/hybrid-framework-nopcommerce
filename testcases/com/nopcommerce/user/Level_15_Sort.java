package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.nopCommerce.BaseTest;
import pageObjects.saucelab.PageGenerator;
import pageObjects.saucelab.homePageObject;
import pageObjects.saucelab.loginPageObject;

public class Level_15_Sort extends BaseTest {
	private WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String pageUrl) {
		driver = getBrowserDriver(browserName, pageUrl);
		loginPage = PageGenerator.getLoginPage(driver);
		homePage = loginPage.loginToSystem("standard_user", "secret_sauce");

	}

	@Test
	public void Sort_01_Name() {
		homePage.selectSortDropDownByText("Name (A to Z)");
		verifyTrue(homePage.isProductNameSortAscending());
		homePage.selectSortDropDownByText("Name (Z to A)");
		verifyTrue(homePage.isProductNameSortDescending());
	}
	
	@Test
	public void Sort_02_Name_Failed() {
		homePage.selectSortDropDownByText("Name (A to Z)");
		verifyTrue(homePage.isProductNameSortDescending());
		
		homePage.selectSortDropDownByText("Name (Z to A)");
		verifyTrue(homePage.isProductNameSortAscending());
	}

	@Test
	public void Sort_03_Price() {
		homePage.selectSortDropDownByText("Price (low to high)");
		verifyTrue(homePage.isProductPriceSortAscending());
		homePage.selectSortDropDownByText("Price (high to low)");
		verifyTrue(homePage.isProductPriceSortDescending());
	}
	
	@Test
	public void Sort_04_Price_Failed() {
		homePage.selectSortDropDownByText("Price (low to high)");
		verifyTrue(homePage.isProductPriceSortDescending());
		
		homePage.selectSortDropDownByText("Price (high to low)");
		verifyTrue(homePage.isProductPriceSortAscending());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	loginPageObject loginPage;
	homePageObject homePage;
}
