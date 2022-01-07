package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_04_Operator {
	
	public static void main(String[] args) {
		int number = 10;
		
		number +=5; 
		//number = 10 + 5;
		System.out.println(number);
		System.out.println(number/5);
		System.out.println(number % 7);
		
		System.out.println(number++);
		System.out.println(number--);
		
		//System.out.println(++number);
		
		for(int i = 0 ; i < 3 ; i++) {
			System.out.println(i);
		}
		
		String address = "Ha Tinh";
		
		if(address !="ha noi") {
			System.out.println("Address is not the same");
		}
		
		//Tam Nguyên
		boolean status = (address == "Ha Noi") ? true : false;
		System.out.println(status);
	}

}
