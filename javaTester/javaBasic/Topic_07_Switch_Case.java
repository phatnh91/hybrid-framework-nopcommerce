package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

//	@Parameters("browser")
	
	public void TC_01_Switch_Case (String browserName) {
		
		driver = getBrowserDriver(browserName);
		System.out.println(browserName);
		driver.quit();
		
	}
	
	public WebDriver getBrowserDriver(String browserName) {
		
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			new RuntimeException("Please input correct the browser name!");
			break;
		}
		
		return driver;
	}
	
	@Test
	public void TC_02() {
		
		int firstNumber;
		int secondNumber;
		String operator;
		Scanner sc = new Scanner(System.in);
		firstNumber = sc.nextInt();
		secondNumber = sc.nextInt();
		operator = sc.next();
		
		switch (operator) {
		case "+":
			System.out.println("A + B = " + (firstNumber + secondNumber));
			break;
		case "-":
			System.out.println("A - B = " + (firstNumber - secondNumber));
			break;
		case "x":
			System.out.println("A x B = " + (firstNumber * secondNumber));
			break;
		case "/":
			System.out.println("A / B = " + (firstNumber / secondNumber));
			break;

		default:
			System.out.println("Nhập sai phép tính");
			break;
		}
	}
}
