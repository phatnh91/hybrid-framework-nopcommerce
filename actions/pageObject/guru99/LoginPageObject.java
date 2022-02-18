package pageObject.guru99;

import org.openqa.selenium.WebDriver;

import commons.guru99.BasePage;
import pageUIs.guru99.HomePageUI;

public class LoginPageObject extends BasePage {
	
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
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
	

}
