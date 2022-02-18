package pageObjects.jquery;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commons.nopCommerce.BasePage;
import pageUIs.jquery.HomePageUI;
import pageUIs.jquery.ManageCustomerPageUI;

public class ManageCustomerPageObject extends BasePage {
	
	private WebDriver driver;
	
	
	public ManageCustomerPageObject (WebDriver driver) {
		this.driver = driver;
		
	}

	public void openPageNumber(Integer pageNumber) {
		
		waitForElementClickableByDynamicLocator(driver, HomePageUI.DYNAMIC_PAGE_NUMBER, String.valueOf(pageNumber));
		clickToElementByDynamicLocator(driver, HomePageUI.DYNAMIC_PAGE_NUMBER, String.valueOf(pageNumber));
		
	}
	
	public void sendKeysToEmailTextboxHeaderAndSearch(String emailValue) {
		Actions action = new Actions(driver);
		waitForElementVisible(driver, ManageCustomerPageUI.EMAIL_HEADER_TEXTBOX);
		sendKeysToElement(driver, ManageCustomerPageUI.EMAIL_HEADER_TEXTBOX, emailValue);
		action.sendKeys(Keys.ENTER).perform();
		
	}
	
	public void compareRegisteredEmailDisplayed(String email) {
		
		waitForElementVisible(driver, ManageCustomerPageUI.EMAIL_AT_THE_FIRST_ROW);
		Assert.assertEquals(getWebElement(driver, ManageCustomerPageUI.EMAIL_AT_THE_FIRST_ROW).getText(), email);
		
	}



	
	public void dismissPopup() {
		waitForElementVisible(driver, ManageCustomerPageUI.ALERT_POPUP);
		clickToElement(driver, ManageCustomerPageUI.CLOSE_BUTTON_ON_POPUP);
		
		
	}


	

}
