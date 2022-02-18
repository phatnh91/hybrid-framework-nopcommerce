package pageObject.guru99;

import org.openqa.selenium.WebDriver;

import commons.guru99.BasePage;
import pageUIs.guru99.HomePageUI;
import pageUIs.guru99.MyDashboardUI;

public class MyDashboardPageObject extends BasePage {
	
	WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToAccountLabel() {
		
		waitForElementClickable(driver, HomePageUI.ACCOUNT_LABEL);
		clickToElement(driver, HomePageUI.ACCOUNT_LABEL);
		
	}
	public void clickToRegisterLink() {
		
		waitForElementClickable(driver, HomePageUI.ACCOUNT_LABEL);
		clickToElement(driver, HomePageUI.ACCOUNT_LABEL);
		PageGeneratorManager.getRegisterPage(driver);
	}
	
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, MyDashboardUI.THANKYOU_MESSAGE);
	
		return getElementText(driver, MyDashboardUI.THANKYOU_MESSAGE);
	}
	

}
