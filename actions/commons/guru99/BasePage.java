package commons.guru99;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
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

	public List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElements(By.xpath(xpathLocator));

	}

	public void clickToElement(WebDriver driver, String xpathLocator) {

		getWebElement(driver, xpathLocator).click();
	}

	public void sendKeysToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textItem);

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
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
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
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
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

	public void hightlightElement(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver,xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver,xpathLocator));
	}

	public void scrollToElementOnTop(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver,xpathLocator));
	}

	public void scrollToElementOnDown(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver,xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver,String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver,xpathLocator));
	}

	public String getElementValidationMessageByJS(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver,xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver,xpathLocator));
		if (status) {
			return true;
		}
		return false;
	}
	
	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	
	public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	
	public void waitForAllElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	
	public void waitForElementPresence(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByXpath(xpathLocator)));
	}
	
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
