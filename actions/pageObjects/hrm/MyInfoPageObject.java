package pageObjects.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import commons.nopCommerce.BasePage;

public class MyInfoPageObject extends BasePage {
	private WebDriver driver;
	Actions action;

	public MyInfoPageObject(WebDriver driver) {

		this.driver = driver;
	}

	

}
