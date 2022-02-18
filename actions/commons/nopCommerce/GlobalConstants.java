package commons.nopCommerce;

import java.io.File;

import org.testng.annotations.Test;

public class GlobalConstants {
	
	public static final String PROJECT_URL = "https://demo.nopcommerce.com/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadfiles";
	public static final String FIRST_NAME = "Phat";
	public static final String LAST_NAME = "Nguyen";
	public static final String EMAIL = "phatnguyen"+ BasePage.getRandomNumber() +"@qa.team";
	public static final String PASSWORD = "123456";
	public static final String ADMIN_PAGE = "http://live.techpanda.org/index.php/backendlogin/customer/";
	public static final String ADMIN_USERNAME = "user01";
	public static final String ADMIN_PASSWORD = "guru99com";
	public static final long LONG_TIMEOUT = 30;
	public static final long SHORT_TIMEOUT = 5;
	
	
	

}
