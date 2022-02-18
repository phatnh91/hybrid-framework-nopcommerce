package pageObjects.jquery;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetElementDisplayed;

import commons.nopCommerce.BasePage;
import commons.nopCommerce.GlobalConstants;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	
	private WebDriver driver;
	
	public HomePageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void openPageNumber(Integer pageNumber) {
		
		waitForElementClickableByDynamicLocator(driver, HomePageUI.DYNAMIC_PAGE_NUMBER, String.valueOf(pageNumber));
		clickToElementByDynamicLocator(driver, HomePageUI.DYNAMIC_PAGE_NUMBER, String.valueOf(pageNumber));
		
	}
	
	public List<String> getAllRowData(){
		
		int totalPageNumber = getElementsSize(driver, "//ul[@class='qgrd-pagination-ul']/li");
		List<String> allRowData = new ArrayList<String>();
		for (int i = 1; i <= totalPageNumber; i++) {
			clickToElementByDynamicLocator(driver, "//ul[@class='qgrd-pagination-ul']/li[%s]", String.valueOf(i));
			
			List<WebElement> dataEachPage =  getListWebElement(driver, "//table//tr");
			for(WebElement row: dataEachPage) {
				
				System.out.println("-------------------------------------------------------");
				System.out.println(row.getText());
				allRowData.add(row.getText());
			}
			
		}
		return allRowData;
		
		
	}
	
	public boolean isImageLoaded(String fileName) {
		
		waitForElementVisibleByDynamicLocator(driver, HomePageUI.IMAGE_LOADED, fileName);
		return getWebElementByDynamicLocator(driver,HomePageUI.IMAGE_LOADED, fileName).isDisplayed();
		
		
	}
	
	
	
	
	public boolean isImageUploaded(String fileName) {
		
		return isImageLoaded(driver, HomePageUI.IMAGE_UPLOADED, fileName);
		
	}
	
	
	public void clickToStartButton() {
		
		waitForElementVisible(driver, HomePageUI.START_BUTTONS);
		
		List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_BUTTONS);
		for(WebElement startButton: startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
		
		
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String valueTextbox) {
		
		int columnIndex = getElementsSize(driver, getLocatorByDynamic(HomePageUI.COLUMN_NAME, columnName)) + 1;
		waitForElementVisibleByDynamicLocator(driver,HomePageUI.TEXTBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX,rowNumber,String.valueOf(columnIndex));
		sendKeysToElementByDynamicLocator(driver, HomePageUI.TEXTBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX, valueTextbox, rowNumber,String.valueOf(columnIndex));
	}

	public void selectToDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueDropdown) {
		int columnIndex = getElementsSize(driver, getLocatorByDynamic(HomePageUI.COLUMN_NAME, columnName)) + 1;
		
		waitForElementClickableByDynamicLocator(driver, HomePageUI.DROPDOWN_BY_ROW_NUMBER_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdownByDynamicLocator(driver, HomePageUI.DROPDOWN_BY_ROW_NUMBER_AND_COLUMN_INDEX, valueDropdown, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToAccountHeaderLink() {
		
		waitForElementClickable(driver, HomePageUI.ACCOUNT_HEADER_LINK);
		clickToElement(driver, HomePageUI.ACCOUNT_HEADER_LINK);
		
	}

	public RegisterPageObject clickToRegisterLink() {
		
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
		
	}

	public void clickToCreateNewAccountButton() {
		waitForElementVisible(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
		
	}

	public boolean isSignUpTitleDisplayed() {
		waitForElementVisible(driver, HomePageUI.SIGN_UP_TITLE);
		return getWebElement(driver, HomePageUI.SIGN_UP_TITLE).isDisplayed();
	}

	public void clickToCloseIcon() {
		waitForElementVisible(driver, HomePageUI.CLOSE_ICON);
		clickToElement(driver, HomePageUI.CLOSE_ICON);
		
	}

	public boolean isSignUpTitleUndisplayed() {
		
		return checkElementUndisplayed(driver, HomePageUI.SIGN_UP_TITLE);
	}
	
	
	

}
