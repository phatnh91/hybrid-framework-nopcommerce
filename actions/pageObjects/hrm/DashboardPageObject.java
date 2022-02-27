package pageObjects.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import commons.nopCommerce.BasePage;
import pageUIs.hrm.DashboardPageUI;

public class DashboardPageObject extends BasePage {
	private WebDriver driver;
	Actions action;

	public DashboardPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public EmployeeListPageObject openEmployeeListPage() {
		action = new Actions(driver);
		action.moveToElement(getWebElement(driver, DashboardPageUI.PIM_SECTION)).perform();
		waitForElementVisible(driver, DashboardPageUI.EMPLOYEE_LIST);
		clickToElement(driver, DashboardPageUI.EMPLOYEE_LIST);
		return PageGenerator.getEmployeeListPage(driver);
	}

}
