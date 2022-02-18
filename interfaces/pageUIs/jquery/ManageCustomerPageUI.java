package pageUIs.jquery;

public class ManageCustomerPageUI {

	public static final String EMAIL_HEADER_TEXTBOX = "//input[@name='email']";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "//a[@name='%s']/parent::span/parent::th/preceding-sibling::th";
	public static final String VALUE_BY_ROW_NUMBER_AND_COLUMN_INDEX = "//div[@class='grid']//tbody/tr[%s]/td[%s]";
	public static final String EMAIL_AT_THE_FIRST_ROW = "//div[@class='grid']//tbody/tr[1]/td[4]";
	public static final String ALERT_POPUP = "//div[@id='message-popup-window']";
	public static final String CLOSE_BUTTON_ON_POPUP = "//div[@id='message-popup-window']//span[text()='close']";
}
