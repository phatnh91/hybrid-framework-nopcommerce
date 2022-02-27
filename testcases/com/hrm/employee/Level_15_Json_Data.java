package com.hrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hrm.data.EmployeeData;

import commons.nopCommerce.BaseTest;
import pageObjects.hrm.AddEmployeePageObject;
import pageObjects.hrm.DashboardPageObject;
import pageObjects.hrm.EmployeeListPageObject;
import pageObjects.hrm.LoginPageObject;
import pageObjects.hrm.MyInfoPageObject;
import pageObjects.hrm.PageGenerator;
import pageObjects.hrm.PersonalDetailsPageObject;

public class Level_15_Json_Data extends BaseTest {
	private WebDriver driver;
	String employeeID;
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String pageUrl) {
		log.info("Pre-condition - Step 01: Open browser '" + browserName + "' and navigate to '" + pageUrl + "'");
		driver = getBrowserDriver(browserName, pageUrl);
		employeeData = EmployeeData.getEmployeeData();
		loginPage = PageGenerator.getLoginPage(driver);
		log.info("Pre-condition - Step 02: Login with admin role");
		dashboardPage = loginPage.loginToSystem(employeeData.getAdminusername(), employeeData.getAdminpassword());
	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add New Employee - Step 01: Open 'Employee List' page");
		employeeListPage = dashboardPage.openEmployeeListPage();
		log.info("Add New Employee - Step 02: Click to 'Add' button");
		addEmployeePage =  employeeListPage.clickToAddButton();
		log.info("Add New Employee - Step 03: Enter 'First Name' textbox");
		addEmployeePage.enterToFirstNameTextbox(employeeData.getFirstname());
		log.info("Add New Employee - Step 04: Enter 'Last Name' textbox");
		addEmployeePage.enterToLastNameTextbox(employeeData.getLastname());
		log.info("Add New Employee - Step 05: Get 'Employee ID'");
		employeeID = addEmployeePage.getEmployeeID();
		System.out.println("employee ID: " + employeeID);
		log.info("Add New Employee - Step 06: Click to 'Create Login Details' checkbox");
		addEmployeePage.clickToCreateLoginDetailsCheckbox();
		log.info("Add New Employee - Step 07: Enter 'User Name' textbox");
		addEmployeePage.enterToUserNameTextbox(employeeData.getEmail());
		log.info("Add New Employee - Step 08: Enter 'Password' textbox");
		addEmployeePage.enterToPasswordTextbox(employeeData.getPassword());
		log.info("Add New Employee - Step 09: Enter 'Confirm Password' textbox");
		addEmployeePage.enterToConfirmPasswordTextbox(employeeData.getPassword());
		log.info("Add New Employee - Step 10: Select 'Status' dropdown");
		addEmployeePage.selectStatusInDropdown(employeeData.getStatusdropdown());
		log.info("Add New Employee - Step 11: Click to 'Save' button");
		personalDetailsPage =  addEmployeePage.clickToSaveButton();
		log.info("Add New Employee - Step 12: Open 'Employee List' page");
		employeeListPage = personalDetailsPage.openEmployeeListPage();
		log.info("Add New Employee - Step 13: Enter valid info to 'Employee Name' textbox");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		employeeListPage.enterToEmployeeNameTextbox(employeeData.getFullname());
		log.info("Add New Employee - Step 14: Click to 'Search' button");
		employeeListPage.clickToSearchButton();
		log.info("Add New Employee - Step 15: Verify 'Employee Information' displayed");
		verifyTrue(employeeListPage.isFirstNameDisplayed(employeeData.getFirstname()));
		verifyTrue(employeeListPage.isLastNameDisplayed(employeeData.getLastname()));
		verifyTrue(employeeListPage.isEmployeeIDDisplayed(employeeID));
	}

	
	public void Employee_02_Upload_Avatar() {
		log.info("Upload_Avatar - Step 01: Click to Logout link");
		loginPage = employeeListPage.logOutToSytem(driver);
		log.info("Upload_Avatar - Step 02: Login with Employee Information: Username: "+employeeData.getUsername());
		dashboardPage = loginPage.loginToSystem(employeeData.getUsername(), employeeData.getPassword());
		log.info("Upload_Avatar - Step 03: Open My Info Page " );
		dashboardPage.openMenuHeaderByName(driver, "My Info");
		myInfoPage = PageGenerator.getMyInfoPage(driver);
		
		
	}

	@Test
	public void Employee_03_Personal_Details() {

	}

	@Test
	public void Employee_04_Contact_Details() {

	}

	@Test
	public void Employee_05_Assign_Dependents() {

	}

	@Test
	public void Employee_06_Assign_Dependents() {

	}

	@Test
	public void Employee_07_Edit_View_Jobs() {

	}

	@Test
	public void Employee_08_Edit_View_Salary() {

	}

	@Test
	public void Employee_09_Edit_View_Tax() {

	}

	@Test
	public void Employee_10_Qualifications() {

	}

	@Test
	public void Employee_11_Search_Employee() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	LoginPageObject loginPage;
	AddEmployeePageObject addEmployeePage;
	DashboardPageObject dashboardPage;
	EmployeeListPageObject employeeListPage;
	PersonalDetailsPageObject personalDetailsPage;
	MyInfoPageObject myInfoPage;
	EmployeeData employeeData;
}
