package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.nopCommerce.BasePage;
import pageUIs.hrm.EmployeeListPageUI;


public class EmployeeListPageObject extends BasePage {
	private WebDriver driver;

	public EmployeeListPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public AddEmployeePageObject clickToAddButton() {
		waitForElementVisible(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
		clickToElement(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
		return PageGenerator.getAddEmployeePage(driver);
	}

	public void enterToEmployeeNameTextbox(String firstName) {
		
		waitForAllElementInvisible(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX_LOADING);
		waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX);
		sendKeysToElement(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX, firstName);

	}

	public void clickToSearchButton() {
		waitForElementVisible(driver, EmployeeListPageUI.SEARCH_BUTTON);
		clickToElement(driver, EmployeeListPageUI.SEARCH_BUTTON);

	}
	
	/**
	 * Get the first text in the first row in the column index by Name
	 * @author Phat Nguyen
	 *@param Column Name
	 *@return the first name at the first row
	 */
	public String getFirstTextInColumnName(String columnName) {

		int columnIndex = getListWebElement(driver,
				getLocatorByDynamic(EmployeeListPageUI.COLUMN_INDEX_BY_NAME, columnName)).size() + 1;

		String text = getElementText(driver,
				getLocatorByDynamic(EmployeeListPageUI.TEXTBOX_BY_COLUMN_INDEX, String.valueOf(columnIndex)));
		System.out.println(text);
		return text;
		
	}

	public boolean isFirstNameDisplayed(String firstName) {
		return getFirstTextInColumnName("First (& Middle) Name").equals(firstName);
	}
	
	public boolean isLastNameDisplayed(String lastName) {
		return getFirstTextInColumnName("Last Name").equals(lastName);
	}
	
	public boolean isEmployeeIDDisplayed(String employeeID) {
		return getFirstTextInColumnName("Id").equals(employeeID);
	}

}
