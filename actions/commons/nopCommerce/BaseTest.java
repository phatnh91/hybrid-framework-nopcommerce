package commons.nopCommerce;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected Log log;

	protected BaseTest() {

		log = LogFactory.getLog(getClass());
	}

	public WebDriver getDriver() {

		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String pageUrl) {

		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.PROJECT_PATH +File.separator + "browserLogs" + File.separator+ "FirefoxLog.txt");
			driver = new FirefoxDriver();
			
		}
//		else 
//			if (browserName.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxProfile profile = new FirefoxProfile();
//			File extensionFile = new File(GlobalConstants.PROJECT_PATH +File.separator +"browserExtensions"+ File.separator+"selectorshub-4.3.2-fx.xpi");
//			profile.addExtension(extensionFile);
//			FirefoxOptions options = new FirefoxOptions();
//			options.setProfile(profile);
//			driver = new FirefoxDriver(options);
//		} 
		else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// Browser options: Selenium > 3. version
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		}
			else if (browserName.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.args","--disable-logging");
			System.setProperty("webdriver.chrome.silentOutput","true");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-geolocation");
			options.addArguments("--disable-notifications");
			Map<String, Object>prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service",false);
			prefs.put("profile.password_manager_enabled",false);
			options.setExperimentalOption("prefs", prefs);
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			driver = new ChromeDriver(options);

		}

//		else if (browserName.equals("chrome")) {
//			
//			WebDriverManager.chromedriver().setup();
//			File file = new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\selectors-hub.crx");
//			ChromeOptions options = new  ChromeOptions();
//			options.addExtensions(file);
//			driver = new ChromeDriver(options);
//
//		} 
		else if (browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		} else if (browserName.equals("coccoc")) {
			WebDriverManager.chromedriver().driverVersion("97.0.4692.71").setup();
			//Coccoc version - 6 = chrome driver version.
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		}else {
			throw new RuntimeException("Browser name is invalid");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(pageUrl);
		return driver;
	}

	@BeforeTest
	public void deleteAllFilesInReportNGScreenshot() {
		log.info("---------- START delete file in folder ----------");
		deleteAllFileInFolder();
		log.info("---------- END delete file in folder ----------");
	}

	public void deleteAllFileInFolder() {
		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = workingDir + File.separator + "ReportNGScreenshots";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {

					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {

			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {

			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected void cleanDriverInstance() {
		String osName = System.getProperty("os.name").toLowerCase();
		log.info("OS name: " + osName);
		String cmd = "";
		try {
			log.info("---------------------------- Close Browser and Driver -----------------------------------");

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.contains("mac") || osName.contains("unix") || osName.contains("nux")) {
					cmd = "pkill chromedriver";
				} else if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";

				} else if (driver.toString().toLowerCase().contains("firefox")) {
					if (osName.contains("mac") || osName.contains("unix") || osName.contains("nux")) {
						cmd = "pkill geckodriver";
					} else if (osName.contains("windows")) {
						cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";

					}

				} else if (driver.toString().toLowerCase().contains("edge")) {
					if (osName.contains("mac") || osName.contains("unix") || osName.contains("nux")) {
						cmd = "pkill msedgedriver";
					} else if (osName.contains("windows")) {
						cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";

					}

				}

			}
			if (driver != null) {

				driver.manage().deleteAllCookies();
				driver.quit();

			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@AfterSuite
	public void cleanExecutableDriver() {
		
	}

	protected void showBrowserConsoleLogs(WebDriver driver) {
		
		if(driver.toString().contains("chrome")) {
			LogEntries logs = driver.manage().logs().get("browser");
			List<LogEntry> logList = logs.getAll();
			for(LogEntry logging : logList) {
				System.out.println("-------------------" + logging.getLevel().toString() + "-------------------- \n" + logging.getMessage());
			}
		}
	}
}
