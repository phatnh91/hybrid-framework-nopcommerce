package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.nopCommerce.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Level_12_Check_Undisplayed_Element extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlPage) {
		driver = getBrowserDriver(browserName, urlPage);
		
	}
	@Test
	public void Check_Undisplayed_Element_01() {
		
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToCreateNewAccountButton();
		verifyTrue(homePage.isSignUpTitleDisplayed());
		
		homePage.clickToCloseIcon();
		verifyTrue(homePage.isSignUpTitleUndisplayed());
		
		
	}

	

	@AfterClass
	public void afterClass() {
			driver.quit();
	}

}
