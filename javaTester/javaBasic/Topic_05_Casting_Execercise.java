package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_05_Casting_Execercise {
	protected String studentName;
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void showStudentName() {
		System.out.println("Student Name: " + studentName);
	}
	public static void main(String[] args) {
//		Topic_05_Casting_Execercise firstStudent = new Topic_05_Casting_Execercise();
//		Topic_05_Casting_Execercise secondStudent = new Topic_05_Casting_Execercise();
//		
//		firstStudent.setStudentName("Thuy Van");
//		secondStudent.setStudentName("Thuy Tien");
//		
//		firstStudent.showStudentName();
//		secondStudent.showStudentName();
//		
//		//ép kiểu
//		firstStudent = secondStudent;
//		firstStudent.showStudentName();
//		secondStudent.showStudentName();
//		
//		secondStudent.setStudentName("Hung Phat");
//		firstStudent.showStudentName();
//		secondStudent.showStudentName();
		
		int a, b;
		System.out.println("Nhập giá trị a và b: ");
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		
		
//		boolean status = (a>b)?true:false;
//		System.out.println(status);
		
		if(a>b) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
}
}