package pageObjects.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import commons.nopCommerce.BasePage;
import pageUIs.hrm.DashboardPageUI;

public class PersonalDetailsPageObject extends BasePage {
	private WebDriver driver;
	Actions action;

	public PersonalDetailsPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public EmployeeListPageObject openEmployeeListPage() {
		action = new Actions(driver);
		action.moveToElement(getWebElement(driver, DashboardPageUI.PIM_SECTION)).click(getWebElement(driver, DashboardPageUI.EMPLOYEE_LIST)).perform();
		return PageGenerator.getEmployeeListPage(driver);
	}

}
