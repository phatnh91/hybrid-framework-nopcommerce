package pageObjects.saucelab;

import org.openqa.selenium.WebDriver;

public class PageGenerator {

	
	public static loginPageObject getLoginPage(WebDriver driver) {
		
		return new loginPageObject(driver);
		
	}
	
	public static homePageObject getHomePage(WebDriver driver) {
		
		return new homePageObject(driver);
		
	}

}
