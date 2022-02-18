package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.nopCommerce.BasePageFactory;

public class HomePageObject extends BasePageFactory {
	WebDriver driver;
public HomePageObject(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@CacheLookup
	@FindBy(xpath="//a[@class='ico-login']")
	private WebElement loginLink;
	
	@CacheLookup
	@FindBy(css = "a[class='ico-account']")
	private WebElement myAccountLink;
	
	public void clickToRegisterLink() {
		
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}
	
public void clickToLoginLink() {
		
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

public void clickToMyAccountLink() {
	
	waitForElementClickable(driver, myAccountLink);
	clickToElement(driver, myAccountLink);
}
}
