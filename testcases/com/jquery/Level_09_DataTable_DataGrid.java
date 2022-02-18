package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.guru99.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Level_09_DataTable_DataGrid extends BaseTest {
	
		private WebDriver driver;
		HomePageObject homePage;
		


		@Parameters({"browser", "url"})
		@BeforeClass
		public void beforeClass(String browserName, String urlPage) {
		driver = getBrowserDriver(browserName, urlPage);
		homePage = PageGeneratorManager.getHomePage(driver);

		}

		
		public void Table_01_Paging() {
			
			homePage.getAllRowData();
		}
		
		@Test
		public void Table_02() {
			
			homePage.enterToTextboxByColumnNameAtRowNumber("Album", "1", "Fika crew");
			homePage.enterToTextboxByColumnNameAtRowNumber("Artist", "1", "hunter");
			homePage.enterToTextboxByColumnNameAtRowNumber("Year", "1", "1991");
			homePage.enterToTextboxByColumnNameAtRowNumber("Price", "1", "200");
			
			homePage.selectToDropdownByColumnNameAtRowNumber("Origin",  "1" , "Japan");
			

		}

		

		@AfterClass
		public void afterClass() {
//			driver.quit();
		}

	}


