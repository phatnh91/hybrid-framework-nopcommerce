package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register_RY {
	WebDriver driver;
	String emailAddress;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		driver.get("https://demo.nopcommerce.com/");
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.id("register-button")).click();
		Assert.assertEquals(driver.findElement(By.id("FirstName-error")).getText(), "First name is required.");
		Assert.assertEquals(driver.findElement(By.id("LastName-error")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.id("Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.id("Password-error")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		

		driver.findElement(By.id("FirstName")).sendKeys("Phat");
		driver.findElement(By.id("LastName")).sendKeys("Nguyen");
		driver.findElement(By.id("Email")).sendKeys("abc@3424!#!");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.id("register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.id("Email-error")).getText(), "Wrong email");

	}
	@Test
	public void TC_03_Register_Password_Less_Than_6_Chars() {
		emailAddress = "phatnguyen" + getRandomNumber() + "@qa.team";
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("123");
		driver.findElement(By.id("ConfirmPassword")).clear();
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123");
		
		driver.findElement(By.id("register-button")).click();
		Assert.assertEquals(driver.findElement(By.id("Password-error")).getText(), "Password must meet the following rules:\nmust have at least 6 characters");
		
		
		
	}

	@Test
	public void TC_04_Register_Invalid_Confirm_Password() {
		
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("ConfirmPassword")).clear();
		driver.findElement(By.id("ConfirmPassword")).sendKeys("654321");
		
		driver.findElement(By.id("register-button")).click();
		Assert.assertEquals(driver.findElement(By.id("ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");
	}
	
	@Test
	public void TC_05_Register_Success() {
		
		
		

		driver.findElement(By.id("ConfirmPassword")).clear();
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.id("register-button")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div.result")).getText().equals("Your registration completed"));

	}

	@Test
	public void TC_06_Register_Existing_Email() {
		
		driver.findElement(By.cssSelector("a.ico-logout")).click();
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Phat");
		driver.findElement(By.id("LastName")).sendKeys("Nguyen");
		driver.findElement(By.id("Email")).sendKeys(emailAddress);
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.id("register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.master-wrapper-content ul>li")).getText(),"The specified email already exists");
		
	}

	

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
