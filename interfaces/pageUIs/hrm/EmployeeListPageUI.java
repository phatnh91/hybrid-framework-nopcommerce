package pageUIs.hrm;

public class EmployeeListPageUI {

	public static final String ADD_EMPLOYEE_BUTTON = "//input[@id='btnAdd']";
	public static final String EMPLOYEE_NAME_TEXTBOX = "//input[@id='empsearch_employee_name_empName']";
	public static final String EMPLOYEE_NAME_TEXTBOX_LOADING = "//input[@id='empsearch_employee_name_empName' and @class='ac_loading']";
	public static final String SEARCH_BUTTON = "//input[@id='searchBtn']";
	public static final String COLUMN_INDEX_BY_NAME = "//table//a[text()='%s']/parent::th/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_INDEX = "//table/tbody//td[%s]/a";
}
