package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_02_Data_Type_Excercise {

	@Test
	public void TC_01() {
		int a = 6;
		int b = 2;
		
		System.out.println("Tổng của a và b là: " + (a + b));
		System.out.println("Hiệu của a và b là: " + (a - b));
		System.out.println("Tích của a và b là: " + a*b);
		System.out.println("Thương của a và b là: = " + a/b);
		
	}
	
	@Test
	public void TC_02() {
		float width = 7.5f;
		float height = 3.8f;
		
		System.out.println("Diện tích của hình chữ nhật là: " + width*height);
		
		
	}
	
	@Test
	public void TC_03() {
		String name = "Automation Testing";
		
		System.out.println("Hello " + name);
		
		
	}


}
