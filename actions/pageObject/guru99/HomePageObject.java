package pageObject.guru99;

import org.openqa.selenium.WebDriver;

import commons.guru99.BasePage;
import pageUIs.guru99.HomePageUI;

public class HomePageObject extends BasePage {
	
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToAccountLabel() {
		
		waitForElementClickable(driver, HomePageUI.ACCOUNT_LABEL);
		clickToElement(driver, HomePageUI.ACCOUNT_LABEL);
		
	}
	public RegisterPageObject clickToRegisterLink() {
		
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	

}
