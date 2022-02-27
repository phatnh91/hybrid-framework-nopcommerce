package pageObjects.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.nopCommerce.BasePage;
import pageUIs.saucelab.homePageUI;

public class homePageObject extends BasePage {
	WebDriver driver;
	

	public homePageObject(WebDriver driver) {

		this.driver = driver;

	}
	
	public void selectSortDropDownByText(String sortType) {
		
		waitForElementClickable(driver, homePageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdownByVisibleText(driver, homePageUI.SORT_DROPDOWN, sortType);
	}
	
	public List<String> getItemNames() {
		waitForElementVisible(driver, homePageUI.ITEM_NAMES);
		List<WebElement> itemNameElements = getListWebElement(driver, homePageUI.ITEM_NAMES);
		List<String> itemNameText = new ArrayList<String>();
		for (WebElement itemName : itemNameElements) {
			itemNameText.add(itemName.getText());
		}
		
		return itemNameText;
		
	}
	
	public boolean isProductNameSortAscending() {
		
		List<String> itemNameTextClone = new ArrayList<String>(getItemNames());
		Collections.sort(itemNameTextClone);
		return getItemNames().equals(itemNameTextClone);
	}
	
	public boolean isProductNameSortDescending() {
		List<String> itemNameTextClone = new ArrayList<String>(getItemNames());
		Collections.sort(itemNameTextClone);
		Collections.reverse(itemNameTextClone);
		return getItemNames().equals(itemNameTextClone);
	}
	
	public List<Float> getItemPrices() {
		waitForElementVisible(driver, homePageUI.ITEM_PRICES);
		List<WebElement> itemPriceElements = getListWebElement(driver, homePageUI.ITEM_PRICES);
		List<Float> itemPrices = new ArrayList<Float>();
		for (WebElement itemPrice : itemPriceElements) {
			Float productPriceNumber = Float.parseFloat(itemPrice.getText().replace("$", ""));
			itemPrices.add(productPriceNumber);
		}
		
		return itemPrices;
		
	}
	
	public boolean isProductPriceSortAscending() {
		List<Float> itemPriceClone = new ArrayList<Float>(getItemPrices());
		Collections.sort(itemPriceClone);
		return getItemPrices().equals(itemPriceClone);
	}
	
	public boolean isProductPriceSortDescending() {
		List<Float> itemPriceClone = new ArrayList<Float>(getItemPrices());
		Collections.sort(itemPriceClone);
		Collections.reverse(itemPriceClone);
		return getItemPrices().equals(itemPriceClone);
	}
	
	
}
