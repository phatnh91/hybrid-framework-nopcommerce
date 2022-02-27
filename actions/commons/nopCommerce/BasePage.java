package commons.nopCommerce;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.hrm.LoginPageObject;
import pageObjects.hrm.PageGenerator;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserPageGeneratorManager;
import pageObjects.nopCommerce.user.UserPasswordPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageUIs.hrm.BasePageUI;
import pageUIs.nopCommerce.user.UserBasePageUI;

public class BasePage {

	public static BasePage getBasePageObject() {

		return new BasePage();

	}

	public void openPageUrl(WebDriver driver, String pageUrl) {

		driver.get(pageUrl);

	}

	public String getPageTitle(WebDriver driver) {

		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {

		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {

		return driver.getPageSource();
	}

	public void backtoPage(WebDriver driver) {

		driver.navigate().back();
	}

	public void forwardtoPage(WebDriver driver) {

		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {

		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {

		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {

		return waitForAlertPresence(driver).getText();
	}

	public void sendKeysToAlert(WebDriver driver, String textValue) {

		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindowByUrl(WebDriver driver, String url) {

		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().equals(url)) {

				break;
			}
		}

	}

	public void closeAllChildWindows(WebDriver driver, String parentID) {

		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);

			if (!window.equals(parentID)) {

				driver.close();
			}

		}

		driver.switchTo().window(parentID);

	}

	public void swithToWindowByTitle(WebDriver driver, String pageTitle) {

		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);

			String actualTitle = driver.getTitle().trim();
			if (actualTitle.contains(pageTitle)) {

				break;
			}

		}

	}

	public By getByXpath(String xpathLocator) {

		return By.xpath(xpathLocator);
	}

