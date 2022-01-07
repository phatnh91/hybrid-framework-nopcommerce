package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_05_Primitive_Casting {

	public static void main(String[] args) {
		//Ngầm định =  không mất dữ liệu
	
//		byte bNumber = 127;
//		System.out.println(bNumber);
//
//		short sNumber = bNumber;
//		System.out.println(sNumber);
//
//		int iNumber = sNumber;
//		System.out.println(iNumber);
//
//		long lNumber = iNumber;
//		System.out.println(lNumber);
//
//		float fNumber = lNumber;
//		System.out.println(fNumber);
//
//		double dNumber = fNumber;
//		System.out.println(dNumber);
		
		//Tường minh
		double dNumber = 631262363;
		System.out.println(dNumber);
		
		float fNumber = (float) dNumber;
		System.out.println(fNumber);
		
		long lNumber = (long) fNumber;
		System.out.println(lNumber);
		
		int iNumber = (int) lNumber;
		System.out.println(iNumber);
		

	}
}
