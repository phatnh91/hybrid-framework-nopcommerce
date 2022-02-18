package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.nopCommerce.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Level_11_Upload_Files extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	String xoai1,xoai2,xoai3,xoai4;
	
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlPage) {
		driver = getBrowserDriver(browserName, urlPage);
		
	}
	@Test
	public void Upload_01() {
		xoai1 = "xoai1.JPEG";
		xoai2 = "xoai2.JPEG";
		xoai3 = "xoai3.JPEG";
		xoai4 = "xoai4.JPEG";
		String[] allimages = {xoai1, xoai2, xoai3, xoai4};
		
		
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.uploadMultipleFiles(driver, allimages);
		verifyTrue(homePage.isImageLoaded(xoai1));
		verifyTrue(homePage.isImageLoaded(xoai2));
		verifyTrue(homePage.isImageLoaded(xoai3));
		verifyTrue(homePage.isImageLoaded(xoai4));

		homePage.clickToStartButton();
		verifyTrue(homePage.isImageUploaded(xoai1));
		verifyTrue(homePage.isImageUploaded(xoai2));
		verifyTrue(homePage.isImageUploaded(xoai3));
		verifyTrue(homePage.isImageUploaded(xoai4));
		
		
	}

	

	@AfterClass
	public void afterClass() {
//			driver.quit();
	}

}
