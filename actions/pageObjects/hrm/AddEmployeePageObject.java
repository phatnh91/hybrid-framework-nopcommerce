package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.nopCommerce.BasePage;
import pageUIs.hrm.AddEmployeePageUI;

public class AddEmployeePageObject extends BasePage {
	private WebDriver driver;

	public AddEmployeePageObject(WebDriver driver) {

		this.driver = driver;
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AddEmployeePageUI.FIRST_NAME_TEXTBOX);
		sendKeysToElement(driver, AddEmployeePageUI.FIRST_NAME_TEXTBOX, firstName);
		
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, AddEmployeePageUI.LAST_NAME_TEXTBOX);
		sendKeysToElement(driver, AddEmployeePageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	public String getEmployeeID() {
		waitForElementVisible(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
		return getElementAttribute(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX,"value");
	}

	public void clickToCreateLoginDetailsCheckbox() {
		waitForElementVisible(driver, AddEmployeePageUI.CREATE_LOGIN_CHECKBOX);
		clickToElement(driver, AddEmployeePageUI.CREATE_LOGIN_CHECKBOX);
		
	}

	public void enterToUserNameTextbox(String userName) {
		waitForElementVisible(driver, AddEmployeePageUI.USERNAME_TEXTBOX);
		sendKeysToElement(driver, AddEmployeePageUI.USERNAME_TEXTBOX, userName);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, AddEmployeePageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, AddEmployeePageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void enterToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, AddEmployeePageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, AddEmployeePageUI.CONFIRM_PASSWORD_TEXTBOX, password);
		
	}

	public void selectStatusInDropdown(String statusDropdown) {
		
		waitForElementVisible(driver, AddEmployeePageUI.STATUS_DROPDOWN);
		selectItemInDefaultDropdownByValue(driver, AddEmployeePageUI.STATUS_DROPDOWN, statusDropdown);
		
	}

	public PersonalDetailsPageObject clickToSaveButton() {
		waitForElementVisible(driver, AddEmployeePageUI.SAVE_BUTTON);
		clickToElement(driver, AddEmployeePageUI.SAVE_BUTTON);
		return PageGenerator.getPersonalDetailsPage(driver);
	}

}