	public WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(By.xpath(xpathLocator));

	}

	public WebElement getWebElementByDynamicLocator(WebDriver driver, String DynamicLocator, String... dynamicValues) {
		return driver.findElement(By.xpath(getLocatorByDynamic(DynamicLocator, dynamicValues)));

	}

	public List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElements(By.xpath(xpathLocator));

	}

	public void clickToElement(WebDriver driver, String xpathLocator) {

		getWebElement(driver, xpathLocator).click();
	}

	public void clickToElementByDynamicLocator(WebDriver driver, String DynamicLocator, String pageName) {

		getWebElement(driver, getLocatorByDynamic(DynamicLocator, pageName)).click();
	}

	public BasePage openPagesAtMyAccount(WebDriver driver, String pageName) {

		waitForElementClickableByDynamicLocator(driver, UserBasePageUI.DYNAMIC_LOCATOR_PAGE, pageName);
		clickToElementByDynamicLocator(driver, UserBasePageUI.DYNAMIC_LOCATOR_PAGE, pageName);
		switch (pageName) {
		case "Customer info":

			return UserPageGeneratorManager.getCustomerInfoPage(driver);
		case "Addresses":

			return UserPageGeneratorManager.getAddressesPage(driver);
		case "Reward points":

			return UserPageGeneratorManager.getRewardPointPage(driver);
		case "Change password":

			return UserPageGeneratorManager.getPasswordPage(driver);

		default:
			throw new RuntimeException("The page name is invalid");
		}

	}

	public void sendKeysToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendKeysToElementByDynamicLocator(WebDriver driver, String dynamicLocator, String textValue,
			String... dynamicValues) {
		WebElement element = getWebElement(driver, getLocatorByDynamic(dynamicLocator, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}

	public void selectItemInDefaultDropdownByValue(WebDriver driver, String xpathLocator, String textItem) {

		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textItem);

	}

	public void selectItemInDefaultDropdownByVisibleText(WebDriver driver, String xpathLocator, String textItem) {

		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByVisibleText(textItem);

	}

	public void selectItemInDefaultDropdownByDynamicLocator(WebDriver driver, String dynamicLocator, String textItem,
			String... dynamicValues) {

		Select select = new Select(getWebElement(driver, getLocatorByDynamic(dynamicLocator, dynamicValues)));
		select.selectByVisibleText(textItem);

	}

	public String getFirstSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();

	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}

	public void selectItemEditableDropdown(WebDriver driver, String parentXpath, String childXpath,
			String expectedValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		WebElement element = getWebElement(driver, parentXpath);
		element.clear();
		sleepInSecond(1);
		element.sendKeys(expectedValue);
		sleepInSecond(2);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
		List<WebElement> itemList = driver.findElements(getByXpath(childXpath));

		for (WebElement items : itemList) {

			if (items.getText().equals(expectedValue)) {

				if (items.isDisplayed()) {
					items.click();
				} else {

					System.out.println("There is no result found");
				}

				break;
			}

		}
	}

	public void selectItemDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		getWebElement(driver, parentXpath).click();
		;
		sleepInSecond(2);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
		List<WebElement> itemList = driver.findElements(getByXpath(childXpath));

		for (WebElement item : itemList) {
			if (item.getText().trim().equals(expectedValue)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}

		}
	}

	public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {

		return getWebElement(driver, xpathLocator).getAttribute(attributeName);

	}

	public String getElementText(WebDriver driver, String xpathLocator) {

		return getWebElement(driver, xpathLocator).getText();
	}

	public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {

		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}

	public String convertRgbaToHex(String rgbdValue) {
		return Color.fromString(rgbdValue).asHex();
	}

	public int getElementsSize(WebDriver driver, String xpathLocator) {

		return getListWebElement(driver, xpathLocator).size();
	}

	public int getElementsSize(WebDriver driver, String dynamicLocator, String... dynamicValues) {

		return getListWebElement(driver, getLocatorByDynamic(dynamicLocator, dynamicValues)).size();
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {

		return getWebElement(driver, xpathLocator).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String xpathLocator) {

		return getWebElement(driver, xpathLocator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String xpathLocator) {

		return getWebElement(driver, xpathLocator).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {

		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}

	public void switchToDefaultContent(WebDriver driver) {

		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void hightlightElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	public void scrollToElementOnTop(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}

	public void scrollToElementOnDown(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, xpathLocator));
	}

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		}
		return false;
	}

	public boolean isImageLoaded(WebDriver driver, String dynamicLocator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, getLocatorByDynamic(dynamicLocator, dynamicValues)));
		if (status) {
			return true;
		}
		return false;
	}

	public boolean checkElementUndisplayed(WebDriver driver, String xpathLocator) {
		boolean status = false;
		changeImplicitwait(driver, GlobalConstants.SHORT_TIMEOUT);
		List<WebElement> elements = driver.findElements(By.xpath(xpathLocator));
		changeImplicitwait(driver, GlobalConstants.LONG_TIMEOUT);

		if (elements.size() == 0) {
			status = true;
		} else if (elements.size() > 0 && !elements.get(1).isDisplayed()) {
			status = true;
		} else {
			status = false;
			throw new RuntimeException("The element is displayed");
		}

		return status;

	}

	private void changeImplicitwait(WebDriver driver, long timeOut) {

		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);

	}

	public By getByLocator(String locatorType) {
		By by = null;

		if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")) {
			by = By.xpath(locatorType.substring(6));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {

			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID=")) {
			by = By.id(locatorType.substring(3));

		} else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=")
				|| locatorType.startsWith("CLASS=")) {
			by = By.className(locatorType.substring(6));

		} else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=")
				|| locatorType.startsWith("NAME=")) {
			by = By.name(locatorType.substring(5));

		} else {

			throw new RuntimeException("The locator is not valid");
		}

		return by;

	}

	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	public void waitForElementVisibleByDynamicLocator(WebDriver driver, String dynamicLocator,
			String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(getLocatorByDynamic(dynamicLocator, dynamicValues))));
	}

	public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}

	public void waitForAllElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}

	public void waitForElementClickableByDynamicLocator(WebDriver driver, String dynamicLocator, String... pageName) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(getLocatorByDynamic(dynamicLocator, pageName))));
	}

	public void waitForElementPresence(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByXpath(xpathLocator)));
	}

	public UserCustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {

		waitForAllElementVisible(driver, UserBasePageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, UserBasePageUI.CUSTOMER_INFO_LINK);
		return UserPageGeneratorManager.getCustomerInfoPage(driver);

	}

	public UserAddressPageObject openAddressesPage(WebDriver driver) {

		waitForAllElementVisible(driver, UserBasePageUI.ADDRESSES_LINK);
		clickToElement(driver, UserBasePageUI.ADDRESSES_LINK);
		return UserPageGeneratorManager.getAddressesPage(driver);

	}

	public UserRewardPointPageObject openRewardPointsPage(WebDriver driver) {

		waitForAllElementVisible(driver, UserBasePageUI.REWARD_POINTS_LINK);
		clickToElement(driver, UserBasePageUI.REWARD_POINTS_LINK);
		return UserPageGeneratorManager.getRewardPointPage(driver);

	}

	public UserPasswordPageObject openPasswordPage(WebDriver driver) {

		waitForAllElementVisible(driver, UserBasePageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, UserBasePageUI.CHANGE_PASSWORD_LINK);
		return UserPageGeneratorManager.getPasswordPage(driver);

	}

	public String getLocatorByDynamic(String dynamicLocator, String... dynamicValues) {

		dynamicLocator = String.format(dynamicLocator, (Object[]) dynamicValues);

		return dynamicLocator;
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {

		String filePath = GlobalConstants.PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		sendKeysToElement(driver, UserBasePageUI.UPLOAD_FILE, fullFileName);
	}

	public Set<Cookie> getAllCookies(WebDriver driver) {

		return driver.manage().getCookies();
	}

	public LoginPageObject logOutToSytem(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.WELCOME_ICON);
		clickToElement(driver, BasePageUI.WELCOME_ICON);
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK);
		clickToElement(driver, BasePageUI.LOGOUT_LINK);
		return PageGenerator.getLoginPage(driver);

	}

	public void openMenuHeaderByName(WebDriver driver, String menuName) {
		waitForElementClickableByDynamicLocator(driver, BasePageUI.DYNAMIC_MENU_PAGE, menuName);
		clickToElementByDynamicLocator(driver, BasePageUI.DYNAMIC_MENU_PAGE, menuName);
	}

	public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
	}

	public boolean isJQueryAjaxLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};
		return explicitWait.until(jQueryLoad);
	}

	public static int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

	public boolean isDataDateSortedAscending(WebDriver driver, String xpathLocator) {
		ArrayList<Date> arrayList = new ArrayList<Date>();

		List<WebElement> elementList = driver.findElements(By.xpath(xpathLocator));
		for (WebElement element : elementList) {

			arrayList.add(convertStringToDate(element.getText()));

		}

		ArrayList<Date> sortedList = new ArrayList<Date>();
		for (Date child : arrayList) {
			sortedList.add(child);
		}
		Collections.sort(sortedList);
		return arrayList.equals(sortedList);
	}

	public boolean isDataDateSortedDescending(WebDriver driver, String xpathLocator) {
		ArrayList<Date> arrayList = new ArrayList<Date>();

		List<WebElement> elementList = driver.findElements(By.xpath(xpathLocator));
		for (WebElement element : elementList) {

			arrayList.add(convertStringToDate(element.getText()));

		}

		ArrayList<Date> sortedList = new ArrayList<Date>();
		for (Date child : arrayList) {
			sortedList.add(child);
		}
		Collections.sort(sortedList);
		Collections.reverse(sortedList);

		return arrayList.equals(sortedList);
	}

	public Date convertStringToDate(String dateInString) {
		dateInString = dateInString.replace(",", "");
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public String getRandomEmail() {
		return "phatnguyen" + getRandomNumberByDateTime() + "@qa.team";
	}

	private long getRandomNumberByDateTime() {
		return Calendar.getInstance().getTimeInMillis() % 100000;
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private int longTimeout = 30;
}
