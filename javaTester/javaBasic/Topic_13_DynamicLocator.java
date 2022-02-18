package javaBasic;

import org.openqa.selenium.By;

import pageUIs.nopCommerce.user.UserBasePageUI;

public class Topic_13_DynamicLocator {

	public static String REGISTER_LINK = "//a[@class='ico-register']";
	public static String LOGIN_LINK = "//a[@class='ico-login']";
	public static String LOGOUT_LINK = "//a[@class='ico-logout']";
	public static String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
	public static String DYNAMIC_LOCATOR = "//a[@class='%s']";

	public static void main(String[] args) {

//		clickToTopLink(DYNAMIC_LOCATOR, "ico-register");
//		clickToTopLink(DYNAMIC_LOCATOR, "ico-login");
//		clickToTopLink(DYNAMIC_LOCATOR, "ico-logout");
//		clickToTopLink(DYNAMIC_LOCATOR, "ico-account");
//		
//		System.out.println(getLocatorByDynamic("New Locator: " + UserBasePageUI.DYNAMIC_LOCATOR_PAGE,"Addresses"));

		System.out.println(getByLocator("xpath=//a[@class='ico-account']"));
		System.out.println(getByLocator("css=a[class='ico-account']"));
		System.out.println(getByLocator("class=ico-account"));
		System.out.println(getByLocator("id=ico-account"));
		System.out.println(getByLocator("name=account"));

	}

	public static String getLocatorByDynamic(String dynamicLocator, String... pageName) {

		String locator = String.format(dynamicLocator, (Object[]) pageName);

		return locator;
	}

	public static By getByLocator(String locatorType) {
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
	
	

	public static void clickToTopLink(String dynamicLocator, String className) {

		String locator = String.format(dynamicLocator, className);
		System.out.println(locator);

	}

	public static void clickToTopLinks(String dynamicLocator, String... params) {

		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println(locator);

	}
}
