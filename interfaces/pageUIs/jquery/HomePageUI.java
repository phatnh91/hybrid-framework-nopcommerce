package pageUIs.jquery;

public class HomePageUI {

	public static final String DYNAMIC_PAGE_NUMBER = "//li[@class='qgrd-pagination-page']/a[text()=%s]";

	public static final String COLUMN_NAME = "//table//td[text()='%s']/preceding-sibling::td";
	public static final String TEXTBOX_BY_ROW_NUMBER_AND_COLUMN_INDEX = "//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_ROW_NUMBER_AND_COLUMN_INDEX = "//tbody/tr[%s]/td[%s]/select";
	
	public static final String ACCOUNT_HEADER_LINK = "//header[@id='header']//span[text()='Account']";
	public static final String REGISTER_LINK = "//div[@id='header-account']//a[@title='Register']";
	public static final String IMAGE_LOADED = "//table//p[@class='name' and text()='%s']";
	public static final String START_BUTTONS = "//button//span[text()='Start']";
	public static final String IMAGE_UPLOADED = "//a[@title='%s']/img";
	public static final String SIGN_UP_TITLE = "//div[text()='Sign Up']";
	public static final String CREATE_NEW_ACCOUNT_BUTTON = "//a[text()='Create New Account']";
	public static final String CLOSE_ICON = "//div[text()='Sign Up']/parent::div/preceding-sibling::img";
	

}
