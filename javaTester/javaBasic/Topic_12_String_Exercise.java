package javaBasic;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_12_String_Exercise {
	String courseName = "AutoMation 124 TeSting 66 AdvAnced 23";

	
	public void TC_01() {
		char courseNameArray[] = courseName.toCharArray();
		int countUpper = 0;
		int countLower = 0;
		int countNumber = 0;
		for (char character : courseNameArray) {

			if (character <= 'Z' && character >= 'A') {
				countUpper++;

			}
			if (character <= 'z' && character >= 'a') {
				countLower++;

			}

			if (character <= '9' && character >= '0') {
				countNumber++;

			}
		}
		System.out.println("Tổng các chữ cái viết hoa là: " + countUpper);
		System.out.println("Tổng các chữ cái viết thường là: " + countLower);
		System.out.println("Tổng các chữ số là: " + countNumber);

	}
	
	
	public void TC_02() {
		courseName = "Automation Testing 345 Tutorials Online 789";
		char courseNameArray[] = courseName.toCharArray();
		int countA = 0;
		int countNumber = 0;
		for (char c : courseNameArray) {
			if(c=='a') {
				countA++;
			}
			if(c<='9' && c>='0') {
				countNumber++;
			}
		}
		System.out.println("Tổng số chữ cái a là: " +countA);
		System.out.println("Course Name có chứa từ Testing hay không? " +courseName.contains("Testing"));
		System.out.println("Course Name có bắt đầu từ Automation: " +courseName.startsWith("Automation"));
		System.out.println("Course Name có kết thúc là Online: " +courseName.endsWith("Online"));
		System.out.println("Vị trí của Tutorials trong chuỗi là: " +courseName.indexOf("Tutorials"));
		System.out.println("Thay thế Online bằng Offline: " +courseName.replace("Online", "Offline"));
		System.out.println("Tổng số chữ sốlà: " +countNumber);
		
		

		
		
	}
	
	@Test
	public void TC_03() {
		String name=null;
		Scanner sc = new Scanner(System.in);
		name = sc.nextLine();
		char nameArray[] = name.toCharArray();
		for (int i=nameArray.length-1; i>=0; i--) {
			
			System.out.println(nameArray[i]);
			
		}
		
	}

}
